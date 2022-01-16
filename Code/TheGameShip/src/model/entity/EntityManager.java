package model.entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.util.Collection;
import java.util.HashSet;

public class EntityManager implements IHasEntityCollection {

    private final Collection<IEntity> unUsedEntities;
        @Override public Collection<IEntity> getUnusedEntityCollection(){return unUsedEntities;}

    private final ObservableSet<IEntity> usedEntities;
        @Override public Collection<IEntity> getUsedEntityCollection(){return usedEntities;}

    public EntityManager() {
        this.unUsedEntities = FXCollections.observableSet(new HashSet<>());
        this.usedEntities = FXCollections.observableSet(new HashSet<>());
    }

    //TODO : fusionner les mêmes algo et ajouter un boolean isUsed pour trancher entre les 2 collections
    //Used Entities
    public void setUsedEntity(String name) throws Exception{
        IEntity e= getUnUsedEntity(name);
        e.setVisible(true);
        getUsedEntityCollection().add(e);
    }

    public void setUsedEntity(IEntity e){
        e.setVisible(true);
        getUsedEntityCollection().add(e);
    }

    public IEntity getUsedEntity(String name) throws Exception {
        for(IEntity e: getUsedEntityCollection()){
            if(name.equals(e.getName())){
                return e;
            }
        }
        throw newException(name);
    }

    public IEntity getUsedEntity(EType type) throws Exception {
        for(IEntity e: getUsedEntityCollection()){
            if(type.equals(e.getType())){
                return e;
            }
        }
        throw newException(type);
    }

    //UnUsed Entities
    public void add(IEntity e){
        e.setVisible(false); //Au cas où
        getUnusedEntityCollection().add(e);
    }

    public void setUnUsedEntity(IEntity e){
        e.setVisible(false);
        getUsedEntityCollection().remove(e);
        e.reset(); //Il met tous les autres paramètres par défauts sauf visible
        getUnusedEntityCollection().add(e);
    }

    public IEntity getUnUsedEntity(EType type) throws Exception {
        for (IEntity e : getUnusedEntityCollection()) {
            if (type.equals(e.getType())) {
                getUnusedEntityCollection().remove(e);
                return e;
            }
        }
        throw newException(type);
    }

    public IEntity getUnUsedEntity(String name) throws Exception {
        for(IEntity e: getUnusedEntityCollection()){
            if(name.equals(e.getName())){
                return e;
            }
        }
        throw newException(name);
    }

    //General
    public void listEntity() {
        System.out.println("Used Entity :\n");
        for (IEntity e : getUsedEntityCollection()) {
            System.out.println(e);
        }
        System.out.println("Un-used Entity :\n");
        for (IEntity e : getUnusedEntityCollection()) {
            System.out.println(e);
        }
    }

    //Todo: Trouver un autre moyen que throw une exception ?
    public Exception newException(String name) throws Exception{
        return new Exception("Il n'y a pas d'entité de nom : \""+ name+"\"");
    }
    public Exception newException(EType type) throws Exception{
        return new Exception("Il n'y a pas d'entité de type : \""+ type.toString()+"\" disponible");
    }

}
