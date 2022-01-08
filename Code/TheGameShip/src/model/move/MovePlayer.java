package model.move;

import launch.Launcher;
import model.entity.Entity;
import model.entity.IEntity;
import model.entity.IEntityMovable;

public class MovePlayer extends Move{

    public static void deplacement(String name, double X, double Y) throws Exception{
        Entity e= (Entity) Launcher.entityManager.getEntity(name);
        if(!(e instanceof IEntityMovable)){
            throw new Exception("L'entiter n'a pas de vitesse (EntityMovable)");
        }
        e.setX(e.getX()+((IEntityMovable) e).getSpeedX());
        e.setY(e.getY()+((IEntityMovable) e).getSpeedY());
    }
}
