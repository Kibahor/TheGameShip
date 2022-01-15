package model.entity;

import java.util.UUID;

public class Shoot extends Entity implements IMovable,IShoot { //Todo : Ajouter Interface IShoot avec une méthode cast (comme IHasLocation)

    private static int nbShoot=0;
    private UUID ownerId;
        @Override public UUID getOwnerId() {return ownerId;}
        @Override public void setOwnerId(UUID ownerId) {this.ownerId=ownerId;}

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
        super("Shoot"+Integer.toString(nbShoot),"vide", EType.Shoot,10,1);
        setSpeedX(5);
        setSpeedY(5);
        nbShoot++;
    }

    public Shoot(String sprite, double hitbox_radius, double hp, double x, double y,float speedX,float speedY,UUID ownerId) {
        super(Integer.toString(nbShoot),sprite, EType.Shoot,hitbox_radius,hp,x,y);
        setOwnerId(ownerId);
        setSpeedX(speedX);
        setSpeedY(speedY);
        nbShoot++;
    }

    public void applyToEntity(IEntity e) throws Exception {
        if(ownerId!=null){
                throw new Exception("Le tir appartient déjà a une entité qui a pour id : "+getOwnerId().toString());
        }else if(!(e instanceof IHasLocation)){
            throw new Exception("Impossible d'appliquer l'entité \""+e.getName()+"\" au Shoot \""+this.getName()+"\" car elle n'implémente pas IHasLocation !");
        }
        setOwnerId(e.getId());

        setX(((IHasLocation)e).getX() + ((IHasLocation)e).getHitbox_radius() + getHitbox_radius() + 10);
        setY(((IHasLocation)e).getY());
    }

    public void reset(){
        setOwnerId(null);
        setX(-200);
        setY(-200);
    }
}
