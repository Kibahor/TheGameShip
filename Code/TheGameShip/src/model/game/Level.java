package model.game;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableSet;
import launch.Launcher;
import model.collider.Collider;
import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.*;
import model.entity.componement.*;
import model.move.IMove;
import model.move.Move;
import model.move.MoveEnemy;
import model.util.data.HighScore;
import model.util.data.Settings;
import model.util.loop.Loop;
import model.util.loop.IObserver;
import model.util.input.ECommand;
import model.util.input.IInput;
import model.util.loop.Timer;
import model.util.save.PersistenceManager;

import java.util.ConcurrentModificationException;
import java.lang.Math;
import java.util.UUID;

//TODO: A la place faire une fabrique, qui se basera sur un fichier xml/json qui spécifie toute les caractéristiques

public class Level implements ILifeCycle, IObserver {

    private Loop loop;
    private Timer timer1 ;
    private Timer timer2 ;
    private Timer timer3 ;

    private IInput input;

    private final EntityManager entityManager = new EntityManager();
    private final EntityFabric entityFabric = new EntityFabric();

    private static Settings settings;

    private IEntity player;
    public IEntity getPlayer() { return player; }

    @Override public ObservableSet<IEntity> getEntityCollection() {
        return entityManager.getEntityCollection();
    }

    private IMove move = new Move();
    private IMove moveEnemy = new MoveEnemy();

    private ICollider collider = new Collider(this);

    private final IntegerProperty score = new SimpleIntegerProperty();
        public int getScore() { return score.get(); }
        public void setScore(int score) { this.score.set(score); }
        public IntegerProperty scoreProperty() { return score; }

    public Level(Loop loop, IInput input) {
        this.loop = loop;
        this.input = input;
    }

    @Override
    public void init() {
        timer1 = new Timer(loop);
        timer2 = new Timer(loop);
        timer3 = new Timer(loop);

        settings = new Settings();
        PersistenceManager.loadSettings(settings);

        //ENTITIES
        player = (entityFabric.createPlayer("Vaisseau", "/Sprites/Spaceship.png", 70, 70, 6 - settings.getDifficulty(), 0, 250, 10, 10));
        entityManager.addEntity(player);
        //entityManager.add(new Entity("Obstacle1","file://test.jpg", EType.Obstacle,35,5,500,500));
        entityManager.addEntity(entityFabric.createEnemy("Enemy1", "/Sprites/Enemy.png",70, 70, 5, 1000, 350));
    }

    public void updateShoot(IEntity e) {
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

    public void updatePlayer() {
        IEntity e = getPlayer();
        for (ECommand key : input.getKeyPressed()) {
            move.move(e, collider, key, Location.cast(e), Speed.cast(e));
            if (key.equals(ECommand.SHOOT)) {
                createShoot(e.getId(),Location.cast(e), ECommand.RIGHT, 500);
            }
        }
    }

    public void updateEnemy(IEntity e, long timer) {
        IEntity player = getPlayer();
        Location l = Location.cast(e);
        if(getPlayer() != null){
            l = Location.cast(player);
        }
        moveEnemy.move(e, collider, ECommand.LEFT, l , Speed.cast(e));
        if(timer2.getTimer() >= timer){
            createShoot(e.getId(), Location.cast(e), ECommand.LEFT, timer);
            timer2.resetTimer();
        }
    }

    public void createShoot(UUID id, Location l, ECommand key, long timer) {
        if (timer1.getTimer() >= timer) {
            entityManager.addEntity(entityFabric.createShoot(id, l, key));
            timer1.resetTimer();
        }
    }

    public void createNewWave(int min, int max, long timer) {
        double height = 70;
        double width = height;
        if (timer3.getTimer() >= timer) {
            double nbEnemy = Math.random() * (max - min + 1) + min;     //Math.random() * (max - min + 1) + min
            double ydiff = Launcher.getViewManager().getSceneHeight() / nbEnemy;
            double sceneWidth = Launcher.getStage().getWidth();

            for (int i = 0; i < nbEnemy; i++) {
                entityManager.addEntity(entityFabric.createEnemy((sceneWidth - width - 40), ((ydiff * i) - height), height, width));
            }
            timer3.resetTimer();
        }
    }

    @Override
    public void update() {
        try {
            for (IEntity e : getEntityCollection()) {
                switch (e.getEntityType()) {
                    case Player -> updatePlayer();
                    case Shoot -> updateShoot(e);
                    case Enemy -> updateEnemy(e, 800);
                }

                if (e.isTypeOf(EComponementType.Life)) {             //Gestion de la vie
                    //Si l'entité a de la vie
                    if (Life.cast(e).isDead()) {
                        entityManager.removeEntity(e);
                        if (e.getEntityType().equals(EEntityType.Enemy)){
                            setScore(getScore() + (int) settings.getDifficulty());
                        }
                    }
                }
            }

           createNewWave(1,2,10000);
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
        loop.subscribe(timer3);
        loop.subscribe(this);
    }

    @Override
    public void exit() {
        loop.unsubscribeAll();
        //TODO: Unscribe les événement ajouter aux boucle (créer une méthode destroy dans boucle)
    }
}