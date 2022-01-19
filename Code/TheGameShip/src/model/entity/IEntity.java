package model.entity;


import java.util.UUID;

public interface IEntity extends IHasComponements{

    UUID getId();
    String getName();
    EComponementType getType();

    EEntityType getEntityType();

    boolean isTypeOf(EEntityType type);

}
