package model.entity;

import java.util.UUID;

public class Shoot extends Entity {
    private static int nbShoot=0;
    private UUID ownerId;
        public UUID getOwnerId() {return ownerId;}
        public void setOwnerId(UUID ownerId) {this.ownerId=ownerId;}

    public Shoot() {
        super(Integer.toString(nbShoot),"vide","Shoot",10,1);
        nbShoot++;
    }

    public Shoot(String sprite, double hitbox_radius, double hp, double x, double y,UUID ownerId) {
        super(Integer.toString(nbShoot),sprite,"Shoot",hitbox_radius,hp,x,y,true);
        setOwnerId(ownerId);
        nbShoot++;
    }
}
