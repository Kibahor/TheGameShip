package model.entity;

public class Enemy extends Entity implements IMovable {

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

    public Enemy(String name, String sprite, double height, double width) {
        super(name, sprite, EType.Ennemy, height, width, 5, 1000, 300);
        setSpeedX(5);
        setSpeedY(5);
    }

    public Enemy(String name, String sprite, double height, double width, double hp, double x, double y, float speedX, float speedY) {
        this(name, sprite, height, width);
        setHp(hp);
        setX(x);
        setY(y);
        setSpeedX(speedX);
        setSpeedY(speedY);
    }

    @Override
    public void reset() {
        super.reset();
        //IMovable (speedX,speedY)
        setSpeedX(5);
        setSpeedY(5);
    }
}
