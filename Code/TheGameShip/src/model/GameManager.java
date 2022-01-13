package model;

import javafx.collections.ObservableSet;
import model.collider.Collider;
import model.collider.ColliderShoot;
import model.collider.ICollider;
import model.entity.*;
import model.move.*;

import java.util.ArrayList;

public class GameManager implements Observateur {

    private final EntityManager entityManager;

    private Boucle boucle;
    private Thread thread;
    private IMove movePlayer;
    private ICollider collider;
    private Player player;

    private Boucle boucleInputShoot;
    private Thread threadShoot;
    private ICollider colliderShoot;

    private volatile ArrayList<IEntity> usedEntity=new ArrayList<>();//DEBUG

    //List Monde
    //ViewManager ?
    //TODO: Mieux gérer entités (visible vs non visible) (Gérer efficaement les deux collection)
    public GameManager() {
        entityManager = new EntityManager();
        player = new Player("Vaisseau","file://test.jpg",100,360,20,5,5,5,true); //DEBUG
    }

    //DEBUG
    public void initEntity(){
        int nbShootPreGenerate=100; //DEBUG
        for(int i=0;i<nbShootPreGenerate;i++){
            entityManager.add(new Shoot());
        }
        entityManager.add(player); //DEBUG
        entityManager.add(new Entity("Obstacle1","file://test.jpg","Obstacle",50,5));//DEBUG
    }

    public void start() {
        try {
            boucle = new Boucle(25); //Temps d'attente entre chaque actualisation de sprite du joueur
            thread = new Thread(boucle);
            movePlayer = new MoveSpeed();
            collider = new Collider(this);
            boucle.subscribe(new Keyboard(this, new String[]{"UP", "DOWN", "LEFT", "RIGHT", "Z", "Q", "S", "D"}));


            boucleInputShoot =new Boucle(200); //Temps d'attente entre chaque tire
            boucleInputShoot.subscribe(new Keyboard(this, new String[]{"SPACE"}));
            threadShoot = new Thread(boucleInputShoot);
            colliderShoot=new ColliderShoot();

            Boucle boucleShootUpdate=new Boucle(10); //Temps d'attente entre chaque actualisation de sprite des tirs
            boucleShootUpdate.subscribe(this);
            Thread threadShootUpdate = new Thread(boucleShootUpdate);

            thread.start(); //DEBUG
            threadShoot.start(); //DEBUG
            threadShootUpdate.start();

        }
        catch(Exception err) {
            err.printStackTrace();
        }

    }

    public void exit() {
        boucleInputShoot.StopBoucle();
        thread.stop();
        boucle.StopBoucle();
        thread.stop(); //TODO: Voir si il n'y a pas un autre moyen car deprecated
    }

    public void movePlayer (String key) {
        switch (key) {
            case "UP", "Z" -> movePlayer.up(player,collider);
            case "LEFT", "Q" -> movePlayer.left(player,collider);
            case "DOWN", "S" -> movePlayer.down(player,collider);
            case "RIGHT", "D" -> movePlayer.right(player,collider);
            case "SPACE" -> {
                Shoot s=getEmptyShoot();
                if(s!=null) {
                    s.applyToEntity(player);
                    usedEntity.add(s);
                }
            }
        }
    }
    public Shoot getEmptyShoot(){
        for(IEntity e:getSetEntity()){
            if(e.getType().equals("Shoot")){
                if(!e.getVisible()){
                    return (Shoot)e;
                }
            }
        }
        return null;
    }

    public ObservableSet<IEntity> getSetEntity(){
        return entityManager.getSetEntity();
    }

    @Override
    public void update() {
        try {
            for (IEntity e : usedEntity) {
                if (e.getType().equals("Shoot")) {
                    movePlayer.right(e, colliderShoot);
                    if (colliderShoot.isCollision(e, "RIGHT")) {
                        ((Shoot) e).reset();
                        usedEntity.remove(e);
                    }
                }
            }
        }catch(Exception err){
            //TODO:ConccurentException : gérer la gestion concurrente des ressources entre le thread principal et la boucle : https://www.jmdoudoux.fr/java/dej/chap-acces_concurrents.htm
        }
    }
}
