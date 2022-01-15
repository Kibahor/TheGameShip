package model.move;

import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.IEntity;

public interface IMove {
    ColliderInfo move(IEntity e, ICollider c, String direction) throws Exception;
}
