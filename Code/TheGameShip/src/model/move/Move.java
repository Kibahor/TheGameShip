package model.move;

import launch.Launcher;
import model.entity.Entity;
import model.entity.IEntity;
import model.entity.IEntityMovable;

public class Move{
    IEntity e;

    public Move(String entityName) throws Exception{
        e= Launcher.entityManager.getEntity(entityName);

        //TODO:Marche pas, vérifier autrement, genre créer une méthode qui envoie un tableau de string avec tout les décorateurs
        /*
        if(!(e instanceof IEntityMovable)){
            throw new Exception("L'entiter n'a pas de vitesse (EntityMovable)");
        }*/
    }

    public void left(){
        //e.setX(e.getX()-((IEntityMovable) e).getSpeedX());
    }
    public void right(){
        //e.setX(e.getX()+((IEntityMovable) e).getSpeedX());
    }
    public void down(){
        //e.setY(e.getY()-((IEntityMovable) e).getSpeedY());
    }
    public void up(){
        //e.setY(e.getY()+((IEntityMovable) e).getSpeedY());
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
