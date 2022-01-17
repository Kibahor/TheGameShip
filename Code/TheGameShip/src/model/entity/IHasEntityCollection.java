package model.entity;

import java.util.Collection;

public interface IHasEntityCollection {
    Collection<IEntity> getUnusedEntityCollection();
    Collection<IEntity> getUsedEntityCollection();
}
