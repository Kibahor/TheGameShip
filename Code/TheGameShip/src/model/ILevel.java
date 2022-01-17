package model;

import model.entity.IHasEntityCollection;

//TODO: Voir si pas donner un autre nom
public interface ILevel extends IHasEntityCollection {

   void init() throws Exception;
   void start() throws Exception;
   void exit() throws Exception;
}
