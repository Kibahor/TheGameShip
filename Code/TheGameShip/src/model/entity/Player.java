package model.entity;

public class Player extends Entity implements IMovable {

    //IMovable
    private float speedX;
        @Override public float getSpeedX() {
            return speedX;
        }
        @Override public void setSpeedX(float speedX) {
            this.speedX = speedX;
        }

    private float speedY;
        @Override public float getSpeedY() {
            return speedY;
        }
        @Override public void setSpeedY(float speedY) {
            this.speedY = speedY;
        }

    public Player(String name, String sprite, double x, double y, double hitbox_radius) {
        super(name,sprite, EType.Player ,hitbox_radius,5,x,y);
        setSpeedX(5);
        setSpeedY(10);
    }

    public Player(String name, String sprite, double x, double y, double hitbox_radius, double hp, float speedX, float speedY) {
        this(name, sprite, x, y, hitbox_radius);
        setHp(hp);
        setSpeedX(speedX);
        setSpeedY(speedY);
    }

}