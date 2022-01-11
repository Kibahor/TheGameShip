package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.Observer;

import static java.lang.Thread.sleep;

public abstract class Boucle implements Runnable, Observable {

    @Override
    public void run()
    {
        // TODO : Il faut créer une méthode qui permet de s'abonner a un eventHandler et notifier tout les abonnés
        while (true) {
            try {
                sleep(50);
                update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update() throws Exception {

    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }

}
