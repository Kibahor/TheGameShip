package model.entity;

public interface IHasLife {

    void setHp(int hp);
    double getHp();

    boolean isDead();
    void setDead(boolean dead);
}
