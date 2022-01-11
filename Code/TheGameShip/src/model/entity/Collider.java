package model.entity;

import launch.Launcher;

public interface Collider {

    double height = Launcher.viewManager.getSceneHeight();
    double width = Launcher.viewManager.getSceneWidth();

    static boolean isCollision(IEntity e1, String direction);
}
