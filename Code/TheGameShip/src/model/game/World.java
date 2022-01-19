package model.game;

import javafx.collections.ObservableSet;
import javafx.scene.input.KeyEvent;
import launch.Launcher;
import model.entity.IEntity;
import model.util.input.IInput;
import model.util.input.Keyboard;
import model.util.loop.Loop;


public class World implements IEntityCollection {

    private Loop loop;

    private Thread thread;

    private IInput input;
    public IInput getInput() { return input; }

    //TODO: Faire une List de Monde et récupérer celui qui va être choisis
    ILevel currentLevel;
    @Override public ObservableSet<IEntity> getEntityCollection() { return currentLevel.getEntityCollection(); }

    public World() {
        //Boucle
        loop = new Loop(20); //Temps d'attente entre chaque actualisation de sprite du joueur et déplacement joueur
        thread = new Thread(loop);

        //Input
        input = new Keyboard(); //Mettre une autre classe si on veut contrôler le personnage autrement qu'avec le clavier
        Launcher.getStage().addEventFilter(KeyEvent.ANY, (Keyboard)input); //Spécifique au événement de JavaFX

        //Level
        currentLevel = new Level1(loop, input); //Mettre le bon monde
    }

    //TODO: init,start,exit doit être des méthode qui notifie tout ces abonnés (par rapport a stage)
    //Init, instancie les entité ou tout autre chose
    public void init() {
        currentLevel.init();
    }

    public void start() {
        thread.start();
        currentLevel.start();
    }

    public void exit() {
        currentLevel.exit();
        loop.StopBoucle();
        thread.stop();//TODO: Voir si il n'y a pas un autre moyen car deprecated
    }
}