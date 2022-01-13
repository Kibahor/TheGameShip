package model.entity;

import javafx.beans.property.DoubleProperty;

public interface IHasLife {

    void setHp(double hp);
    double getHp();
    DoubleProperty hpProperty();

    boolean isDead();
    void setDead(boolean dead);
}
