package model.entity2;

public class Componement {
    private EComponementType type;
        public EComponementType getType(){ return type; }

    public Componement(EComponementType type){
        this.type=type;
    }
}
