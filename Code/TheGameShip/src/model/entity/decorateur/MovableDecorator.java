package model.entity.decorateur;

import model.entity.IEntity;

public class MovableDecorator extends EntityDecorator {

    private float speedX;
    private float speedY;

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


    public float getSpeedX() { return speedX; }

    public void setSpeedX(float speedX) { this.speedX = speedX; }

    public float getSpeedY() { return speedY; }

    public void setSpeedY(float speedY) { this.speedX = speedY; }
}
