package model.entity;
import javax.swing.text.html.parser.Entity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EntityManager
{
    private Set<IEntity> entities;

    public EntityManager() {
        this.entities = new HashSet();
    }

    public void add(IEntity e){
        entities.add(e);
    }
    public void delete(IEntity e){
        entities.remove(e);
    }

    public void move(String name) throws Exception
    {
        IEntity e1=this.getEntity(name);
        if(e1==null){
            return;
        }
        if(!(e1 instanceof MovableDecorator)) {
            throw new Exception("L'entitée ne peut pas se déplacer car elle n'hérite pas de MovableDecorator");
        }
        SimpleEntity se1 = (SimpleEntity) e1;
        float speedX = ((MovableDecorator)e1).getSpeedX();
        float speedY = ((MovableDecorator)e1).getSpeedY();
        se1.setX(se1.getX() + speedX);
        se1.setY(se1.getY() + speedY);
    }

    public void setLocation(String name, double x, double y) {
        IEntity e1=this.getEntity(name);
        if(e1==null){
            return;
        }
        ((SimpleEntity)e1).setX(x);
        ((SimpleEntity)e1).setY(y);
    }

    public void listEntity() {
        Iterator it = entities.iterator();
        while(it.hasNext()){
            IEntity e=(IEntity)it.next();
            System.out.println(e);
        }
    }

    private IEntity getEntity(String name){
        if(name.isEmpty()){
            return null;
        }
        Iterator it=entities.iterator();
        while(it.hasNext()){
            IEntity e=(IEntity)it.next();
            if(e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }
}
