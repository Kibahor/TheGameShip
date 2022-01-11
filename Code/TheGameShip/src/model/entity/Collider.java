package model.entity;

import launch.Launcher;
import model.entity.IEntity;

public class Collider {

    public static boolean isCollision(IEntity e1,String direction) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double radius = e1.getHitbox_radius();
        double height=Launcher.viewManager.getHeight()-1;
        double width=Launcher.viewManager.getWidth()-1;

        System.out.println((int)height+"x"+(int)width+" = X :"+x1+" Y :"+y1);//DEBUG
        //TODO: Quelque chose de pas clair avec la collison (-10 et -40)
        switch(direction){
            case "RIGHT":
                return  x1>=width-radius-10;
            case "LEFT":
                return x1<=0;
            case "UP":
                return y1<=0;
            case "DOWN":
                return y1>=height-radius-40;
        }
        return false;
        /*
        for(IEntity e2 : Launcher.entityManager.getAllEntity()){
            double x2 = e2.getX();
            double y2 = e2.getY();
            double dis = Math.sqrt((x2-x1)*(x2- x1) + (y2-y1)*(y2-y1)); //Distance entre deux points
            if((dis >= radius)){
                return true;
            }
        }
        return false;*/
    }
}
