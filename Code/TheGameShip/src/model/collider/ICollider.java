package model.collider;

import model.entity.IEntity;

public interface ICollider {
    boolean isCollision(IEntity e, String direction);
}
