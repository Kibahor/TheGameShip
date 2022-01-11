package model.move;

import launch.Launcher;
import model.entity.Collider;
import model.entity.Entity;
import model.entity.IEntity;
import model.entity.Player;

public class MovePlayer implements IMove{
    Player e;

    public MovePlayer(String entityName) throws Exception {
        IEntity e=Launcher.entityManager.getEntity(entityName);
        //TODO:Troouver un autre moyen de vérifier
        /*
        if(e instanceof Player){
            throw new Exception("L'entiter n'est pas un Player");
        }*/
        this.e= (Player) e;
    }

    @Override
    public void left() {
        if(!Collider.isCollision(e,"LEFT")){
            e.setX(e.getX()-e.getSpeedX());
        }
    }

    @Override
    public void right() {
        if(!Collider.isCollision(e,"RIGHT")){
            e.setX(e.getX()+e.getSpeedX());}
    }

    @Override
    public void down() {
        if(!Collider.isCollision(e,"DOWN")){
            e.setY(e.getY()+e.getSpeedY());}
    }

    @Override
    public void up() {
        if(!Collider.isCollision(e,"UP")){
            e.setY(e.getY()-e.getSpeedY());}
    }

    @Override
    public void shoot(){
        if(!Collider.isCollision(e,"SHOOT")){
            //TODO:Pas foufou de le faire ici
            e.addShoot("file://test.jpg",10);
        }
    }
}
