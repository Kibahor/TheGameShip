package model.entity;

import java.util.UUID;

public class Shoot extends Entity implements IMovable {

    private static int nbShoot=0;
    private UUID ownerId;
        public UUID getOwnerId() {return ownerId;}
        public void setOwnerId(UUID ownerId) {this.ownerId=ownerId;}

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

    public Shoot() {
        super(Integer.toString(nbShoot),"vide",Type.Shoot,10,1);
        setSpeedX(5);
        setSpeedY(5);
        nbShoot++;
    }

    public Shoot(String sprite, double hitbox_radius, double hp, double x, double y,float speedX,float speedY,UUID ownerId) {
        super(Integer.toString(nbShoot),sprite,Type.Shoot,hitbox_radius,hp,x,y,true);
        setOwnerId(ownerId);
        setSpeedX(speedX);
        setSpeedY(speedY);
        nbShoot++;
    }

    public void applyToEntity(IEntity e){
        setOwnerId(e.getId());
        setX(e.getX() + e.getHitbox_radius() + getHitbox_radius() + 10);
        setY(e.getY());
        setVisible(true);
    }
    public void reset(){
        setOwnerId(null);
        setX(-200);
        setY(-200);
        setVisible(false);
    }
}
