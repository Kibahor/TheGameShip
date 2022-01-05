package model.entity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EntityManager
{
    private Set<Entity> entities;

    public EntityManager() {
        this.entities = new HashSet();
    }

    public void add(Entity e){
        entities.add(e);
    }
    public void delete(Entity e){
        entities.remove(e);
    }

    public void move(Entity e1) throws Exception
    {
        if(!(e1 instanceof MovableDecorator)) {
            throw new Exception("L'entitée ne peut pas se déplacer car elle n'hérite pas de MovableDecorator");
        }
        SimpleEntity se1 = (SimpleEntity) e1;
        float speedX = ((MovableDecorator)e1).getSpeedX();
        float speedY = ((MovableDecorator)e1).getSpeedY();
        se1.setX(se1.getX() + speedX);
        se1.setY(se1.getY() + speedY);
    }
    //TODO:Utiliser le nom d'une entiter à la place d'une entité entière
    public void setLocation(Entity e1, double x, double y) {
        ((SimpleEntity)e1).setX(x);
        ((SimpleEntity)e1).setY(y);
    }

    public void listEntity() {
        Iterator it = entities.iterator();
        while(it.hasNext()){
            Entity e=(Entity)it.next();
            System.out.println(e);
        }
    }
}
