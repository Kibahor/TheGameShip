package model;

import javafx.beans.property.DoubleProperty;
import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.IEntity;
import model.entity.Player;
import model.move.Input;
import model.move.Keyboard;
import model.move.MovePlayer;

public class GameManager {

    private Boucle boucle;
    private Thread thread;
    private final EntityManager entityManager;
    //List Monde
    //ViewManager ?

    public GameManager() {
        entityManager=new EntityManager();
        boucle = new Boucle(50);
        thread = new Thread(boucle);
        entityManager.add(new Player("file://test.jpg","Vaisseau",100,100,40,5, 10, 10)); //DEBUG
        entityManager.add(new Entity("file://test.jpg","Obstacle","Obstacle",300,300,20));//DEBUG
    }

    public void start() {
        try {
            Input input=new Keyboard(new MovePlayer(entityManager.getEntity("Vaisseau"))); //DEBUG
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
}
