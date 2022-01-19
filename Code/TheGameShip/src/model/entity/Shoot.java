package model.entity;

import java.util.UUID;

public class Shoot extends Componement {

    private UUID ownerId;
        public UUID getOwnerId() { return ownerId; }
        public void setOwnerId(UUID ownerId) { this.ownerId = ownerId; }

    public Shoot(UUID ownerId){
        super(EComponementType.Shoot);
        setOwnerId(ownerId);
    }

    public static Shoot cast(IHasComponements e){
            return (Shoot) e.getComponement(EComponementType.Shoot);
    }

}
