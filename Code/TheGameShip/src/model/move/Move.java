package model.move;

import model.ColliderInfo;
import model.collider.ICollider;
import model.entity.IEntity;

public class Move implements IMove {

    //Faire qu'une seul méthode avec en parametre la direction pour faire un switch
    @Override
    public ColliderInfo left(IEntity e, ICollider c) {
        ColliderInfo ci = c.isCollision(e,"LEFT");
        if (!ci.IsCollision()) {
            e.setX(e.getX() - 10);
        }
        return ci;
    }

    @Override
    public ColliderInfo right(IEntity e, ICollider c) {
        ColliderInfo ci = c.isCollision(e,"LEFT");
        if (!ci.IsCollision()) {
            e.setX(e.getX() + 10);
        }
        return ci;
    }

    @Override
    public ColliderInfo down(IEntity e, ICollider c) {
        ColliderInfo ci = c.isCollision(e,"LEFT");
        if (!ci.IsCollision()) {
            e.setY(e.getY() + 10);
        }
        return ci;
    }

    @Override
    public ColliderInfo up(IEntity e, ICollider c) {
        ColliderInfo ci = c.isCollision(e,"LEFT");
        if (!ci.IsCollision()) {
            e.setY(e.getY() - 10);
        }
        return ci;
    }
}
