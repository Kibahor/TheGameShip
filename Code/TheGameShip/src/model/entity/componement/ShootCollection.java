package model.entity.componement;

import model.entity.IEntity;

import java.util.HashSet;
import java.util.Set;

public class ShootCollection extends Componement {

    private Set<IEntity> shootList = new HashSet<>();
    public void addShoot(IEntity s){
        shootList.add(s);
    }
    public void removeShoot(IEntity s){
        shootList.remove(s);
    }
    public Set<IEntity> getShootList(){
        return shootList;
    }

    public ShootCollection() {
        super(EComponementType.ShootCollection);
    }

    public static ShootCollection cast(IHasComponements e){
        return (ShootCollection) e.getComponement(EComponementType.ShootCollection);
    }
}
