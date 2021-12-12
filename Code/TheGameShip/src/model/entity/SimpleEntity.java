package model.entity;

import java.net.URI;
import java.util.UUID;

public class SimpleEntity implements Entity {
    private UUID id;
    private URI sprite;
    private float x;
    private float y;
    private String nom;
    private String type;

    public SimpleEntity(URI sprite, float x, float y, String nom, String type) {
        this.id = UUID.randomUUID();
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.nom = nom;
        this.type = type;
    }

    @Override
    public String toString() {
        return "\nId : "+id.toString() + "\nNom : "+nom + "\nType : "+type + "\nSprite : "+sprite.toString() + "\nX : "+ x + "\nY : "+ y;
    }

    @Override
    public void draw() {
        System.out.print("SimpleEntity "); //DEBUG
    }
}
