package model.entity;
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
    public void listEntity() {
        Iterator it = entities.iterator();
        while(it.hasNext()){
            IEntity e=(IEntity)it.next();
            System.out.println(e);
        }
    }

    public IEntity getEntity(String name){
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
