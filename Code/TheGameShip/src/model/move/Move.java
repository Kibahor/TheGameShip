package model.move;

import model.collider.ICollider;
import model.entity.IEntity;

public class Move implements IMove {

    @Override
    public void left(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"LEFT")) {
            e.setY(e.getY() - 10);
        }
    }

    @Override
    public void right(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"RIGHT")) {
            e.setY(e.getY() + 10);
        }
    }

    @Override
    public void down(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"DOWN")) {
            e.setX(e.getX() + 10);
        }
    }

    @Override
    public void up(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"UP")) {
            e.setX(e.getX() - 10);
        }
    }

    @Override
    public void shoot(IEntity e, ICollider c){
        if (!c.isCollision(e,null,"SHOOT")) {
            //TODO: Ajouter Instruction Tir
        }
    }
}
