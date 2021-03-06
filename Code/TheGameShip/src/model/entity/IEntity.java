package model.entity;

import model.entity.componement.IHasComponements;
import java.util.UUID;

public interface IEntity extends IHasComponements {

    UUID getId();
    String getName();

    void setEntityType(EEntityType type);
    EEntityType getEntityType();
    boolean isTypeOf(EEntityType type);
}
