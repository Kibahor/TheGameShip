package model.collider;

import launch.Launcher;
import model.ColliderInfo;
import model.GameManager;
import model.IHasEntityCollection;
import model.ILevel;
import model.entity.EType;
import model.entity.IEntity;
import model.entity.IHasLife;
import model.entity.Shoot;

public class Collider implements ICollider {
    private final ILevel level;

    public Collider(ILevel level){
        this.level = level;
    }

    public ColliderInfo isCollision(IEntity e1, String direction) {
        if(isCollisionPlayground(e1, direction)){
            return new ColliderInfo(false);
        }
        return isCollisionEntity(e1);
    }

    private boolean isCollisionPlayground(IEntity e1, String direction) {
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

    private ColliderInfo isCollisionEntity(IEntity e1) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius1 = e1.getHitbox_radius();
        for(IEntity e2: ((IHasEntityCollection)level).getUsedEntityCollection()){
            boolean selfShoot=false;
            if(e2 instanceof Shoot){
                selfShoot=((Shoot)e2).getOwnerId().equals(e1.getId());
            }
            if(!e1.equals(e2) && !selfShoot) {
                double x2 = e2.getX();
                double y2 = e2.getY();
                double radius2 = e2.getHitbox_radius();
                double distance = Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2)) - (radius1 +radius2);

                if(distance<=0) {
                    return new ColliderInfo(e2);
                }

            }
        }
        return new ColliderInfo(false);
    }
}
