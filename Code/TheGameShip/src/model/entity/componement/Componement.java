package model.entity.componement;

public abstract class Componement {
    private final EComponementType type;
        public EComponementType getType(){ return type; }

    public Componement(EComponementType type){
        this.type=type;
    }
}
