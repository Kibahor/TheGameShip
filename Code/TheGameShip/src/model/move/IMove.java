package model.move;

import model.collider.ICollider;
import model.entity.IEntity;

public interface IMove {
    void left(IEntity e, ICollider c);
    void right(IEntity e, ICollider c);
    void up(IEntity e, ICollider c);
    void down(IEntity e, ICollider c);
    void shoot(IEntity e, ICollider c);
}
