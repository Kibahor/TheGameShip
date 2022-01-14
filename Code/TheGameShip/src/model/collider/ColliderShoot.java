package model.collider;

import launch.Launcher;
import model.ILevel;
import model.entity.IEntity;
import model.entity.Type;

public class ColliderShoot implements ICollider{
    private final ILevel level;

    private Type collisionType;
        public Type getCollisionType() {return collisionType;}

    public ColliderShoot(ILevel level){
        this.level = level;
    }

    @Override
    public boolean isCollision(IEntity e, String direction) {
        //Collison scene
        return isCollisionScene(e, direction) || (isCollisionEntity(e));
    }

    private boolean isCollisionScene(IEntity e1, String direction) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius = e1.getHitbox_radius();
        double height = Launcher.getViewManager().getSceneHeight();
        double width = Launcher.getViewManager().getSceneWidth();

        //Collison scene
        return switch (direction) {
            case "UP" -> (y1 - radius <= 0);
            case "LEFT" -> (x1 - radius <= 0);
            case "DOWN" -> (y1 + radius >= height);
            case "RIGHT" -> (x1 + radius >= width);
            default -> false;
        };
    }

    private boolean isCollisionEntity(IEntity e1) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius1 = e1.getHitbox_radius();
        for(IEntity e2: level.getSetEntity()){
            if(!e1.equals(e2)) {
                double x2 = e2.getX();
                double y2 = e2.getY();
                double radius2 = e2.getHitbox_radius();

                if(Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2))  < radius1 +radius2) {
                    return true;
                }
            }
        }
        return false;
    }
}
