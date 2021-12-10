package model.entity;

import java.util.UUID;

public class ShootDecorator extends EntityDecorator{
    UUID OwnerId;

    public ShootDecorator(Entity entity, UUID OwnerID) {
        super(entity);
        this.OwnerId = OwnerID;
    }

    @Override
    public void draw() {
        decoratedEntity.draw();
        // ...
    }

    public UUID getOwnerId() { return OwnerId; }

    public void setOwnerId() { this.OwnerId = OwnerId; }
}
