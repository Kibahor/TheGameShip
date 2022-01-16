package model.entity;

import javafx.beans.property.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

//todo : (Changer fonctionnement des interfaces d'entité) Voir si il ne faut l'appliquer qu'aux interfaces (au lieu des entités)
//(il faudrait créer une classe abstraite par interface concerner et redéfinire reset() dedans au lieu de le faire dans entité)
//Les interface deviendrait package private et seul les class abstraite créé plus tôt pourrait les implémenter
//Ensuite au lieu d'implémenter une interface dans l'entités on étend de la classe abstraite (pas sûr il faut y réfléchir avant de le faire)

public class Entity implements IEntity, IHasLocation, IHasLife{

    //IEntity
    private UUID id;
        @Override public UUID getId(){return id;}

    private String name;
        @Override public String getName() { return name; }

    private final EType type;
        @Override public EType getType() { return type;}

    private URI sprite;
        @Override public URI getSprite() {return sprite;}
        @Override public void setSprite(URI sprite) {this.sprite = sprite;}

    private BooleanProperty visible=new SimpleBooleanProperty();
        @Override public boolean getVisible(){return visible.get();}
        @Override public void setVisible(boolean b){visible.set(b);}
        @Override public BooleanProperty getVisibleBooleanProperty(){return visible;}

    //IHasLocation
    private final DoubleProperty x = new SimpleDoubleProperty();
        @Override public double getX() {return x.get();}
        @Override public void setX(double x) {this.x.set(x);}
        @Override public DoubleProperty xProperty(){return x;}

    private final DoubleProperty y = new SimpleDoubleProperty();
        @Override public double getY() { return y.get(); }
        @Override public void setY(double y) { this.y.set(y); }
        @Override public DoubleProperty yProperty() { return y; }

    private final DoubleProperty width = new SimpleDoubleProperty();
        @Override public double getWidth() { return width.get(); }
        @Override public void setWidth(double width) { this.width.set(width); }
        @Override public DoubleProperty widthProperty() { return width; }

    private final DoubleProperty height = new SimpleDoubleProperty();
        @Override public double getHeight() { return height.get(); }
        @Override public void setHeight(double height) { this.height.set(height); }
        @Override public DoubleProperty heightProperty() { return height; }

    //IHasLife
    private final DoubleProperty hp = new SimpleDoubleProperty();
        @Override public double getHp() { return hp.get(); }
        @Override public void setHp(double hp) { this.hp.set(hp); }
        @Override public void incrementHp() { setHp(getHp()+1); }
        @Override public void decreaseHp() { setHp(getHp()-1); }
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
        setHeight(10);
        setWidth(10);
        try {this.sprite = new URI(sprite);}catch(URISyntaxException err){err.printStackTrace();}
        setVisible(false);

        //IHasLife
        setHp(10);
        setDead(false);
    }

    public Entity(String name, String sprite, EType type, double height, double width, double hp){
        this(name, type, sprite);
        setHeight(height);
        setWidth(width);
        setHp(hp);
    }

    public Entity(String name, String sprite, EType type, double height, double width, double hp, double x, double y) {
        this(name, sprite, type, height, width, hp);
        setX(x);
        setY(y);
    }

    //IReset
    @Override
    public void reset() {
        //IEntity (id,name,type,sprite,visible)
        this.id = UUID.randomUUID();
        setVisible(false);

        //IHasLocation (x,y,height,width)
        setX(0);
        setY(0);
        setWidth(10);
        setHeight(10);

        //IHasLife (hp,dead)
        setHp(10);
        setDead(false);
    }


    //Pour le Hashset
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "\nId : "+id.toString() + "\nNom : "+ name + "\nType : "+ type + "\nSprite : "+sprite.toString() + "\nX : "+ getX() + "\nY : "+ getY()+ "\nHeight : "+ getHeight() +"\nWidth : "+ getWidth()+"\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IEntity){
            return ((IEntity) obj).getId().equals(getId());
        }
        return false;
    }
}
