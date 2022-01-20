package model.game;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableSet;
import launch.Launcher;
import model.collider.Collider;
import model.collider.ColliderEnemy;
import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.EEntityType;
import model.entity.EntityFabric;
import model.entity.EntityManager;
import model.entity.IEntity;
import model.entity.componement.*;
import model.move.IMove;
import model.move.Move;
import model.move.MoveEnemy;
import model.util.input.ECommand;
import model.util.input.IInput;
import model.util.loop.IObserver;
import model.util.loop.Loop;
import model.util.loop.Timer;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.UUID;

public class Level implements IEntityCollection, ILifeCycle, IObserver {

    private final Loop loop;
    private Timer timer1;
    private Timer timer2;
    private Timer timer3;

    private final IInput input;

    private final EntityManager entityManager = new EntityManager();
    private final EntityFabric entityFabric = new EntityFabric();

    private IEntity player;
        public IEntity getPlayer() { return player; }

    @Override public ObservableSet<IEntity> getEntityCollection() {
        return entityManager.getEntityCollection();
    }

    private IMove move = new Move();
    private IMove moveEnemy = new MoveEnemy();

    private final ICollider collider = new Collider(getEntityCollection());
    private final ICollider colliderEnemy = new ColliderEnemy(getEntityCollection());

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

        //ENTITIES
        player = (entityFabric.createPlayer("Vaisseau", "/Sprites/Spaceship.png", 70, 70, 6 - Launcher.getPersistenceManager().getSettings().getDifficulty(), 0, 250, 10, 10));
        entityManager.addEntity(player);
        createNewWave(1,2,0);
        //entityManager.add(new Entity("Obstacle1","file://test.jpg", EType.Obstacle,35,5,500,500));
    }

    private void updateShoot(IEntity e) {
        for (IEntity e2 : ShootCollection.cast(e).getShootList()) {
            ColliderInfo ci = move.move(e2, collider, Shoot.cast(e2).getDirection(), Location.cast(e2), Speed.cast(e2));
            if (ci.IsCollision()) {
                Life.cast(e).setDead(true);
                if (ci.getEntity() != null) {
                    Life.cast(ci.getEntity()).decreaseHp();
                }
            }
        }
    }

    private void updatePlayer() {
        IEntity e = getPlayer();
        for (ECommand key : input.getKeyPressed()) {
            move.move(e, collider, key, Location.cast(e), Speed.cast(e));
            if (key.equals(ECommand.SHOOT)) {
                createShoot(e,Location.cast(e), ECommand.RIGHT, 500);
            }
        }
        updateShoot(e);
    }

    private void updateEnemy(IEntity e, long timer) {
        IEntity player = getPlayer();
        Location l = Location.cast(e);
        if(getPlayer() != null){
            l = Location.cast(player);
        }
        ColliderInfo ci = moveEnemy.move(e, colliderEnemy, ECommand.LEFT, l, Speed.cast(e));
        if (timer2.getTimer() >= timer) {
            createShoot(e, Location.cast(e), ECommand.LEFT, timer);
            timer2.resetTimer();
        }
        if(ci.IsCollision() && ci.getEntity() == null){
            entityManager.removeEntity(e);
        }
        updateShoot(e);
    }

    private void createShoot(IEntity e, Location l, ECommand key, long timer) {
        if (timer1.getTimer() >= timer) {
            entityFabric.createShoot(e, l, key);
            timer1.resetTimer();
        }
    }

    private void createNewWave(int min, int max, long timer) {
        double height = 70;
        double width = height;
        if (timer3.getTimer() >= timer) {
            double nbEnemy = Math.random() * (max - min + 1) + min;     //Math.random() * (max - min + 1) + min
            double ydiff = Launcher.getViewManager().getSceneHeight() / nbEnemy;
            double sceneWidth = Launcher.getStage().getWidth();

            for (int i = 0; i < nbEnemy; i++) {
                double x = (sceneWidth + width - 20);
                double y = ((ydiff * i) - height);
                entityManager.addEntity(entityFabric.createEnemy(x, y, height, width));
            }
            timer3.resetTimer();
        }
    }

    @Override
    public void update() {
        try {
            List<IEntity> listToBurn = new ArrayList<>();       // Création d'une liste temporaire pour stocker les entitées à supprimer

            for (IEntity e : new ArrayList<>(getEntityCollection())) {
                switch (e.getEntityType()) {
                    case Player -> updatePlayer();
                    case Enemy -> updateEnemy(e, 800);
                }

                if (e.isTypeOf(EComponementType.Life)) {    //Gestion de la vie
                    if (Life.cast(e).isDead()) {            //Si l'entité a de la vie
                        listToBurn.add(e);
                        if (e.getEntityType().equals(EEntityType.Enemy)) {
                            setScore(getScore() + (int) Launcher.getPersistenceManager().getSettings().getDifficulty());
                        }
                    }
                }
            }
            for (final var e : listToBurn) {
                entityManager.removeEntity(e);
            }

            createNewWave(1, 2, 10000);
        } catch (ConcurrentModificationException err) { //TODO : trouver pourquoi Concurrent Access
            err.printStackTrace();
        } catch (Exception err) {
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
    }
}