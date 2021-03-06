package model.collider;

import javafx.collections.ObservableSet;
import launch.Launcher;
import model.entity.IEntity;
import model.entity.componement.EComponementType;
import model.entity.componement.Location;
import model.entity.componement.Shoot;

import java.util.UUID;

public class Collider implements ICollider { // Document : http://sdz.tdct.org/sdz/eorie-des-collisions.html

    private final ObservableSet<IEntity> entities;

    public Collider(ObservableSet<IEntity> entities) {
        this.entities = entities;
    }

    @Override
    public ColliderInfo isCollision(double nextX, double nextY, double height, double width, UUID id) {
        boolean scene = isCollisionScene(nextX, nextY, height, width);
        IEntity e = isCollisionEntity(nextX, nextY, height, width, id);
        return new ColliderInfo(scene, e);
    }

    protected boolean isCollisionScene(double nextX, double nextY, double height, double width) {
        double heightScene = Launcher.getViewManager().getSceneHeight();
        double widthScene = Launcher.getViewManager().getSceneWidth();
        return ((nextY <= 0) || (nextX <= 0) || (nextY + height >= heightScene) || (nextX + width >= widthScene)); //trop haut || trop à gauche || trop bas || trop à droite
    }

    protected IEntity isCollisionEntity(double nextX, double nextY, double height, double width, UUID id) {
        for (IEntity e2 : entities) {
            //Empêche que le joueur soit bloquer par ces propre tir
            boolean isAtOriginOfShoot = false;
            if (e2.isTypeOf(EComponementType.Shoot)) {
                isAtOriginOfShoot = id.equals(Shoot.cast(e2).getOwnerId());
            }
            if (!id.equals(e2.getId()) && !isAtOriginOfShoot) {
                Location l = Location.cast(e2);
                double x2 = l.getX();
                double y2 = l.getY();
                double height2 = l.getHeight();
                double width2 = l.getWidth();
                if (!((x2 >= nextX + width) || (x2 + width2 <= nextX) || (y2 >= nextY + height) || (y2 + height2 <= nextY)))   // trop à droite || trop à gauche || trop en bas || trop en haut
                    return e2;
            }
        }
        return null; //Pas de Collision
    }
}
