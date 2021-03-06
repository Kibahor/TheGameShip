package model.move;

import model.entity.componement.EComponementType;
import model.entity.componement.Location;
import model.entity.componement.Shoot;
import model.entity.componement.Speed;
import model.util.input.ECommand;
import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.IEntity;
import java.util.UUID;

public class Move implements IMove {

    @Override
    public ColliderInfo move(IEntity e, ICollider c, ECommand key, Location l, Speed s) {
        double nextx = l.getX();
        double nexty = l.getY();

        switch (key) {
            case LEFT -> nextx -= s.getSpeedX();
            case RIGHT -> nextx += s.getSpeedX();
            case DOWN -> nexty += s.getSpeedY();
            case UP -> nexty -= s.getSpeedY();
        }

        //Vérifie la collision
        UUID id = e.getId();
        if (e.isTypeOf(EComponementType.Shoot)) {
            id = Shoot.cast(e).getOwnerId();
        }

        //Et si ce n'est pas en collision, sa déplace l'entité
        ColliderInfo ci = c.isCollision(nextx, nexty, l.getHeight(),  l.getWidth(), id);
        if (!ci.IsCollision()) {
            l.setX(nextx);
            l.setY(nexty);
        }
        return ci;
    }
}
