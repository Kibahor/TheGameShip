package model.move;

import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.componement.Location;
import model.entity.componement.Speed;
import model.entity.IEntity;
import model.util.input.ECommand;

public class MoveEnemy implements IMove {

    @Override
    public ColliderInfo move(IEntity e, ICollider c, ECommand key, Location lPlayer, Speed senemy) { //Ici la Location est celle du joueur
        Location lenemy = Location.cast(e);

        // X
        double nextx = lenemy.getX();
        switch (key) {
            case LEFT -> nextx -= senemy.getSpeedX();
            case RIGHT -> nextx += senemy.getSpeedX();
            default -> nextx -= senemy.getSpeedX(); //Par défaut c'est vers la gauche
        }

        // Y
        double nexty = lenemy.getY();
        if((lenemy.getY() - lPlayer.getY()) != 0){ //Si c'est égale alors pas besoin de bouger
            if((lenemy.getY() - lPlayer.getY()) < 0) { //Si le joueur est plus bas que l'ennemie c'est négatif et inversement
                nexty +=  senemy.getSpeedY() ;
            } else {
                nexty -=  senemy.getSpeedY() ;
            }
        }

        //Et si ce n'est pas en collision, sa déplace l'entité
        ColliderInfo ci = c.isCollision(nextx, nexty, lenemy.getHeight(),  lenemy.getWidth(), e.getId());
        if (!ci.IsCollision()) {
            lenemy.setX(nextx);
            lenemy.setY(nexty);
        }
        return ci;
    }
}
