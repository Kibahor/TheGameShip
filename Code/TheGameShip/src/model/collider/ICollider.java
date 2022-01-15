package model.collider;

import model.entity.IEntity;

public interface ICollider {
    ColliderInfo isCollision(IEntity e, String direction) throws Exception;
}
