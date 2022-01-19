package model.entity.Componement;

public interface IHasComponements {
    void addComponement(Componement c);
    Componement getComponement(EComponementType type);
    boolean isTypeOf(EComponementType type);
}
