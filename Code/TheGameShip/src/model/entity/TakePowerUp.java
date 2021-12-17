package model.entity;

public class TakePowerUp extends EntityDecorator {

    int duration;

    public TakePowerUp(Entity entity, int duration)
    {
        super(entity);
        this.duration = duration;
    }

    @Override
    public void draw() {
        decoratedEntity.draw();
        System.out.print("TakePowerUp"); //DEBUG
        // ...
    }

    public int getDuration() { return duration; }
    public void setDuration() { this.duration = duration; }
}

