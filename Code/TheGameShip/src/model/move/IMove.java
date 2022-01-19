package model.move;

import model.entity2.IEntity;
import model.util.input.ECommand;
import model.collider.ColliderInfo;
import model.collider.ICollider;

public interface IMove {
    ColliderInfo move(IEntity e, ICollider c, ECommand key) ;
}
