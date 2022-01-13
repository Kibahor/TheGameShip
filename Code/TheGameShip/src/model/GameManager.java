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

    private Boucle boucleShoot;
    private Thread threadShoot;
    private IMove move;
    private ICollider colliderShoot;

    private ArrayList<IEntity> usedEntity=new ArrayList<>();//DEBUG
    //List Monde
    //ViewManager ?
    //TODO: Mieux gérer entités (visible vs non visible) (Gérer efficaement les deux collection)
    public GameManager() {
        entityManager = new EntityManager();
        player = new Player("Vaisseau","file://test.jpg",100,360,20,5,5,5,true); //DEBUG
    }

    //DEBUG
    public void initEntity(){
        for(int i=0;i<50;i++){
            entityManager.add(new Shoot());
        }
        entityManager.add(player); //DEBUG
        entityManager.add(new Entity("Obstacle1","file://test.jpg","Obstacle",50,5));//DEBUG
    }

    public void start() {
        try {
            boucle = new Boucle(25);
            thread = new Thread(boucle);
            movePlayer = new MovePlayer();
            collider = new Collider(this);
            boucle.subscribe(new Keyboard(this, new String[]{"UP", "DOWN", "LEFT", "RIGHT", "Z", "Q", "S", "D"}));
            thread.start(); //DEBUG

            boucleShoot=new Boucle(300);
            threadShoot = new Thread(boucleShoot);
            move=new Move();
            colliderShoot=new ColliderShoot();
            boucleShoot.subscribe(new Keyboard(this, new String[]{"SPACE"}));
            boucle.subscribe(this);
            threadShoot.start(); //DEBUG
        }
        catch(Exception err) {
            err.printStackTrace();
        }

    }

    public void exit() {
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
        for(IEntity e : usedEntity) {
            if(e.getType().equals("Shoot")){
                move.right(e, colliderShoot);
                if(colliderShoot.isCollision(e,"RIGHT")){
                    ((Shoot) e).reset();
                    usedEntity.remove(e); //TODO:ConccurentException : faire des méthodes asynchrone
                }
            }
        }
    }
}
