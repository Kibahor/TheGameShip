package model.collider;

import model.entity.IEntity;

public interface ICollider {
    boolean isCollision(IEntity e1, IEntity e2, String direction);
}
