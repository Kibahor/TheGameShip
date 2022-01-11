package model.entity;

import java.net.URISyntaxException;
import java.util.UUID;

public class Shoot extends Entity{

    public Shoot(String sprite, double x, double y, double radius) throws URISyntaxException {
        super(sprite,"Shoot","Shoot", x, y, radius);
    }
}
