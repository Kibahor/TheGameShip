package model.move;

import launch.Launcher;
import model.entity.Collider;
import model.entity.IEntity;

public class Move implements IMove {
    IEntity e;
    Collider c;

    public Move(IEntity e){
        this.e=e;
        this.c=new Collider();
    }
    protected Move(IEntity e, Collider c){
        this.e=e;
        this.c=c;
    }

    @Override
    public void left() {
        if (!c.isCollision(e,"LEFT")) {
            e.setY(e.getY() - 10);
        }
    }

    @Override
    public void right() {
        if (!c.isCollision(e,"RIGHT")) {
            e.setY(e.getY() + 10);
        }
    }

    @Override
    public void down() {
        if (!c.isCollision(e,"DOWN")) {
            e.setX(e.getX() + 10);
        }
    }

    @Override
    public void up() {
        if (!c.isCollision(e,"UP")) {
            e.setX(e.getX() - 10);
        }
    }

    @Override
    public void shoot(){
        if (!c.isCollision(e,"SHOOT")) {
            //TODO: Ajouter Instruction Tir
        }
    }
}
