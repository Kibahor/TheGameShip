package model.game;

import model.IEntityCollection;

//TODO: Voir si pas donner un autre nom
public interface ILevel extends IEntityCollection {

   void init();
   void start();
   void exit();

}
