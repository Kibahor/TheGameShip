package model.move;

import model.collider.ICollider;
import model.entity.*;

public class MovePlayer extends Move {

    public MovePlayer() throws Exception {
        //TODO:Vérifier que c'est belle et bien un Player
        //Si nécessaire on peut spécifier le collider => super(e,new ColliderXXXX());
    }

    @Override
    public void left(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"LEFT")) {
            e.setX(e.getX()-((IMovable)e).getSpeedX());
        }
    }

    @Override
    public void right(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"RIGHT")) {
            e.setX(e.getX()+((IMovable)e).getSpeedX());}
    }

    @Override
    public void down(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"DOWN")) {
            e.setY(e.getY()+((IMovable)e).getSpeedY());}
    }

    @Override
    public void up(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"UP")) {
            e.setY(e.getY()-((IMovable)e).getSpeedY());}
    }

    @Override
    public void shoot(IEntity e, ICollider c) {
        if (!c.isCollision(e,null,"SHOOT")) {
            //TODO:Pas foufou de le faire ici
            ((IShoot)e).addShoot("file://test.jpg",10);
        }
    }
}
