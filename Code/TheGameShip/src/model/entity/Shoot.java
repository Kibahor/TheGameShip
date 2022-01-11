package model.entity;

import java.net.URISyntaxException;
import java.util.UUID;

public class Shoot extends Entity{
    private UUID ownerId;

    public Shoot(UUID ownerId,String sprite, double x, double y, double radius){
        super(sprite,"Shoot","Shoot", x, y, radius);
        this.ownerId=ownerId;
    }
}
