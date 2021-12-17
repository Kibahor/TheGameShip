package model.entity;

public class Collider {

    public boolean Collider(Entity e1, Entity e2) throws Exception{
        if(!(e1 instanceof SimpleEntity)||!(e2 instanceof SimpleEntity)){
            throw new Exception("L'entitée n'est pas une SimpleEntity, il ne possède donc pas de x, ni de y");
        }
        SimpleEntity se1=(SimpleEntity) e1;
        SimpleEntity se2=(SimpleEntity) e2;
        double x1=se1.getX();
        double x2=se2.getX();
        double y1=se1.getY();
        double y2=se2.getY();
        double radius=se1.getHitbox_radius();
        double dis=Math.sqrt((x2-x1)*(x2- x1) + (y2-y1)*(y2-y1)); //Distance entre deux points
        return (dis >= radius);
    }
}
