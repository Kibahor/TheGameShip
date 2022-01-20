package model.entity.componement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import model.entity.IEntity;

import java.util.HashSet;

public class ShootCollection extends Componement {

    private final ObservableSet<IEntity> shootList;
    public void addShoot(IEntity s){
        shootList.add(s);
    }
    public void removeAllShoot(){
        shootList.removeAll(shootList);
    }
    public ObservableSet<IEntity> getShootList(){
        return shootList;
    }

    public ShootCollection() {
        super(EComponementType.ShootCollection);
        shootList=FXCollections.observableSet(new HashSet<>());
    }

    public static ShootCollection cast(IHasComponements e){
        return (ShootCollection) e.getComponement(EComponementType.ShootCollection);
    }
}
