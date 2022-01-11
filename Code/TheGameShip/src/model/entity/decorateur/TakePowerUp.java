package model.entity.decorateur;

import model.entity.IEntity;

public class TakePowerUp extends EntityDecorator {

    int duration;

    public TakePowerUp(IEntity IEntity, int duration)
    {
        super(IEntity);
        this.duration = duration;
    }

    @Override
    public void printDecorationName() {
        entity.printDecorationName();
        System.out.print("TakePowerUp"); //DEBUG
        // ...
    }

    public int getDuration() { return duration; }
    public void setDuration() { this.duration = duration; }
}

