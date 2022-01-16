package model.move;

import model.util.input.ECommand;
import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.IEntity;

public interface IMove {
    ColliderInfo move(IEntity e, ICollider c, ECommand key) throws Exception;
}
