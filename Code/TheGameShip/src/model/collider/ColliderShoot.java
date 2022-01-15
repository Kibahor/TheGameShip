package model.collider;

import launch.Launcher;
import model.IHasEntityCollection;
import model.ILevel;
import model.entity.*;

public class ColliderShoot extends Collider{

    public ColliderShoot(ILevel level){
        super(level);
    }

    @Override
    protected ColliderInfo isCollisionEntity(IEntity e1) throws Exception {
        IHasLocation h1=IHasLocation.cast(e1);
        double x1 = h1.getX();
        double y1 = h1.getY();
        double radius1 = h1.getHitbox_radius();
        for(IEntity e2: level.getUsedEntityCollection()){
            if(!e1.equals(e2) || !(e2 instanceof IShoot)) {
                IHasLocation h2 =IHasLocation.cast(e2);
                double x2 = h2.getX();
                double y2 = h2.getY();
                double radius2 = h2.getHitbox_radius();
                double distance = Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2)) - (radius1 +radius2);

                if(distance<=0) {
                    return new ColliderInfo(e2);
                }
            }
        }
        return new ColliderInfo(false);
    }
}
