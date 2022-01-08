package model.entity;

import java.util.UUID;

public class ShootDecorator extends EntityDecorator {
    UUID OwnerId;

    public ShootDecorator(IEntity IEntity, UUID OwnerID) {
        super(IEntity);
        this.OwnerId = OwnerID;
    }

    @Override
    public void draw() {
        entity.draw();
        System.out.print("Shoot "); //DEBUG
        // ...
    }

    public UUID getOwnerId() { return OwnerId; }
    public void setOwnerId() { this.OwnerId = OwnerId; }
}
