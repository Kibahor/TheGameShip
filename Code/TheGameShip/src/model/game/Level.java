package model.game;

import javafx.collections.ObservableSet;
import model.collider.Collider;
import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.*;
import model.entity.componement.*;
import model.move.IMove;
import model.move.Move;
import model.move.MoveEnemy;
import model.util.loop.Loop;
import model.util.loop.IObserver;
import model.util.input.ECommand;
import model.util.input.IInput;
import model.util.loop.Timer;

import java.util.ConcurrentModificationException;
import java.util.UUID;

//TODO: A la place faire une fabrique, qui se basera sur un fichier xml/json qui spécifie toute les caractéristiques

public class Level implements ILevel, IObserver {

    private Loop loop;
    private Timer timer1 ;
    private Timer timer2 ;

    private IInput input;

    private final EntityManager entityManager = new EntityManager();
    private final EntityFabric entityFabric = new EntityFabric();;

    @Override public ObservableSet<IEntity> getEntityCollection() {
        return entityManager.getEntityCollection();
    }

    private IMove move = new Move();
    private IMove moveEnemy = new MoveEnemy();

    private ICollider collider = new Collider(this);

    private int score = 0;
        public int getScore() { return score; }

    public Level(Loop loop, IInput input) {
        this.loop = loop;
        timer1 = new Timer(loop);
        timer2 = new Timer(loop);
        this.input = input;
    }

    @Override
    public void init() {
        //ENTITIES
        entityManager.addEntity(entityFabric.createPlayer("Vaisseau", "/Sprites/Spaceship.png", 70, 70, 1, 0, 250, 10, 10));
        //entityManager.add(new Entity("Obstacle1","file://test.jpg", EType.Obstacle,35,5,500,500));
        entityManager.addEntity(entityFabric.createEnemy("Enemy1", "/Sprites/Enemy.png",70, 70, 5, 1000, 350));
    }

    public void updateShoot(IEntity e){
        UUID ownerId = Shoot.cast(e).getOwnerId();
        for (IEntity e2 : getEntityCollection()) {
            if (e2.getId().equals(ownerId)) {
                ColliderInfo ci = move.move(e, collider, Shoot.cast(e).getDirection(), Location.cast(e), Speed.cast(e) );
                if (ci.IsCollision()) {
                    entityManager.removeEntity(e);
                    if (ci.getEntity() != null) {
                        Life.cast(ci.getEntity()).decreaseHp();
                    }
                }
            }
        }
    }

    public void updatePlayer(){
        IEntity e = entityManager.getPlayer();
        for (ECommand key : input.getKeyPressed()) {
            move.move(e, collider, key, Location.cast(e), Speed.cast(e));
            if (key.equals(ECommand.SHOOT)) {
                createShoot(e.getId(),Location.cast(e), ECommand.RIGHT);
            }
        }
        //Life.cast(e).setDead(true); //DEBUG : Pour tester l'écran de game over
    }

    public void updateEnemy(IEntity e){
        IEntity player = entityManager.getPlayer();
        Location l = Location.cast(e);
        if(entityManager.getPlayer()!=null){
            l=Location.cast(player);
        }
        moveEnemy.move(e, collider, ECommand.LEFT, l , Speed.cast(e));
        if(timer2.getTimer() >= 800){
            createShoot(e.getId(), Location.cast(e), ECommand.LEFT);
            timer2.resetTimer();
        }
    }

    public void createShoot(UUID id, Location l, ECommand key){
        if (timer1.getTimer() >= 500) {
            entityManager.addEntity(entityFabric.createShoot(id, l, key));
            timer1.resetTimer();
        }
    }

    @Override
    public void update() {
        try {
            for (IEntity e : getEntityCollection()) {
                switch (e.getEntityType()) {
                    case Player -> updatePlayer();
                    case Shoot -> updateShoot(e);
                    case Ennemy -> updateEnemy(e);
                }

                if (e.isTypeOf(EComponementType.Life)) {             //Gestion de la vie
                    //Si l'entité a de la vie
                    if (Life.cast(e).isDead()) { entityManager.removeEntity(e); }
                }
            }
        }
        catch (ConcurrentModificationException err) { //TODO : trouver pourquoi Concurrent Access
            //err.printStackTrace();
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void start() {
        loop.subscribe(timer1);
        loop.subscribe(timer2);
        loop.subscribe(this);
    }

    @Override
    public void exit() {
        //TODO: Unscribe les événement ajouter aux boucle (créer une méthode destroy dans boucle)
    }
}