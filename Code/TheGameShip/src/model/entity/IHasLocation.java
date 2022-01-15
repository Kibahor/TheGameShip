package model.entity;

import javafx.beans.property.DoubleProperty;

public interface IHasLocation {
    void setX(double x);
    double getX();
    DoubleProperty xProperty();

    void setY(double y);
    double getY();
    DoubleProperty yProperty();

    void setHitbox_radius(double y);
    double getHitbox_radius();
    DoubleProperty hitbox_radiusProperty();

    static IHasLocation cast(IEntity e) throws Exception {
        if(!(e instanceof IHasLocation)){
            throw new Exception("L'Entité \""+e.getName()+"\" n'implémente pas IHasLocation donc il ne peut pas avoir de collisions !");
        }
        return (IHasLocation) e;
    }
}
