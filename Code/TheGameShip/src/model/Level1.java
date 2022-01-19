package model;

import javafx.collections.ObservableSet;
import model.entity.EType;
import model.entity2.*;
import model.util.input.ECommand;
import model.util.input.IInput;
import model.collider.Collider;
import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.move.*;
import model.util.Boucle;
import model.util.IObserver;

import java.util.UUID;

//TODO: A la place faire une fabrique, qui se basera sur un fichier xml/json qui spécifie toute les caractéristiques

public class Level1 implements ILevel, IObserver {

    private Boucle boucle;

    private IInput input;

    private EntityManager entityManager;
    private final EntityFabric entityFabric;

    @Override public ObservableSet<IEntity> getEntityCollection() {
        return entityManager.getEntityCollection();
    }

    private IMove move;

    private ICollider collider;

    public Level1(Boucle boucle, IInput input) {
        this.boucle = boucle;
        this.input = input;
        entityManager = new EntityManager();
        entityFabric = new EntityFabric();
        move = new Move();
        collider = new Collider(this);
    }

    @Override
    public void init() {
        //ENTITIES
        entityManager.addEntity(entityFabric.createPlayer("Vaisseau", "/Sprites/Spaceship.png", 70, 70, 1, 0, 250, 10, 10));
        /*entityManager.add(new Entity("Obstacle1","file://test.jpg", EType.Obstacle,35,5,500,500));
        entityManager.setUsedEntity("Obstacle1");
        entityManager.add(new Entity("Ennemy1", "/Sprites/Ennemie1.png", EType.Ennemy, 70, 70, 5, 650, 300));
        entityManager.setUsedEntity("Ennemy1");*/
    }

    @Override
    public void start() {
        boucle.subscribe(this);
    }

    @Override
    public void exit() {
        //TODO: Unscribe les événement ajouter aux boucle (créer une méthode destroy dans boucle)
    }

    public void updateShoot(IEntity e, ECommand key) {
        ColliderInfo ci = move.move(e, collider, key);
        if (ci.IsCollision()) {
            entityManager.removeEntity(e);
            if (ci.getEntity().isTypeOf(EComponementType.Life)) {
                Life.cast(ci.getEntity()).decreaseHp();
            }
        }
    }

    public void createShoot(UUID id){
        if (boucle.getTimer() >= 500) {
            entityManager.addEntity(entityFabric.createShoot(e.getId()));
            boucle.resetTimer();
        }
    }
    //TODO: Au lieu de faire if/else, il faudrait trouver un autre moyen
    // Le switch est compliqué
    @Override
    public void update() {
        try {
            for (IEntity e : getEntityCollection()) {
                if (e.isTypeOf(EEntityType.Player)) {                              //Gestion mouvement du joueur
                    for (ECommand key : input.getKeyPressed()) {
                        move.move(e, collider, key);
                        if (key.equals(ECommand.SHOOT)) {
                            createShoot(e.getId());
                        }
                    }
                }
                else if (e.isTypeOf(EEntityType.Shoot)) {                 //Gestion des tirs
                    UUID id = Shoot.cast(e).getOwnerId();
                    for (IEntity e2 : getEntityCollection()) {
                        if (e2.getId() == id) {
                            if (e2.isTypeOf(EEntityType.Player)) { updateShoot(e, ECommand.RIGHT); }
                            else { updateShoot(e, ECommand.LEFT); }
                        }
                    }
                }
                else if (e.isTypeOf(EComponementType.Life)) {             //Gestion de la vie
                    //Si l'entité a de la vie
                    if (Life.cast(e).isDead()) { entityManager.removeEntity(e); }
                }
            }
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }
}