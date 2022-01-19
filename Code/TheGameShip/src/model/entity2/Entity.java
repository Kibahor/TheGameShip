package model.entity2;

import java.util.*;

public class Entity extends Componement implements IHasComponements  {
    private UUID id;
        public UUID getId(){ return id; }

    private String name;
        public String getName() { return name; }

    private final Map<EType,Componement> componements = new HashMap<>();
        //public Set<EType> getTypes() { return types;}
        @Override public void addComponement(Componement c){
            componements.put(c.getType(),c);
        }
        @Override public Componement getComponement(EType type){
            return componements.get(type);
        }
        @Override public boolean isTypeOf(EType type) {
            return componements.keySet().contains(type);
        }

    protected Entity(String name) {
        super(EType.Entity);
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
