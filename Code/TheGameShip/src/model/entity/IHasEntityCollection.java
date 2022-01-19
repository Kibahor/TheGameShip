package model.entity;

import java.util.Collection;

public interface IHasEntityCollection {
    Collection<IEntity> getEntityCollection();
    Collection<IEntity> getUsedEntityCollection();
}
