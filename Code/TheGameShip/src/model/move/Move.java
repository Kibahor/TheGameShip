package model.move;

import launch.Launcher;
import model.entity.Collider;
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

    public void left() throws Exception {
        if(!Collider.isCollision(e)){
            e.setX(e.getX()-10);
        }
    }
    public void right() throws Exception {
        if(!Collider.isCollision(e)){
        e.setX(e.getX()+10);}
    }
    public void down() throws Exception {
        if(!Collider.isCollision(e)){
        e.setY(e.getY()+10);}
    }
    public void up() throws Exception {
        if(!Collider.isCollision(e)){
        e.setY(e.getY()-10);}
    }
}
