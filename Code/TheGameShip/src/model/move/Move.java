package model.move;

import launch.Launcher;
import model.entity.Collider;
import model.entity.IEntity;

public class Move implements IMove {
    IEntity e;

    public Move(String entityName) throws Exception {
        e = Launcher.entityManager.getEntity(entityName);

        //TODO:Marche pas, vérifier autrement, genre créer une méthode qui envoie un tableau de string avec tout les décorateurs
        /*
        if(!(e instanceof IEntityMovable)) {
            throw new Exception("L'entiter n'a pas de vitesse (EntityMovable)");
        }*/
    }

    @Override
    public void left() {
        if (!Collider.isCollision(e,"LEFT")) {
            e.setX(e.getX() - 10);
        }
    }

    @Override
    public void right() {
        if (!Collider.isCollision(e,"RIGHT")) {
            e.setX(e.getX() + 10);
        }
    }

    @Override
    public void down() {
        if (!Collider.isCollision(e,"DOWN")) {
            e.setY(e.getY() + 10);
        }
    }

    @Override
    public void up() {
        if (!Collider.isCollision(e,"UP")) {
            e.setY(e.getY() - 10);
        }
    }

    @Override
    public void shoot(){
        if (!Collider.isCollision(e,"SHOOT")) {
            //TODO: Ajouter Instruction Tir
        }
    }
}
