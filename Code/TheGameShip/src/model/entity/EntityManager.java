package model.entity;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import model.Observable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EntityManager {
    //TODO:Il faudrait que le set soit observable afin que quand il est un ajout, le monde l'affiche
    private final SimpleSetProperty<IEntity> setEntity;
        public ObservableSet<IEntity> getSetEntity(){return setEntity.get();}
        public SimpleSetProperty<IEntity> getSetEntityProperty(){return setEntity;}

    public EntityManager() {
        this.setEntity = new SimpleSetProperty(FXCollections.observableSet(new HashSet<>()));
    }

    public void add(IEntity e){
        getSetEntity().add(e);
    }

    public void delete(String entityName) throws Exception {
        getSetEntity().remove(getEntity(entityName));
    }

    public IEntity getEntity(String name) throws Exception {
        for (IEntity e : getSetEntity()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        throw new Exception("L'Entité \""+name+"\" n'existe pas");
    }

    public void listEntity() {
        for (IEntity e : getSetEntity()) {
            System.out.println(e);
        }
    }

}
