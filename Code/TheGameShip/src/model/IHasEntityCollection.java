package model;

import javafx.collections.ObservableSet;
import model.entity.IEntity;

public interface IHasEntityCollection {
    ObservableSet<IEntity> getUnusedEntityCollection();
    ObservableSet<IEntity> getUsedEntityCollection();
}
