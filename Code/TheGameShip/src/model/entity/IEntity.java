package model.entity;


import model.entity.Componement.EComponementType;
import model.entity.Componement.IHasComponements;

import java.util.UUID;

public interface IEntity extends IHasComponements {

    UUID getId();
    String getName();
    EComponementType getType();

    EEntityType getEntityType();

    boolean isTypeOf(EEntityType type);

}
