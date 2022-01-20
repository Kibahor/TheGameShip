package model.game;

//TODO: Voir si pas donner un autre nom
public interface ILifeCycle extends IEntityCollection {

   void init();
   void start();
   void exit();

}
