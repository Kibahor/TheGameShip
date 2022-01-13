package model.move;

import model.GameManager;
import model.Observateur;
import model.collider.ICollider;
import model.entity.IEntity;

public class Move implements IMove{

    @Override
    public void left(IEntity e, ICollider c) {
        if (!c.isCollision(e,"LEFT")) {
            e.setY(e.getY() - 10);
        }
    }

    @Override
    public void right(IEntity e, ICollider c) {
        if (!c.isCollision(e,"RIGHT")) {
            e.setY(e.getY() + 10);
        }
    }

    @Override
    public void down(IEntity e, ICollider c) {
        if (!c.isCollision(e,"DOWN")) {
            e.setX(e.getX() + 10);
        }
    }

    @Override
    public void up(IEntity e, ICollider c) {
        if (!c.isCollision(e,"UP")) {
            e.setX(e.getX() - 10);
        }
    }
}
