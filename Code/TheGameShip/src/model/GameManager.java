package model;

import model.entity.EntityManager;
import model.entity.Player;
import model.move.Input;
import model.move.Keyboard;
import model.move.MovePlayer;

public class GameManager {
    private Boucle boucle;
    private Thread thread;
    private EntityManager entityManager;
        public EntityManager getEntityManager(){return entityManager;}
    boolean isStart;
        public boolean isStart(){return isStart;}
    //List Monde
    //ViewManager ?

    public GameManager(){
        entityManager=new EntityManager();
        boucle = new Boucle(50);
        thread = new Thread(boucle);
        isStart=false;
        entityManager.add(new Player("file://test.jpg","Vaisseau",100,100,80,6, 20, 20)); //DEBUG

    }
    public void start(){
        try{
            Input input=new Keyboard(new MovePlayer((Player) entityManager.getEntity("Vaisseau"))); //DEBUG
            boucle.subscribe(input); //DEBUG
        }catch(Exception err){
            err.printStackTrace();
        }

        thread.start(); //DEBUG
        isStart=true;
    }
    public void exit(){
        boucle.StopBoucle();
        thread.stop();
    }
}
