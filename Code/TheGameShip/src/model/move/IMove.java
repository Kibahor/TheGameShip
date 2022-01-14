package model.move;

import model.ColliderInfo;
import model.collider.ICollider;
import model.entity.IEntity;

public interface IMove {
    ColliderInfo left(IEntity e, ICollider c);
    ColliderInfo right(IEntity e, ICollider c);
    ColliderInfo up(IEntity e, ICollider c);
    ColliderInfo down(IEntity e, ICollider c);
}
