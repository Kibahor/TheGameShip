package model;

import javafx.collections.ObservableSet;
import model.entity.IEntity;

public interface ILevel {
   void init();
   void start();
   void exit();
   ObservableSet<IEntity> getSetEntity();
}
