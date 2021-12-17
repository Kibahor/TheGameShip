package model.entity;

public class MovableDecorator extends EntityDecorator {

    float speedX;
    float speedY;

    public MovableDecorator(Entity entity, float speedX, float speedY) {
        super(entity);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void draw() {
        decoratedEntity.draw();
        System.out.print("Movable "); //DEBUG
        // ...
    }

    public float getSpeedX() { return speedX; }
    public void setSpeedX() { this.speedX = speedX; }

    public float getSpeedY() { return speedY; }
    public void setSpeedY() { this.speedX = speedY; }
}
