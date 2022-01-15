package model.entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import model.IHasEntityCollection;

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
        throw new Exception("Il n'y a pas d'entité de nom : \""+ name+"\"");
    }

    public IEntity getUsedEntity(EType type) throws Exception {
        for(IEntity e: getUsedEntityCollection()){
            if(type.equals(e.getType())){
                return e;
            }
        }
        throw new Exception("Il n'y a pas d'entité de type : \""+ type.toString()+" disponible");
    }

    //UnUsed Entities
    public void add(IEntity e){
            e.setVisible(false); //Au cas où
        getUnusedEntityCollection().add(e);
    }

    public void setUnUsedEntity(IEntity e){
        e.setVisible(false);
        //e.reset(); //Il met tout les autre parametre par defaut sauf visible
        getUnusedEntityCollection().add(e);
    }

    public IEntity getUnUsedEntity(EType type) throws Exception {
        for (IEntity e : getUnusedEntityCollection()) {
            if (type.equals(e.getType())) {
                getUnusedEntityCollection().remove(e);
                return e;
            }
        }
        throw new Exception("Il n'y a pas d'entité de type : \""+ type.toString()+" disponible"); //Todo:Trouver un autre moyen que throw une exception
    }

    public IEntity getUnUsedEntity(String name) throws Exception {
        for(IEntity e: getUnusedEntityCollection()){
            if(name.equals(e.getName())){
                return e;
            }
        }
        throw new Exception("Il n'y a pas d'entité de nom : \""+ name+"\"");
    }

    //General
    public IEntity getEntity(String name) throws Exception{
        try {
            return getUnUsedEntity(name);
        }catch (Exception err){
            err.printStackTrace();//DEBUG
            return getUsedEntity(name);
        }
    }

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
    //TODO : faire 2 méthode newException(String name) et newException(Etype type)
}
