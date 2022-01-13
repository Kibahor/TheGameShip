package model;

import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableSet;
import model.collider.Collider;
import model.collider.ICollider;
import model.entity.*;
import model.move.IMove;
import model.move.Input;
import model.move.Keyboard;
import model.move.MovePlayer;

public class GameManager implements IShoot,Observateur {

    private Boucle boucle;
    private Thread thread;
    private final EntityManager entityManager;
    private IMove move;
    private ICollider collider;
    private Player player;
    //Shoot
    //TODO:Voir si il faut faire autrement pour la gestion des tirs (list obsvervable et quand ajout d'un tir MoveShoot.update() (qui sera abonner a la boucle))
    //TODO: Limite le nombre de tirs créer par seconde (par exemple mettre un timer)
    @Override public void addShoot(String sprite, double radius){
        entityManager.add(new Shoot(player.getId(),sprite, player.getX()+radius+5, player.getY(), radius,1));
        System.out.println("Shoot Add on player : "+player.getName());//DEBUG
    }
    //List Monde
    //ViewManager ?

    public GameManager() {
        entityManager = new EntityManager();
        boucle = new Boucle(50);
        thread = new Thread(boucle);
        player = new Player("file://test.jpg","Vaisseau",100,360,20,5, 10,10); //DEBUG
        //TODO:ICI tu abonne une méthode a la boucle
    }

    //DEBUG
    public void initEntity(){
        entityManager.add(player); //DEBUG
        entityManager.add(new Entity("file://test.jpg","Obstacle1","Obstacle",500,360,50,5));//DEBUG
    }

    public void start() {
        try {
            move = new MovePlayer();
            collider = new Collider(this);
            Input input = new Keyboard(this);
            boucle.subscribe(input); //DEBUG
        }
        catch(Exception err) {
            err.printStackTrace();
        }
        thread.start(); //DEBUG
    }

    public void exit() {
        boucle.StopBoucle();
        thread.stop(); //TODO: Voir si il n'y a pas un autre moyen car deprecated
    }

    public void BindLifeBar(String entityName, DoubleProperty hp) {
        try {
            IEntity e = entityManager.getEntity((entityName));
            hp.bind(((IHasLife)e).hpProperty()); //TODO: vérifier que c'est castable
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void movePlayer (String key) {
        //TODO: Au lieu de passer une entite on peut passer le strict minimum (,y,radius)
        switch (key) {
            case "UP", "Z" -> move.up(player,collider);
            case "LEFT", "Q" -> move.left(player,collider);
            case "DOWN", "S" -> move.down(player,collider);
            case "RIGHT", "D" -> move.right(player,collider);
            case "SPACE" -> addShoot("file://f",10);
        }
    }

    public ObservableSet<IEntity> getSetEntity(){
        return entityManager.getSetEntity();
    }

    @Override
    public void update() {
        for(IEntity e : getSetEntity()) {
            if (e.getType().equals("Shoot")) {
                move.left(e, collider);
            }
        }
    }
}
