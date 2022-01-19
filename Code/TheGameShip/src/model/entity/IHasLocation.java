package model.entity;

import javafx.beans.property.DoubleProperty;

public interface IHasLocation {

    void setX(double x);
    double getX();
    DoubleProperty xProperty();

    void setY(double y);
    double getY();
    DoubleProperty yProperty();

    void setHeight(double height);
    double getHeight();
    DoubleProperty heightProperty();

    void setWidth(double width);
    double getWidth();
    DoubleProperty widthProperty();

    static IHasLocation cast(IEntity e) {
        if (!(e instanceof IHasLocation)){
            System.err.println("L'Entité \""+e.getName()+"\" n'implémente pas IHasLocation donc il ne peut pas avoir de collisions !");
            return null;
        }
        return (IHasLocation) e;
    }
}
