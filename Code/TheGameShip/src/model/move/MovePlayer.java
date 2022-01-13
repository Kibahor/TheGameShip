package model.move;

import model.collider.ICollider;
import model.entity.*;

public class MovePlayer extends Move {

    @Override
    public void left(IEntity e, ICollider c) {
        if (!c.isCollision(e,"LEFT")) {
            e.setX(e.getX()-((IMovable)e).getSpeedX());
        }
    }

    @Override
    public void right(IEntity e, ICollider c) {
        if (!c.isCollision(e,"RIGHT")) {
            e.setX(e.getX()+((IMovable)e).getSpeedX());
        }
    }

    @Override
    public void down(IEntity e, ICollider c) {
        if (!c.isCollision(e,"DOWN")) {
            e.setY(e.getY()+((IMovable)e).getSpeedY());
        }
    }

    @Override
    public void up(IEntity e, ICollider c) {
        if (!c.isCollision(e,"UP")) {
            e.setY(e.getY()-((IMovable)e).getSpeedY());
        }
    }
}
