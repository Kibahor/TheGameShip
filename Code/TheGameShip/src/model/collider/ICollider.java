package model.collider;

import model.ColliderInfo;
import model.entity.IEntity;

public interface ICollider {
    ColliderInfo isCollision(IEntity e, String direction);
}
