package model;

import javafx.beans.property.DoubleProperty;
import model.collider.Collider;
import model.collider.ICollider;
import model.entity.*;
import model.move.IMove;
import model.move.Input;
import model.move.Keyboard;
import model.move.MovePlayer;

public class GameManager {

    private Boucle boucle;
    private Thread thread;
    private final EntityManager entityManager;
    private IMove move;
    private ICollider collider;
    private Player player;
    //List Monde
    //ViewManager ?

    public GameManager() {
        entityManager=new EntityManager();
        boucle = new Boucle(50);
        thread = new Thread(boucle);
        player=new Player("file://test.jpg","Vaisseau",100,300,40,5, 10, 10); //DEBUG
        entityManager.add(player); //DEBUG
        entityManager.add(new Entity("file://test.jpg","Obstacle","Obstacle",300,300,20));//DEBUG
        //TODO:ICI tu abonne une méthode a la boucle
    }

    public void start() {
        try {
            move=new MovePlayer();
            collider= new Collider();
            Input input=new Keyboard(this);
            boucle.subscribe(input); //DEBUG
        } catch(Exception err) {
            err.printStackTrace();
        }
        thread.start(); //DEBUG
    }

    public void exit() {
        boucle.StopBoucle();
        thread.stop(); //TODO: Voir si il n'y a pas un autre moyen car deprecated
    }

    public void BindProperties(String entityName,DoubleProperty x, DoubleProperty y, DoubleProperty radius) {
        try {
            IEntity e = entityManager.getEntity(entityName);
            x.bind(e.xProperty());
            y.bind(e.yProperty());
            radius.bind(e.hitbox_radiusProperty());
        }
        catch(Exception err) {
            err.printStackTrace();
        }
    }

    public void movePlayer(String key){
                switch (key) {
                    case "UP", "Z" -> move.up(player,collider);
                    case "LEFT", "Q" -> move.left(player,collider);
                    case "DOWN", "S" -> move.down(player,collider);
                    case "RIGHT", "D" -> move.right(player,collider);
                    case "SPACE" -> move.shoot(player,collider); //TODO: Faire ça ailleur !
                }
    }
}
