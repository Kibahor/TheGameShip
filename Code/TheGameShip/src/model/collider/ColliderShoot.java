package model.collider;

import launch.Launcher;
import model.IHasEntityCollection;
import model.ILevel;
import model.entity.IEntity;
import model.entity.IHasLife;
import model.entity.IHasLocation;
import model.entity.Shoot;

public class ColliderShoot implements ICollider{

    private final ILevel level;

    public ColliderShoot(ILevel level){
        this.level = level;
    }

    @Override
    public ColliderInfo isCollision(IEntity e, String direction) throws Exception {
        return new ColliderInfo(isCollisionScene(IHasLocation.cast(e), direction),isCollisionEntity(e).getEntity());
    }

    private boolean isCollisionScene(IHasLocation h, String direction) {
        double x1 = h.getX();
        double y1 = h.getY();
        double radius = h.getHitbox_radius();
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

    private ColliderInfo isCollisionEntity(IEntity e1) throws Exception {
        IHasLocation h1=IHasLocation.cast(e1);
        double x1 = h1.getX();
        double y1 = h1.getY();
        double radius1 = h1.getHitbox_radius();
        for(IEntity e2: level.getUsedEntityCollection()){
            if(!e1.equals(e2) && !(e2 instanceof Shoot)) {
                IHasLocation h2 =IHasLocation.cast(e2);
                double x2 = h2.getX();
                double y2 = h2.getY();
                double radius2 = h2.getHitbox_radius();

                if(Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2))  < radius1 +radius2) {
                    return new ColliderInfo(e2);
                }
            }
        }
        return new ColliderInfo(false);
    }
}
