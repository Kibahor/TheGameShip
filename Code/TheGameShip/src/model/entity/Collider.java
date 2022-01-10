package model.entity;

import launch.Launcher;
import model.entity.IEntity;

public class Collider {

    public static boolean isCollision(IEntity e1) throws Exception
    {
        double x1 = e1.getX();
        System.out.println("X : "+x1);//DEBUG
        double y1 = e1.getY();
        System.out.println("Y : "+y1);//DEBUG
        double radius = e1.getHitbox_radius() / 2;
        double height=Launcher.viewManager.getHeight()-1;
        double width=Launcher.viewManager.getWidth()-1;
        if(x1<radius || x1>width-radius){
            return true;
        }else if(y1<radius || y1>height-radius){
            return true;
        }
        for(IEntity e2 : Launcher.entityManager.getAllEntity()){
            double x2 = e2.getX();
            double y2 = e2.getY();
            double dis = Math.sqrt((x2-x1)*(x2- x1) + (y2-y1)*(y2-y1)); //Distance entre deux points
            if((dis >= radius)){
                return true;
            }
        }
        return false;
    }
}
