package model.entity;

import java.net.URI;
import java.util.UUID;

public class SimpleEntity implements Entity {
    private UUID id;
    private URI sprite;
    private float X;
    private float Y;
    private String nom;
    private String type;

    public SimpleEntity(URI sprite, float x, float y, String nom, String type) {
        this.id = UUID.randomUUID();
        this.sprite = sprite;
        X = x;
        Y = y;
        this.nom = nom;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Nom :"+nom+" ID :"+id.toString();
    }

    @Override
    public void draw() {
        System.out.println("Entity: SimpleEntity\n");
    }
}
