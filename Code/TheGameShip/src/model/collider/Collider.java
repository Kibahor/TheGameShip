package model.collider;

import launch.Launcher;
import model.ColliderInfo;
import model.GameManager;
import model.IHasEntityCollection;
import model.ILevel;
import model.entity.EType;
import model.entity.IEntity;
import model.entity.Shoot;

public class Collider implements ICollider {
    private final ILevel level;

    public Collider(ILevel level){
        this.level = level;
    }

    public ColliderInfo isCollision(IEntity e1, String direction) {
        return new ColliderInfo(isCollisionPlayground(e1, direction) || (isCollisionEntity(e1)));
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

    private boolean isCollisionEntity(IEntity e1) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius1 = e1.getHitbox_radius();
        for(IEntity e2: ((IHasEntityCollection)level).getUsedEntityCollection()){
            boolean ownedShoot=false;
            if(e2 instanceof Shoot){
                ownedShoot=((Shoot)e2).getOwnerId().equals(e1.getId());
            }
            if(!e1.equals(e2) && !ownedShoot) {
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
