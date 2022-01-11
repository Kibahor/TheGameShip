package model.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EntityManager {
    //TODO:Il faudrait que le set soit observable afin que quand il est un ajout, le monde l'affiche
    private final Set<IEntity> entities;

    public EntityManager() {
        this.entities = new HashSet<>();
    }

    public void add(IEntity e){
        entities.add(e);
    }

    public void delete(String entityName) throws Exception {
        entities.remove(getEntity(entityName));
    }

    public void listEntity() {
        for (IEntity e : entities) {
            System.out.println(e);
        }
    }

    public IEntity getEntity(String name) throws Exception {
        for (IEntity e : entities) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        throw new Exception("L'Entité \""+name+"\" n'existe pas");
    }

    public Set<IEntity> getAllEntity(){
        return entities;
    }
}
