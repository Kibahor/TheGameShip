package model;

import javafx.collections.ObservableSet;
import model.entity.*;

import java.util.Collection;

public class GameManager implements IHasEntityCollection{

    //TODO : Faire une liste de boucle pour avoir un point d'extentibilité et cela éviterais de la duplication de code
    Boucle boucle1;
        public Boucle getBoucle1() {return boucle1;}

    Thread thread1;

    Boucle boucle2;
        public Boucle getBoucle2() {return boucle2;}

    Thread thread2;

    //TODO: Faire une List de Monde et récupérer celui qui va être choisis
    ILevel level1;
        @Override public Collection<IEntity> getUnusedEntityCollection() {return ((IHasEntityCollection)level1).getUnusedEntityCollection();}
        @Override public Collection<IEntity> getUsedEntityCollection() {return ((IHasEntityCollection)level1).getUsedEntityCollection();}

    public GameManager(){
        //Boucle
        boucle1 = new Boucle(25); //Temps d'attente entre chaque actualisation de sprite du joueur et déplacement joueur
        thread1 = new Thread(boucle1);

        boucle2 =new Boucle(200); //Temps d'attente entre chaque tire ("SPACE")
        thread2 = new Thread(boucle2);

        //Level
        level1=new Level1(this);
    }
    //TODO: init,start,exit doit être des méthode qui notifie tout ces abonnés (par rapport a stage)
    public void init() throws Exception{
        level1.init();
    }

    public void start() throws Exception {
        thread1.start();
        thread2.start();
        level1.start();
    }

    public void exit() throws Exception {
        level1.exit();
        boucle1.StopBoucle();
        thread1.stop();
        boucle2.StopBoucle();
        thread2.stop(); //TODO: Voir si il n'y a pas un autre moyen car deprecated
    }
}
