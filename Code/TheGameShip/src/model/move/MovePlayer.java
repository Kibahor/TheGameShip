package model.move;

import model.entity.Collider;
import model.entity.Player;

public class MovePlayer implements IMove {
    Player e;

    public MovePlayer(Player e) {
        this.e = e;
    }

    @Override
    public void left() {
        if (!Collider.isCollision(e,"UP")) {
            e.setX(e.getX()-e.getSpeedX());
        }
    }

    @Override
    public void right() {
        if (!Collider.isCollision(e,"DOWN")) {
            e.setX(e.getX()+e.getSpeedX());}
    }

    @Override
    public void down() {
        if (!Collider.isCollision(e,"RIGHT")) {
            e.setY(e.getY()+e.getSpeedY());}
    }

    @Override
    public void up() {
        if (!Collider.isCollision(e,"LEFT")) {
            e.setY(e.getY()-e.getSpeedY());}
    }

    @Override
    public void shoot() {
        if (!Collider.isCollision(e,"SHOOT")) {
            //TODO:Pas foufou de le faire ici
            e.addShoot("file://test.jpg",10);
        }
    }
}
