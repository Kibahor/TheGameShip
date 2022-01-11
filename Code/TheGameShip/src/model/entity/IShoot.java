package model.entity;

import java.util.ArrayList;

public interface IShoot {
    ArrayList<Shoot> getShoots();
    void addShoot(String sprite, double radius);
}
