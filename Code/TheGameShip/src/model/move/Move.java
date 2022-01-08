package model.move;

import launch.Launcher;
import model.entity.Entity;
import model.entity.IEntityMovable;

public class Move{
    public static void deplacement(String name, double X, double Y) throws Exception {
        Entity e= (Entity) Launcher.entityManager.getEntity(name);
        e.setX(e.getX()+1);
        e.setY(e.getY()+1);
    }
    /* public void move(String name) throws Exception
    {
        IEntity e1=this.getEntity(name);
        if(e1==null){
            return;
        }
        if(!(e1 instanceof MovableDecorator)) {
            throw new Exception("L'entitée ne peut pas se déplacer car elle n'hérite pas de MovableDecorator");
        }
        Entity se1 = (Entity) e1;
        float speedX = ((MovableDecorator)e1).getSpeedX();
        float speedY = ((MovableDecorator)e1).getSpeedY();
        se1.setX(se1.getX() + speedX);
        se1.setY(se1.getY() + speedY);
    }

    public void setLocation(String name, double x, double y) {
        IEntity e1=this.getEntity(name);
        if(e1==null){
            return;
        }
        ((Entity)e1).setX(x);
        ((Entity)e1).setY(y);
    }*/
}
