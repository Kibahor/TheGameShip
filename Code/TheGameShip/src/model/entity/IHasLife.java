package model.entity;

import javafx.beans.property.DoubleProperty;

public interface IHasLife {

    double getHp();
    void incrementHp();
    void decreaseHp();
    void setHp(double hp);
    DoubleProperty hpProperty();

    boolean isDead();
    void setDead(boolean dead);

    static IHasLife cast(IEntity e) throws Exception {
        if(!(e instanceof IHasLife)){
            throw new Exception("L'Entité \""+e.getName()+"\" n'implémente pas IHasLife donc elle ne peut pas perdre de la vie !");
        }
        return (IHasLife) e;
    }
}
