package model.move;

import model.util.input.ECommand;
import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.EType;
import model.entity.IEntity;
import model.entity.IMovable;
import model.entity.IShoot;

import java.util.UUID;

public class Move implements IMove {

    @Override
    public ColliderInfo move(IEntity e, ICollider c, ECommand key) throws Exception {
        IMovable m=IMovable.cast(e);
        double nextx =m.getX();
        double nexty =m.getY();

        switch (key){
            case LEFT -> nextx =m.getX() - m.getSpeedX();
            case RIGHT -> nextx = m.getX() + m.getSpeedX();
            case DOWN -> nexty = m.getY() + m.getSpeedY();
            case UP -> nexty = m.getY() - m.getSpeedY();
        }

        //Vérifie la collision
        UUID id = e.getId();
        if(e.getType().equals(EType.Shoot)){
            id = IShoot.cast(e).getOwnerId();
        }
        ColliderInfo ci=c.isCollision(nextx, nexty, m.getHeight(), m.getWidth(),id);

        //ET si c'est pas en collison sa déplace l'entité
        if(!ci.IsCollision()){
            m.setX(nextx);
            m.setY(nexty);
        }
        return ci;
    }
}
