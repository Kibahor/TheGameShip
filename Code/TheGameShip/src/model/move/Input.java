package model.move;

public abstract class Input implements IInput{
    //Quand la boucle la notifie
    public abstract void update() throws Exception;
}
