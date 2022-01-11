package model.entity;

import java.net.URI;

public interface IEntity {
    int hashCode();
    boolean equals(IEntity obj);

    String getName();
    URI getSprite();
    void setSprite(URI sprite);
    double getX();
    void setX(double x);
    double getY();
    void setY(double y);
    double getHitbox_radius();
}
