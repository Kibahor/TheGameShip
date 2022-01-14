package model;

import javafx.collections.ObservableSet;
import model.collider.Collider;
import model.collider.ColliderShoot;
import model.collider.ICollider;
import model.entity.*;
import model.move.IMove;
import model.move.Keyboard;
import model.move.MoveSpeed;

import java.util.ArrayList;

public class Level1 implements ILevel,Observateur {

    private GameManager gameManager;

    private EntityManager entityManager;
        @Override public ObservableSet<IEntity> getSetEntity(){
        return entityManager.getSetEntity();
    }
    private volatile ArrayList<IEntity> usedShoot =new ArrayList<>();//DEBUG
    private Player player;

    //private IMove move;
    private IMove moveSpeed;

    private ICollider collider;
    private ICollider colliderShoot;

    public Level1(GameManager gameManager) {
        this.gameManager = gameManager;
        entityManager = new EntityManager();
    }

    @Override
    public void init() {
        //ENTITIES
        player = new Player("Vaisseau","file://test.jpg",100,360,20,5,5,5,true); //DEBUG
        int nbShootPreGenerate=100;
        for(int i=0; i < nbShootPreGenerate; i++){
            entityManager.add(new Shoot());
        }
        entityManager.add(player);
        entityManager.add(new Entity("Obstacle1","file://test.jpg", Type.Obstacle,50,5));

        moveSpeed = new MoveSpeed();

        collider = new Collider(this);
        colliderShoot = new ColliderShoot();
    }

    @Override
    public void start() {
        try {
            gameManager.boucle1.subscribe(this);
            gameManager.boucle1.subscribe(new Keyboard(this, new String[]{"UP", "DOWN", "LEFT", "RIGHT", "Z", "Q", "S", "D"}));
            gameManager.boucle2.subscribe(new Keyboard(this, new String[]{"SPACE"}));
        }
        catch(Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void exit() {
        //TODO: Unscribe les événement ajouter
    }

    @Override
    public void update() {
        try {
            for (IEntity e : usedShoot) {
                if (e.getType().equals(Type.Shoot)) {
                    moveSpeed.right(e, colliderShoot);
                    if (colliderShoot.isCollision(e, "RIGHT")) {
                        ((Shoot) e).reset();
                        usedShoot.remove(e);
                    }
                }
            }
        }
        catch (Exception err) {
            err.printStackTrace();
            //TODO:ConccurentException : gérer la gestion concurrente des ressources entre le thread principal et la boucle : https://www.jmdoudoux.fr/java/dej/chap-acces_concurrents.htm
        }
    }

    public void movePlayer (String key) {
        switch (key) {
            case "UP", "Z" -> moveSpeed.up(player,collider);
            case "LEFT", "Q" -> moveSpeed.left(player,collider);
            case "DOWN", "S" -> moveSpeed.down(player,collider);
            case "RIGHT", "D" -> moveSpeed.right(player,collider);
            case "SPACE" -> {
                Shoot s = getEmptyShoot();
                if (s != null) {
                    s.applyToEntity(player);
                    usedShoot.add(s);
                }
            }
        }
    }

    public Shoot getEmptyShoot() {
        for (IEntity e:getSetEntity()) {
            if (e.getType().equals(Type.Shoot)) {
                if (!e.getVisible()) {
                    return (Shoot)e;
                }
            }
        }
        return null;
    }
}
