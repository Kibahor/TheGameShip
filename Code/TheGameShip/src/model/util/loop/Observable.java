package model.util.loop;

import java.util.LinkedList;

public class Observable {

    private final LinkedList<IObserver> observers = new LinkedList<>();

    public void subscribe(IObserver listener){
        observers.add(listener);
    }

    public void unsubscribe(IObserver listener){
        observers.remove(listener);
    }

    public void notifier() {
        for (var observateur : observers) {
            observateur.update();
        }
    }
}