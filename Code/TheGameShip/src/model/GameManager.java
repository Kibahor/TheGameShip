package model;

import javafx.collections.ObservableSet;
import model.collider.Collider;
import model.collider.ColliderShoot;
import model.collider.ICollider;
import model.entity.*;
import model.move.*;

import java.util.ArrayList;

public class GameManager implements Observateur {

    private Boucle boucle;
    private Thread thread;
    private final EntityManager entityManager;
    private IMove move;
    private ICollider colliderShoot;
    private IMove movePlayer;
    private ICollider collider;
    private Player player;
    private ArrayList<Shoot> shoots;//DEBUG
    //List Monde
    //ViewManager ?

    public GameManager() {
        entityManager = new EntityManager();
        boucle = new Boucle(50);
        thread = new Thread(boucle);
        player = new Player("Vaisseau","file://test.jpg",100,360,20,5,10,10,true); //DEBUG
        shoots=new ArrayList<>();//DEBUG
        boucle.subscribe(this);
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
            move=new Move();
            colliderShoot=new ColliderShoot();
            movePlayer = new MovePlayer();
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

    public void movePlayer (String key) {
        //TODO: Au lieu de passer une entite on peut passer le strict minimum (,y,radius)
        switch (key) {
            case "UP", "Z" -> movePlayer.up(player,collider);
            case "LEFT", "Q" -> movePlayer.left(player,collider);
            case "DOWN", "S" -> movePlayer.down(player,collider);
            case "RIGHT", "D" -> movePlayer.right(player,collider);
            case "SPACE" -> {
                Shoot s=getEmptyShoot();
                if(s!=null) {
                    s.setOwnerId(player.getId());
                    s.setX(player.getX() + player.getHitbox_radius() + getEmptyShoot().getHitbox_radius() + 10);
                    s.setY(player.getY());
                    s.setVisible(true);
                    shoots.add(s);
                    System.out.println("Shoot add !");
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
        for(IEntity e : shoots) {
            move.right(e, colliderShoot);
        }
    }
}
