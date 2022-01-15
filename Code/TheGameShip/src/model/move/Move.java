package model.move;

import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.IEntity;
import model.entity.IMovable;

public class Move implements IMove {
    //Todo : Faire qu'une seul méthode avec en parametre (la direction) et faire un switch
    //Todo : faire une enumeration de touche


    @Override
    public ColliderInfo move(IEntity e, ICollider c, String direction) throws Exception {
        if(!(e instanceof IMovable)) {
            throw new Exception("L'entité \""+e.getName()+"\" n'implémente pas IMovable, il ne peut donc pas être déplacé !");
        }
        IMovable m=(IMovable)e;
        ColliderInfo ci = c.isCollision(e,direction);
        if (!ci.IsCollision()) {
            switch (direction){
                case "LEFT" -> m.setX(m.getX() - m.getSpeedX());
                case "RIGHT" -> m.setX(m.getX() + m.getSpeedX());
                case "DOWN" -> m.setY(m.getY() + m.getSpeedY());
                case "UP" -> m.setY(m.getY() - m.getSpeedY());
                default -> System.out.println("Pas d'action pour la touche \""+direction+"\" !"); //DEBUG
            }
        }
        return ci;
    }
}
