package model.entity;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;

import java.net.URI;
import java.util.UUID;

public interface IEntity {

    UUID getId();

    String getName();

    EType getType();

    //TODO : mettre sa dans une interface IHasLocation et caster avec cette interface a tout les endroit où c'est utiliser avec l'interface IEntity
    void setX(double x);
    double getX();
    DoubleProperty xProperty();

    void setY(double y);
    double getY();
    DoubleProperty yProperty();

    void setHitbox_radius(double y);
    double getHitbox_radius();
    DoubleProperty hitbox_radiusProperty();
    //

    URI getSprite();
    void setSprite(URI sprite);

    boolean getVisible();
    void setVisible(boolean b);
    BooleanProperty getVisibleBooleanProperty();


}
