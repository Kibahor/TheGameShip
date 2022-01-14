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

    private volatile ArrayList<IEntity> usedShoot =new ArrayList<>();//DEBUG //TODO : enlever sa
    private Player player;

    //TODO : List de IMove (extendibilité et moins de duplication de code)
    //private IMove move;
    private IMove moveSpeed;

    //TODO : List de ICollider (extendibilité et moins de duplication de code)
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
    public void init() {
        //ENTITIES
        player = new Player("Vaisseau","file://test.jpg",100,360,20,5,5,5,true); //DEBUG
        int nbShootPreGenerate=100;
        for(int i=0; i < nbShootPreGenerate; i++){
            entityManager.add(new Shoot());
        }
        entityManager.add(player);
        //entityManager.add(new Entity("Obstacle1","file://test.jpg", Type.Obstacle,35,5,500,500,true ));
        entityManager.add(new Entity("Ennemy1","file://test.jpg", EType.Ennemy,20,5,700,300,true));
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
        try {
            for (IEntity e : usedShoot) {
                if (e instanceof Shoot) { //Si l'entité est un tir
                    moveSpeed.right(e, colliderShoot);
                    ColliderInfo i=colliderShoot.isCollision(e, "RIGHT");
                    if (i.IsCollision()) {  //Si le tir est en collision
                        IEntity e2=i.getEntity();
                        if(e2 != null){ //Si e est null c'est que la collision a été faite sur la scene
                            if(e2 instanceof IHasLife){ //Si l'entité a de la vie
                                ((IHasLife)e2).setHp(((IHasLife)e2).getHp()-1); //TODO : créer des méthodes qui permettent d'incrémenter ou augmenter vie
                                System.out.println("Name : "+e2.getName()+" || HP : "+((IHasLife)e2).getHp());//DEBUG
                            }
                        }
                        ((Shoot) e).reset(); //TODO : Appliquer le même systeme pour toute les entités
                        usedShoot.remove(e);
                    }
                }
            }
        } catch(Exception err) {
            err.printStackTrace();
            //TODO:ConccurentException : gérer la gestion concurrente des ressources entre le thread principal et la boucle : https://www.jmdoudoux.fr/java/dej/chap-acces_concurrents.htm
        }
    }

    public void movePlayer (String key) {
        switch (key) {
            case "UP", "Z" -> moveSpeed.up(player,collider);
            case "LEFT", "Q" -> moveSpeed.left(player,collider);
            case "DOWN", "S" -> moveSpeed.down(player,collider);
            case "RIGHT", "D" -> moveSpeed.right(player,collider);
            case "SPACE" -> {
                Shoot s = getEmptyShoot();
                if (s != null) {
                    s.applyToEntity(player);
                    usedShoot.add(s);
                }
            }
        }
    }

    //TODO : le remplacer par la méthode générique de l'entity manager
    public Shoot getEmptyShoot() {
        for (IEntity e : getUnusedEntityCollection()) {
            if (e instanceof Shoot) {
                return (Shoot)e;
            }
        }
        return null;
    }
}
