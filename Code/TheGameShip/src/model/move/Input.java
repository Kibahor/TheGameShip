package model.move;

import model.Observateur;

public abstract class Input implements Observateur {
    //Quand la boucle la notifie
    public abstract void update();
}
