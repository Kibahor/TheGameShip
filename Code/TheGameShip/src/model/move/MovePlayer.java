package model.move;

import launch.Launcher;
import model.entity.Entity;

public class MovePlayer extends Move{

    public MovePlayer(String entityName) throws Exception {
        super(entityName);
    }

    //TODO:Override left,right,up,down et ajouter vitesse en plus
}
