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
}
