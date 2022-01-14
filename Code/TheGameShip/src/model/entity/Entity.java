package model.entity;

import javafx.beans.property.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class Entity implements IEntity,IHasLife { //TODO: Faire une énumération de type (Player, shoot, Ennemie, Obstacle ?)

    //IEntity
    private final UUID id;
        @Override public UUID getId(){return id;}

    private final String name;
        @Override public String getName() { return name; }

    private final EType type;
        @Override public EType getType() { return type;}

    private final DoubleProperty x = new SimpleDoubleProperty();
        @Override public double getX() {return x.get();}
        @Override public void setX(double x) {this.x.set(x);}
        @Override public DoubleProperty xProperty(){return x;}

    private final DoubleProperty y = new SimpleDoubleProperty();
        @Override public double getY() { return y.get(); }
        @Override public void setY(double y) { this.y.set(y); }
        @Override public DoubleProperty yProperty() { return y; }

    private final DoubleProperty hitbox_radius = new SimpleDoubleProperty();
        @Override public double getHitbox_radius() { return hitbox_radius.get(); }
        @Override public void setHitbox_radius(double hitbox_radius) { this.hitbox_radius.set(hitbox_radius); }
        @Override public DoubleProperty hitbox_radiusProperty() { return hitbox_radius; }

    private URI sprite;
        @Override public URI getSprite() {return sprite;}
        @Override public void setSprite(URI sprite) {this.sprite = sprite;}

    private BooleanProperty visible=new SimpleBooleanProperty();
        @Override public boolean getVisible(){return visible.get();}
        @Override public void setVisible(boolean b){visible.set(b);}
        @Override public BooleanProperty getVisibleBooleanProperty(){return visible;}

    //IHasLife
    private final DoubleProperty hp = new SimpleDoubleProperty();
        @Override public double getHp() { return hp.get(); }
        @Override public void setHp(double hp) { this.hp.set(hp); }
        @Override public DoubleProperty hpProperty() { return hp; }

    private boolean isDead;
        @Override public boolean isDead(){return isDead;}
        @Override public void setDead(boolean dead){isDead=dead;}

    public Entity(String name, EType type, String sprite) {
        //IEntity
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        setX(100);
        setY(100);
        setHitbox_radius(10);
        try {this.sprite = new URI(sprite);}catch(URISyntaxException err){err.printStackTrace();}
        setVisible(false);

        //IHasLife
        setHp(10);
        setDead(false);
    }

    public Entity(String name, String sprite, EType type, double hitbox_radius, double hp){
        this(name, type, sprite);
        setHitbox_radius(hitbox_radius);
        setHp(hp);
    }

    public Entity(String name, String sprite, EType type, double hitbox_radius, double hp, double x, double y, boolean visible) {
        this(name, sprite, type, hitbox_radius, hp);
        setX(x);
        setY(y);
        setVisible(visible);
    }

    //Pour le Hashset
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "\nId : "+id.toString() + "\nNom : "+ name + "\nType : "+ type + "\nSprite : "+sprite.toString() + "\nX : "+ x + "\nY : "+ y+ "\nRadius : "+ hitbox_radius;
    }
}
