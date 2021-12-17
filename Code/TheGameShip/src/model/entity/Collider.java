package model.entity;

public class Collider {

    public boolean Collider(Entity e1, Entity e2) throws Exception{
        if(!(e1 instanceof SimpleEntity)||!(e2 instanceof SimpleEntity)){
            throw new Exception("L'entitée n'est pas une SimpleEntity, il ne possède donc pas de x, ni de y");
        }
        double x1=((SimpleEntity)e1).getX();
        double x2=((SimpleEntity)e2).getX();
        double y1=((SimpleEntity)e1).getY();
        double y2=((SimpleEntity)e2).getY();
        double radius=((SimpleEntity)e2).getHitbox_radius();
        double dis=Math.sqrt((x2-x1)*(x2- x1) + (y2-y1)*(y2-y1)); //Distance entre deux points
        return (dis >= radius);
    }
}
