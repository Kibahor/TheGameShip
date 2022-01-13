package model.entity;

import javafx.beans.property.DoubleProperty;

import java.net.URI;

public interface IEntity {
    int hashCode();
    boolean equals(IEntity obj);

    void setX(double x);
    double getX();
    DoubleProperty xProperty();

    void setY(double y);
    double getY();
    DoubleProperty yProperty();

    void setHitbox_radius(double y);
    double getHitbox_radius();
    DoubleProperty hitbox_radiusProperty();

    String getName();
    String getType();

    URI getSprite();
    void setSprite(URI sprite);
}
