package model.entity2;

import java.util.*;

public class Entity extends Componement implements IEntity {
    private UUID id;
        @Override public UUID getId(){ return id; }

    private String name;
        @Override public String getName() { return name; }

    private final Map<EComponementType,Componement> componements = new HashMap<>();
        //public Set<EType> getTypes() { return types;}
        @Override public void addComponement(Componement c){
            componements.put(c.getType(),c);
        }
        @Override public Componement getComponement(EComponementType type){
            return componements.get(type);
        }
        @Override public boolean isTypeOf(EComponementType type) {
            return componements.keySet().contains(type);
        }

    private EEntityType type;
        @Override public EEntityType getEntityType(){ return type; }
        @Override public boolean isTypeOf(EEntityType type){
            return this.type.equals(type);
        }

    protected Entity(String name, EEntityType type) {
        super(EComponementType.Entity);
        this.type=type;
        this.id = UUID.randomUUID();
        this.name = name;
    }

}
