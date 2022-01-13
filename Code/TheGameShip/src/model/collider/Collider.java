package model.collider;

import launch.Launcher;
import model.GameManager;
import model.entity.IEntity;
import model.entity.Shoot;

public class Collider implements ICollider {
    private final GameManager gameManager;
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
            boolean ownedShoot=false;
            /*Décommenter une fois que : TODO: Il faudrait utiliser la liste des entités visible et utilisé
            if(e2.getType().equals("Shoot")){
                ownedShoot=((Shoot)e2).getOwnerId().equals(e1.getId());
            }*/
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
