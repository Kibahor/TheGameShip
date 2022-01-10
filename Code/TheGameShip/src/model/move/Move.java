package model.move;

import launch.Launcher;
import model.entity.IEntity;

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
        e.setX(e.getX()-10);
    }
    public void right(){
        e.setX(e.getX()+10);
    }
    public void down(){
        e.setY(e.getY()+10);
    }
    public void up(){
        e.setY(e.getY()-10);
    }
}
