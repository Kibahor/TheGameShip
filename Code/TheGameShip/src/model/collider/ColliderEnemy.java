package model.collider;

import javafx.collections.ObservableSet;
import launch.Launcher;
import model.entity.IEntity;

import java.util.UUID;

public class ColliderEnemy extends Collider {
    public ColliderEnemy(ObservableSet<IEntity> entities) {
        super(entities);
    }

    @Override
    public ColliderInfo isCollision(double nextX, double nextY, double height, double width, UUID id) {
        boolean scene = isCollisionScene(nextX, nextY, height, width);
        IEntity e = super.isCollisionEntity(nextX, nextY, height, width, id);
        return new ColliderInfo(scene, e);
    }

    protected boolean isCollisionScene(double nextX, double nextY, double height, double width) {
        double heightScene = Launcher.getViewManager().getSceneHeight();
        double maxX = Launcher.getViewManager().getSceneWidth() + width*2; //Ajoute du vide à droite pour pouvoir faire spawn les entités en dehors de la window
        double minX = -(width*2); //Ajoute du vide à gauche
        return ((nextY <= 0) || (nextX <= minX) || (nextY + height >= heightScene) || (nextX + width >= maxX)); //trop haut || trop à gauche || trop bas || trop à droite
    }

}
