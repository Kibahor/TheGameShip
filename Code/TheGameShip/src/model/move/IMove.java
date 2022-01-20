package model.move;

import model.entity.componement.Location;
import model.entity.componement.Speed;
import model.entity.IEntity;
import model.util.input.ECommand;
import model.collider.ColliderInfo;
import model.collider.ICollider;

public interface IMove {
    ColliderInfo move(IEntity e, ICollider c, ECommand key, Location l, Speed s) ;
}
