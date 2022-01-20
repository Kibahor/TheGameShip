package model.move;

import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.IEntity;
import model.entity.componement.Location;
import model.entity.componement.Speed;
import model.util.input.ECommand;

public interface IMove {
    ColliderInfo move(IEntity e, ICollider c, ECommand key, Location l, Speed s) ;
}
