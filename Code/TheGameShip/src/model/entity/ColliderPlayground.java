package model.entity;

import launch.Launcher;

public class ColliderPlayground implements ICollider {

    public boolean isCollision(IEntity e1, String direction) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius = e1.getHitbox_radius();
        double height= Launcher.viewManager.getSceneHeight();
        double width=Launcher.viewManager.getSceneWidth();

        //Collison scene
        return switch (direction) {
            case "UP" -> (x1 - radius <= 0);
            case "LEFT" -> (y1 - radius <= 0);
            case "DOWN" -> (x1 + radius >= width);
            case "RIGHT" -> (y1 + radius >= height);
            default -> false;
        };
    }
}
