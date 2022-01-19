package model.entity2;


import java.util.UUID;

public interface IEntity extends IHasComponements{

    UUID getId();
    String getName();
    EComponementType getType();
    boolean isTypeOf(EEntityType type);

}
