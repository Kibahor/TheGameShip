package model.game;

import javafx.collections.ObservableSet;
import model.entity.IEntity;

public interface IEntityCollection {
    ObservableSet<IEntity> getEntityCollection();
}
