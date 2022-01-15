package model.entity;

public interface IReset {
    //todo : Voir si il ne faut l'appliquer qu'aux interfaces (au lieu des entités)
    //(il faudrait créer une classe abstraite par interface concerner et redéfinire reset() dedans au lieu de le faire dans entité)
    //Les interface deviendrait package private et seul les class abstraite créé plus tôt pourrait les implémenter
    //Ensuite au lieu d'implémenter une interface dans l'entités on étend de la classe abstraite (pas sûr il faut y réfléchir avant de le faire)
    void reset();
}
