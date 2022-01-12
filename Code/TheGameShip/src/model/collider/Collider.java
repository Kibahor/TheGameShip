package model.collider;

import launch.Launcher;
import model.entity.IEntity;

public class Collider implements ICollider {

    public boolean isCollision(IEntity e1, IEntity e2, String direction) {
        return (isCollisionPlayground(e1, direction));
    }

    private boolean isCollisionPlayground(IEntity e1, String direction) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius = e1.getHitbox_radius();
        double height= Launcher.getViewManager().getSceneHeight();
        double width=Launcher.getViewManager().getSceneWidth();

        //Collison scene
        return switch (direction) {
            case "UP" -> (y1 - radius <= 0);
            case "LEFT" -> (x1 - radius <= 0);
            case "DOWN" -> (y1 + radius >= height);
            case "RIGHT" -> (x1 + radius >= width);
            default -> false;
        };
    }

    private boolean isCollisionEntity(IEntity e1, IEntity e2) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double x2 = e2.getX();
        double y2 = e2.getY();
        double radius1 = e1.getHitbox_radius();
        double radius2 = e2.getHitbox_radius();

        return (Math.sqrt(((Math.pow(x1, 2))-(Math.pow(x2, 2))) + ((Math.pow(y1, 2))-(Math.pow(y2, 2)))) < radius1 + radius2);
    }
}
