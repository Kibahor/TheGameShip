package model.collider;

import launch.Launcher;
import model.entity.IEntity;

public class ColliderShoot implements ICollider {

    @Override
    public boolean isCollision(IEntity e, String direction) {
        double x1 = e.getX();
        double y1 = e.getY();
        double radius = e.getHitbox_radius();
        double height = Launcher.getViewManager().getSceneHeight();
        double width = Launcher.getViewManager().getSceneWidth();

        //Collison scene
        return (x1 + radius >= width);
    }
}
