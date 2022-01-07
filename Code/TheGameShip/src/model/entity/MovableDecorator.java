package model.entity;

public class MovableDecorator extends EntityDecorator {

    float speedX;
    float speedY;

    public MovableDecorator(IEntity IEntity, float speedX, float speedY) {
        super(IEntity);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void draw() {
        decoratedIEntity.draw();
        System.out.print("Movable "); //DEBUG
        // ...
    }

    public float getSpeedX() { return speedX; }
    public void setSpeedX() { this.speedX = speedX; }

    public float getSpeedY() { return speedY; }
    public void setSpeedY() { this.speedX = speedY; }
}
