package model.entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import model.entity.componement.Sprite;
import model.game.IEntityCollection;

import java.util.HashSet;
import java.util.Iterator;

public class EntityManager implements IEntityCollection {

    private final ObservableSet<IEntity> entities;

    @Override
    public ObservableSet<IEntity> getEntityCollection() {
        return entities;
    }

    public EntityManager() {
        entities = FXCollections.observableSet(new HashSet<>());
    }

    //Used Entities
    public void addEntity(IEntity e) {
        Sprite.cast(e).setVisible(true);
        entities.add(e);
    }

    public void removeEntity(IEntity e) {
        Sprite.cast(e).setVisible(false);
        entities.remove(e);
    }

    public void removeEntity(String name) {
        removeEntity(getEntityBy(name));
    }

    private IEntity getEntityBy(String name) {
        Iterator it = entities.iterator();
        while (it.hasNext()) {
            IEntity e = (IEntity) it.next();
            if (e.getName().equals(name)) {
                return e;
            }
        }
        newError(name);
        return null;
    }

    //TODO : la refaire pour mettre toute les infos
    @Override
    public String toString() {
            /*
        System.out.println("Used Entity :\n");
        for (IEntity e : getUsedEntityCollection()) {
            System.out.println(e);
        }*/
        return super.toString();
    }

    private void newError(String name) {
        System.err.println("Il n'y a pas d'entité de nom : \"" + name + "\"");
    }

    private void newError(EEntityType type) {
        System.err.println("Il n'y a pas d'entité de type : \"" + type + "\"");
    }
}
