package model;

import javafx.collections.ObservableSet;
import model.collider.Collider;
import model.collider.ColliderShoot;
import model.collider.ICollider;
import model.entity.*;
import model.move.*;

import java.util.ArrayList;

public class GameManager{

    Boucle boucle1;
        public Boucle getBoucle1() {return boucle1;}

    Thread thread1;

    Boucle boucle2;
        public Boucle getBoucle2() {return boucle2;}

    Thread thread2;

    //TODO: Faire une List de Monde et récupérer celui qui va être choisis
    ILevel level1;

    public GameManager(){
        //Boucle
        boucle1 = new Boucle(25); //Temps d'attente entre chaque actualisation de sprite du joueur et déplacement joueur
        thread1 = new Thread(boucle1);

        boucle2 =new Boucle(200); //Temps d'attente entre chaque tire ("SPACE")
        thread2 = new Thread(boucle2);

        //Level
        level1=new Level1(this);
    }

    public void init(){
        level1.init();
    }

    public void start() {
        try {
            thread1.start();
            thread2.start();
        } catch(Exception err) {
            err.printStackTrace();
        }
        level1.start();
    }

    public void exit() {
        level1.exit();
        boucle1.StopBoucle();
        thread1.stop();
        boucle2.StopBoucle();
        thread2.stop(); //TODO: Voir si il n'y a pas un autre moyen car deprecated
    }


    public ObservableSet<IEntity> getSetEntity(){
        return level1.getSetEntity();//TODO: mettre le level actuel à la place
    }


}
