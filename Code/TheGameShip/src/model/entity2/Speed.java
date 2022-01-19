package model.entity2;

public class Speed extends Componement {
    private float speedX;
        public float getSpeedX() {
        return speedX;
    }
        public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    private float speedY;
        public float getSpeedY() {
        return speedY;
    }
        public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    protected Speed(float speedX, float speedY){
        super(EType.Speed);
        setSpeedX(speedX);
        setSpeedY(speedY);
    }

    public static Speed cast(IHasComponements e){
            return (Speed) e.getComponement(EType.Speed);
    }
}
