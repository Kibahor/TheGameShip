package model.collider;

import launch.Launcher;
import model.GameManager;
import model.entity.IEntity;

public class Collider implements ICollider {
    private GameManager gameManager;
    public Collider(GameManager gameManager){
        this.gameManager = gameManager;
    }

    public boolean isCollision(IEntity e1, String direction) {
        return isCollisionPlayground(e1, direction) || (isCollisionEntity(e1));
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
        for(IEntity e2: gameManager.getSetEntity()){
            if(!e1.equals(e2)) {
                double x2 = e2.getX();
                double y2 = e2.getY();
                double radius2 = e2.getHitbox_radius();

                System.out.println("Collision Entity :" + (Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2))  < radius1 +radius2));//DEBUG
                if(Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2))  < radius1 +radius2) {
                    return true;
                }
            }
        }
        return false;
    }
}
