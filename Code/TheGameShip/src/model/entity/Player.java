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

    public Player(String name, String sprite, double height, double width) {
        super(name, sprite, EType.Player, height, width, 5, 50, 500);
        setSpeedX(15);
        setSpeedY(10);
    }

    public Player(String name, String sprite, double height, double width, double hp, double x, double y, float speedX, float speedY) {
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
        setSpeedX(15);
        setSpeedY(10);
    }
}