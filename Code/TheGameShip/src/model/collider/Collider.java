package model.collider;

import launch.Launcher;
import model.ILevel;
import model.entity.*;

public class Collider implements ICollider {
    protected final ILevel level;

    public Collider(ILevel level){
        this.level = level;
    } //TODO: au lieu de passer le level il faudrait donner directement la collection

    @Override
    public ColliderInfo isCollision(IEntity e, String direction) throws Exception {
        return new ColliderInfo(isCollisionScene(IHasLocation.cast(e), direction),isCollisionEntity(e,direction).getEntity());
    }

    protected boolean isCollisionScene(IHasLocation h, String direction){
        double x1 = h.getX();
        double y1 = h.getY();
        double radius = h.getHitbox_radius();
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

    protected ColliderInfo isCollisionEntity(IEntity e1, String direction) throws Exception{
        IHasLocation h1=IHasLocation.cast(e1);
        double x1 = h1.getX();
        double y1 = h1.getY();
        double radius1 = h1.getHitbox_radius();

        IMovable m1=IMovable.cast(e1);
        double speedX1= m1.getSpeedX();
        double speedY1= m1.getSpeedY();

        for(IEntity e2: level.getUsedEntityCollection()){
            //TODO: beaucoup de code se répéte (=source de bug), il faudrait trouver un moyen d'unifier les codes et d'ajouter les particularité de chacun
            //Empêche que le joueur soit bloquer par ces propre tir
            boolean isAtOriginOfShoot=false;
            if(e2 instanceof IShoot){
                isAtOriginOfShoot=((IShoot) e2).getOwnerId().equals(e1.getId());
            }
            if(!e1.equals(e2) && !isAtOriginOfShoot) {
                IHasLocation h2 =IHasLocation.cast(e2);
                double x2 = h2.getX();
                double y2 = h2.getY();
                double radius2 = h2.getHitbox_radius();
                double distance = Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
                System.out.println("Distance : "+distance);//DEBUG
                //todo : Collision entre entité un peu foireuse
                boolean isCollision = switch (direction) {
                    case "UP" -> (distance - speedY1 <= radius1+radius2);
                    case "LEFT" -> (distance + speedX1 <= radius1+radius2);
                    case "DOWN" -> (distance - speedY1 <= radius1+radius2);
                    case "RIGHT" -> (distance + speedX1 <= radius1+radius2);
                    default -> false;
                };
                if(isCollision){
                    return new ColliderInfo(e2);
                }
            }
        }
        return new ColliderInfo(false);
    }
}
