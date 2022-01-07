package model.entity;

public class TakePowerUp extends EntityDecorator {

    int duration;

    public TakePowerUp(IEntity IEntity, int duration)
    {
        super(IEntity);
        this.duration = duration;
    }

    @Override
    public void draw() {
        decoratedIEntity.draw();
        System.out.print("TakePowerUp"); //DEBUG
        // ...
    }

    public int getDuration() { return duration; }
    public void setDuration() { this.duration = duration; }
}

