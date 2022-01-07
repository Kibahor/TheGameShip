package model.entity;

public class Collider {

    public boolean Collider(IEntity e1, IEntity e2) throws Exception
    {
        if (!(e1 instanceof Entity) || !(e2 instanceof Entity)) {
            throw new Exception("L'entitée n'est pas une SimpleEntity, il ne possède donc pas de x, ni de y");
        }
        Entity se1=(Entity) e1;
        Entity se2=(Entity) e2;

        double x1 = se1.getX();
        double x2 = se2.getX();
        double y1 = se1.getY();
        double y2 = se2.getY();
        double radius = se1.getHitbox_radius();
        double dis = Math.sqrt((x2-x1)*(x2- x1) + (y2-y1)*(y2-y1)); //Distance entre deux points

        return (dis >= radius);
    }
}
