package model.entity;

import java.util.UUID;

public interface IShoot {

    UUID getOwnerId();

    void setOwnerId(UUID ownerId);

    void applyToEntity(IEntity e) throws Exception;

    static IShoot cast(IEntity e) throws Exception {
        if (!(e instanceof IShoot)) {
            throw new Exception("L'Entité \"" + e.getName() + "\" n'implémente pas IShoot donc il ne peut être utiliser comme un tir !");
        }
        return (IShoot) e;
    }
}


