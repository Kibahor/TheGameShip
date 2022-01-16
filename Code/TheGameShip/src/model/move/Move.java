package model.move;

import model.collider.Collider;
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
        IMovable m=IMovable.cast(e);
        double nextx =m.getX();
        double nexty =m.getY();
        switch (direction){
            case "LEFT" -> nextx =m.getX() - m.getSpeedX();
            case "RIGHT" -> nextx = m.getX() + m.getSpeedX();
            case "DOWN" -> nexty = m.getY() + m.getSpeedY();
            case "UP" -> nexty = m.getY() - m.getSpeedY();
        }
        ColliderInfo ci=c.isCollision(nextx, nexty, m.getHeight(), m.getWidth(), e.getId());
        if(!ci.IsCollision()){
            m.setX(nextx);
            m.setY(nexty);
        }
        return ci;
    }
}
