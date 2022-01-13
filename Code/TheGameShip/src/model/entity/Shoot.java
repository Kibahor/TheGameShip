package model.entity;

import java.util.UUID;

public class Shoot extends Entity {
    private static int nbShoot=0;
    private UUID ownerId;

    public Shoot(UUID ownerId,String sprite, double x, double y, double radius, double hp) {
        super(sprite,Integer.toString(nbShoot),"Shoot", x, y, radius, hp);
        this.ownerId=ownerId;
    }
}
