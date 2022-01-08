package model.entity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class Entity implements IEntity {
    private UUID id;
    private URI sprite;
    private double x;
    private double y;
    private String name;
    private String type;
    private final double hitbox_radius;

    public Entity(String sprite, String nom, String type) throws URISyntaxException {
        this.id = UUID.randomUUID();
        this.sprite = new URI(sprite);
        this.name = nom;
        this.type = type;
        this.hitbox_radius = 10;
    }

    public Entity(String sprite, String nom, String type, double x, double y, double hitbox_radius) throws URISyntaxException {
        new Entity(sprite,nom,type);
        this.x = x;
        this.y = y;
        this.hitbox_radius=hitbox_radius;
    }

    @Override
    public void printDecorationName() {
        System.out.print("Entity "); //DEBUG
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    //TODO:Equals trop simple, le refaire bien
    @Override
    public boolean equals(IEntity obj) {
        return super.equals(obj);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nId : "+id.toString() + "\nNom : "+ name + "\nType : "+type + "\nSprite : "+sprite.toString() + "\nX : "+ x + "\nY : "+ y+ "\nRadius : "+ hitbox_radius;
    }

    public URI getSprite() {
        return sprite;
    }

    public void setSprite(URI sprite) {
        this.sprite = sprite;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHitbox_radius() {
        return hitbox_radius;
    }
}
