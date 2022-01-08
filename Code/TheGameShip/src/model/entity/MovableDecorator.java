package model.entity;

public class MovableDecorator extends EntityDecorator implements IEntityMovable {

    float speedX;
    float speedY;

    public MovableDecorator(IEntity e, float speedX, float speedY) {
        super(e);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void printDecorationName() {
        entity.printDecorationName();
        System.out.print("Movable "); //DEBUG
        // ...
    }

    @Override
    public float getSpeedX() { return speedX; }
    @Override
    public void setSpeedX(float speedX) { this.speedX = speedX; }
    @Override
    public float getSpeedY() { return speedY; }
    @Override
    public void setSpeedY(float speedY) { this.speedX = speedY; }
}
