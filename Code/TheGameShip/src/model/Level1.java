package model;

import javafx.collections.ObservableSet;
import model.collider.Collider;
import model.collider.ColliderShoot;
import model.collider.ICollider;
import model.entity.*;
import model.move.IMove;
import model.move.Keyboard;
import model.move.MoveSpeed;

import java.util.ArrayList;

//TODO: A la place faire une fabrique, qui se basera sur un fichier xml/json qui spécifie toute les caractéristiques
public class Level1 implements ILevel, IObserver, IHasEntityCollection {

    private GameManager gameManager;

    private EntityManager entityManager;
        @Override public ObservableSet<IEntity> getUnusedEntityCollection(){return entityManager.getUnusedEntityCollection();}
        @Override public ObservableSet<IEntity> getUsedEntityCollection(){return entityManager.getUsedEntityCollection();}

    //TODO : List de IMove (extensibility et moins de duplication de code)
    //private IMove move;
    private IMove moveSpeed;

    //TODO : List de ICollider (extensibility et moins de duplication de code)
    private ICollider collider;
    private ICollider colliderShoot;

    public Level1(GameManager gameManager){
        this.gameManager=gameManager;
        entityManager=new EntityManager();

        moveSpeed = new MoveSpeed();
        collider = new Collider(this);
        colliderShoot=new ColliderShoot(this);
    }

    @Override
    public void init() throws Exception {
        //ENTITIES
        int nbShootPreGenerate=50;
        for(int i=0; i < nbShootPreGenerate; i++){
            entityManager.add(new Shoot());
        }
        entityManager.add(new Player("Vaisseau","file://test.jpg",100,360,20,5,5,5));
        entityManager.setUsedEntity("Vaisseau");
        entityManager.add(new Entity("Obstacle1","file://test.jpg", EType.Obstacle,35,5,500,500));
        entityManager.setUsedEntity("Obstacle1");
        entityManager.add(new Entity("Ennemy1","file://test.jpg", EType.Ennemy,20,5,700,300));
        entityManager.setUsedEntity("Ennemy1");
    }

    @Override
    public void start() {
        try {
            gameManager.boucle1.subscribe(this);
            gameManager.boucle1.subscribe(new Keyboard(this, new String[]{"UP", "DOWN", "LEFT", "RIGHT", "Z", "Q", "S", "D"}));
            gameManager.boucle2.subscribe(new Keyboard(this, new String[]{"SPACE"}));
        }
        catch(Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void exit() {
        //TODO: Unscribe les événement ajouter aux boucle (créer une méthode destroy dans boucle)
    }

    //TODO: eventuellement pour avoir un point d'extension, il faudrait que selon le type d'entité il y est une redéfinition du comportement
    @Override
    public void update() {
        for (IEntity e : getUsedEntityCollection()) {
            if (e instanceof Shoot) { //Si l'entité est un tir
                if(moveSpeed.right(e, colliderShoot).IsCollision()){
                    entityManager.setUnUsedEntity(e);
                }
            }
        }
    }

    public void movePlayer (String key) throws Exception {
        switch (key) {
            case "UP", "Z" -> moveSpeed.up(entityManager.getUsedEntity(EType.Player), collider); //DEBUG
            case "LEFT", "Q" -> moveSpeed.left(entityManager.getUsedEntity(EType.Player),collider);
            case "DOWN", "S" -> moveSpeed.down(entityManager.getUsedEntity(EType.Player),collider);
            case "RIGHT", "D" -> moveSpeed.right(entityManager.getUsedEntity(EType.Player),collider);
            case "SPACE" -> {
                IEntity s = entityManager.getUnUsedEntity(EType.Shoot); //Je récupère un tir qui n'est pas utilisé
                if (s instanceof Shoot) { //Il se peut que que cela soit autre chose qu'un tir
                    ((Shoot)s).applyToEntity(entityManager.getUsedEntity(EType.Player)); //Je donne l'appartenance du tir au joueur
                    entityManager.setUsedEntity(s); //Je l'ajoute à la collection des entitées visible
                }
            }
        }
    }
}
