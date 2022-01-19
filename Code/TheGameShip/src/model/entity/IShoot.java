package model.entity;

import java.util.UUID;

public interface IShoot {

    UUID getOwnerId();

    void setOwnerId(UUID ownerId);

    void applyToEntity(IEntity e);

    static IShoot cast(IEntity e) {
        if (!(e instanceof IShoot)) {
            System.err.println("L'Entité \"" + e.getName() + "\" n'implémente pas IShoot donc il ne peut être utiliser comme un tir !");
            return null;
        }
        return (IShoot) e;
    }

}


