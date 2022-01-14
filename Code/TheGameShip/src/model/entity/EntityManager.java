package model.entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import model.IHasEntityCollection;

import java.util.HashSet;

public class EntityManager implements IHasEntityCollection { //TODO: Mieux gérer entités (visible vs non visible) (Gérer efficaement les deux collection)

    private final ObservableSet<IEntity> unUsedEntities;
        @Override public ObservableSet<IEntity> getUnusedEntityCollection(){return unUsedEntities;} //Todo: mettre un readonly Observateur au pire

    private final ObservableSet<IEntity> usedEntities;
        @Override public ObservableSet<IEntity> getUsedEntityCollection(){return usedEntities;} //Todo: mettre un readonly Observateur au pire

    public EntityManager() {
        this.unUsedEntities = FXCollections.observableSet(new HashSet<>());
        this.usedEntities = FXCollections.observableSet(new HashSet<>());
    }

    public void add(IEntity e){
        if(e.getVisible()){
            getUsedEntityCollection().add(e);
        }else{
            getUnusedEntityCollection().add(e);
        }
    }

    public IEntity getUnUsedEntity(EType type) throws Exception {
        for (IEntity e : getUnusedEntityCollection()) {
            if (type.equals(e.getType())) {
                getUnusedEntityCollection().remove(e);
                return e;
            }
        }
        throw new Exception("Il n'y a pas d'entité de type : \""+ type.toString()+" disponible");
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

}
