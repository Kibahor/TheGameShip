package model.entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import model.game.IEntityCollection;
import model.entity.componement.Sprite;

import java.util.HashSet;
import java.util.Iterator;

public class EntityManager implements IEntityCollection {

    private final ObservableSet<IEntity> entities;

    @Override public ObservableSet<IEntity> getEntityCollection() { return entities; }

    public EntityManager() {
        entities = FXCollections.observableSet(new HashSet<>());
    }

    //TODO : Mauvais plan de faire deux listes, il faut en faire qu'une mais observable et la bind sur la vue
    //Used Entities
    public void addEntity(IEntity e) {
        Sprite.cast(e).setVisible(true);
        entities.add(e);
    }

    public void removeEntity(IEntity e) {
        Sprite.cast(e).setVisible(false);
        entities.remove(e);
    }
    public void removeEntity(String name){
        removeEntity(getEntityBy(name));
    }

    private IEntity getEntityBy(String name) {
        Iterator it = entities.iterator();
        while(it.hasNext()){
            IEntity e = (IEntity) it.next();
            if(e.getName().equals(name)){
                return e;
            }
        }
        newError(name);
        return null;
    }

    /*public IEntity getPlayer() {
        Iterator it = entities.iterator();
        while(it.hasNext()){
            IEntity e = (IEntity) it.next();
            if(e.getEntityType().equals(EEntityType.Player)){
                return e;
            }
        }
        newError(EEntityType.Player);
        return null;
    }*/

    //General
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

    public void newError(String name){
        System.err.println("Il n'y a pas d'entité de nom : \""+ name +"\"");
    }
    public void newError(EEntityType type){
        System.err.println("Il n'y a pas d'entité de type : \""+ type +"\"");
    }
}
