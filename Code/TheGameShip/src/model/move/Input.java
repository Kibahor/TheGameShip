package model.move;

import model.IObserver;

public abstract class Input implements IObserver {
    //Quand la boucle la notifie
    public abstract void update();
}
