package model.entity.Componement;

public class Componement {
    private EComponementType type;
        public EComponementType getType(){ return type; }

    public Componement(EComponementType type){
        this.type=type;
    }
}
