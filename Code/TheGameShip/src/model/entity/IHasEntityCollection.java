package model.entity;

import model.entity.IEntity;

import java.util.Collection;

public interface IHasEntityCollection {
    Collection<IEntity> getUnusedEntityCollection();
    Collection<IEntity> getUsedEntityCollection();
}
