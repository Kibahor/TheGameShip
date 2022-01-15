package model;

public interface ILevel extends IHasEntityCollection {
   void init() throws Exception;
   void start() throws Exception;
   void exit() throws Exception;
}
