package model.move;

import launch.Launcher;
import model.entity.Entity;
import model.entity.IEntity;
import model.entity.MovableDecorator;

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
        e.setX(e.getX()-((MovableDecorator) e).getSpeedX());
    }
    public void right(){
        e.setX(e.getX()+((MovableDecorator) e).getSpeedX());
    }
    public void down(){
        e.setY(e.getY()-((MovableDecorator) e).getSpeedY());
    }
    public void up(){
        e.setY(e.getY()+((MovableDecorator) e).getSpeedY());
    }

}
