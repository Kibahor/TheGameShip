package model.move;

import model.ColliderInfo;
import model.collider.ICollider;
import model.entity.*;

public class MoveSpeed extends Move {

    @Override
    public ColliderInfo left(IEntity e, ICollider c) {
        ColliderInfo ci = c.isCollision(e,"LEFT");
        if (!ci.IsCollision()) {
            e.setX(e.getX()-((IMovable)e).getSpeedX());
        }
        return ci;
    }

    @Override
    public ColliderInfo right(IEntity e, ICollider c) {
        ColliderInfo ci = c.isCollision(e,"LEFT");
        if (!ci.IsCollision()) {
            e.setX(e.getX()+((IMovable)e).getSpeedX());
        }
        return ci;
    }

    @Override
    public ColliderInfo down(IEntity e, ICollider c) {
        ColliderInfo ci = c.isCollision(e,"LEFT");
        if (!ci.IsCollision()) {
            e.setY(e.getY()+((IMovable)e).getSpeedY());
        }
        return ci;
    }

    @Override
    public ColliderInfo up(IEntity e, ICollider c) {
        ColliderInfo ci = c.isCollision(e,"LEFT");
        if (!ci.IsCollision()) {
            e.setY(e.getY()-((IMovable)e).getSpeedY());
        }
        return ci;
    }
}
