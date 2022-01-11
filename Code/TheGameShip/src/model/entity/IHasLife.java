package model.entity;

public interface IHasLife {
    int getHp();

    void setHp(int hp);
;
    boolean isDead();

    void setDead(boolean dead);
}
