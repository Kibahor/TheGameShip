package model.entity;


import model.entity.componement.EComponementType;
import model.entity.componement.IHasComponements;

import java.util.UUID;

public interface IEntity extends IHasComponements {

    UUID getId();
    String getName();
    EComponementType getType();

    EEntityType getEntityType();

    boolean isTypeOf(EEntityType type);

}
