package model;

import javafx.beans.property.DoubleProperty;
import model.entity.EntityManager;
import model.entity.IEntity;
import model.entity.Player;
import model.move.Input;
import model.move.Keyboard;
import model.move.MovePlayer;

public class GameManager {

    private Boucle boucle;
    private Thread thread;
    private EntityManager entityManager;
    boolean isStart;
        public boolean isStart() { return isStart; }
    //List Monde
    //ViewManager ?

    public GameManager() {
        entityManager=new EntityManager();
        boucle = new Boucle(50);
        thread = new Thread(boucle);
        isStart=false;
        entityManager.add(new Player("file://test.jpg","Vaisseau",100,100,40,5, 20, 20)); //DEBUG
    }

    public void start() {
        try {
            Input input=new Keyboard(new MovePlayer((Player) entityManager.getEntity("Vaisseau"))); //DEBUG
            boucle.subscribe(input); //DEBUG
        }
        catch(Exception err) {
            err.printStackTrace();
        }
        thread.start(); //DEBUG
        isStart=true;
    }

    public void exit() {
        boucle.StopBoucle();
        thread.stop();
    }

    public void BindPlayerProperties(DoubleProperty x, DoubleProperty y, DoubleProperty radius) {
        try {
            IEntity e = entityManager.getEntity("Vaisseau");
            x.bind(e.xProperty());
            y.bind(e.yProperty());
            radius.bind(e.hitbox_radiusProperty());
        }
        catch(Exception err) {
            err.printStackTrace();
        }
    }
}
