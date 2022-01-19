package model.entity;

import javafx.beans.property.DoubleProperty;

public interface IHasLife {

    double getHp();
    void decreaseHp();
    void setHp(double hp);
    DoubleProperty hpProperty();

    boolean isDead();
    void setDead(boolean dead);

    static IHasLife cast(IEntity e) {
        if (!(e instanceof IHasLife)) {
            System.err.println("L'Entité \""+e.getName()+"\" n'implémente pas IHasLife donc elle ne peut pas perdre de la vie !");
            return null;
        }
        return (IHasLife) e;
    }
}
