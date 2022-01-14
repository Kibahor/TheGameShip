package model.collider;

import launch.Launcher;
import model.ColliderInfo;
import model.ILevel;
import model.entity.IEntity;
import model.entity.Type;

public class ColliderShoot implements ICollider{

    private final ILevel level;

    public ColliderShoot(ILevel level){
        this.level = level;
    }

    @Override
    public ColliderInfo isCollision(IEntity e, String direction) {
        if(this.isCollisionScene(e,direction)){
            return new ColliderInfo(true);
        }
        return isCollisionEntity(e);

    }

    private boolean isCollisionScene(IEntity e1, String direction) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius = e1.getHitbox_radius();
        double height = Launcher.getViewManager().getSceneHeight();
        double width = Launcher.getViewManager().getSceneWidth();

        return switch (direction) {
            case "UP" -> (y1 - radius <= 0);
            case "LEFT" -> (x1 - radius <= 0);
            case "DOWN" -> (y1 + radius >= height);
            case "RIGHT" -> (x1 + radius >= width);
            default -> false;
        };
    }

    private ColliderInfo isCollisionEntity(IEntity e1) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius1 = e1.getHitbox_radius();
        for(IEntity e2: level.getSetEntity()){
            if(!e1.equals(e2)) {
                double x2 = e2.getX();
                double y2 = e2.getY();
                double radius2 = e2.getHitbox_radius();

                if(Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2))  < radius1 +radius2) {
                    return new ColliderInfo(e2);
                }
            }
        }
        return new ColliderInfo(false);
    }
}
