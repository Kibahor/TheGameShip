package model.entity2;

public interface IHasComponements {
    void addComponement(Componement c);
    Componement getComponement(EType type);
    boolean isTypeOf(EType type);
}
