package model.move;

import model.entity.*;

public class MovePlayer extends Move {

    public MovePlayer(IEntity e) throws Exception {
        super(e);
        //TODO:Vérifier que c'est belle et bien un Player
        //Si nécessaire on peut spécifier le collider => super(e,new ColliderXXXX());
    }

    @Override
    public void left() {
        if (!c.isCollision(e,"UP")) {
            e.setX(e.getX()-((IMovable)e).getSpeedX());
        }
    }

    @Override
    public void right() {
        if (!c.isCollision(e,"DOWN")) {
            e.setX(e.getX()+((IMovable)e).getSpeedX());}
    }

    @Override
    public void down() {
        if (!c.isCollision(e,"RIGHT")) {
            e.setY(e.getY()+((IMovable)e).getSpeedY());}
    }

    @Override
    public void up() {
        if (!c.isCollision(e,"LEFT")) {
            e.setY(e.getY()-((IMovable)e).getSpeedY());}
    }

    @Override
    public void shoot() {
        if (!c.isCollision(e,"SHOOT")) {
            //TODO:Pas foufou de le faire ici
            ((IShoot)e).addShoot("file://test.jpg",10);
        }
    }
}
