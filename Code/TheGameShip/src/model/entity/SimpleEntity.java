package model.entity;

import java.net.URI;
import java.util.UUID;

public class SimpleEntity implements Entity {
    private UUID id;
    private URI sprite;
    private double x;
    private double y;
    private String nom;
    private String type;
    private double hitbox_radius;

    public SimpleEntity(URI sprite, String nom, String type) {
        this.id = UUID.randomUUID();
        this.sprite = sprite;
        this.nom = nom;
        this.type = type;
        this.hitbox_radius = 10;
    }

    public SimpleEntity(URI sprite, String nom, String type, double x, double y, double hitbox_radius) {
        new SimpleEntity(sprite,nom,type);
        this.x = x;
        this.y = y;
        this.hitbox_radius=hitbox_radius;
    }
    @Override
    public void draw() {
        System.out.print("SimpleEntity "); //DEBUG
    }

    @Override
    public String toString() {
        return "\nId : "+id.toString() + "\nNom : "+nom + "\nType : "+type + "\nSprite : "+sprite.toString() + "\nX : "+ x + "\nY : "+ y+ "\nRadius : "+ hitbox_radius;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Entity obj) {
        return super.equals(obj);
    }

    public UUID getId() {return id;}

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

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public double getHitbox_radius() {
        return hitbox_radius;
    }
}
