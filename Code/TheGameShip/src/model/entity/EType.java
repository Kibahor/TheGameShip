package model.entity;

public enum EType {
    //TODO : Voir quelle est le mieux ->
    // - Soit on se base l'interface, if(entity instanceof INomInterface)
    // - Soit on se base l'enumération, e.getType().equals(EType.TYPE) -> mais il se peut ne pas implémenter les interfaces
    Player,
    Ennemy,
    Shoot,
    Obstacle
}
