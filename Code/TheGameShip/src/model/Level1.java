package model;

import model.collider.Collider;
import model.collider.ColliderInfo;
import model.collider.ColliderShoot;
import model.collider.ICollider;
import model.entity.*;
import model.move.IMove;
import model.move.Keyboard;
import model.move.Move;

import java.util.Collection;

//TODO: A la place faire une fabrique, qui se basera sur un fichier xml/json qui spécifie toute les caractéristiques
//Todo : Level1 doit hériter de Level qui contiendra les méthode et propriété de base et le comportement classique.

public class Level1 implements ILevel, IObserver, IHasEntityCollection {

    private GameManager gameManager;

    private EntityManager entityManager;
        @Override public Collection<IEntity> getUnusedEntityCollection(){return entityManager.getUnusedEntityCollection();}
        @Override public Collection<IEntity> getUsedEntityCollection(){return entityManager.getUsedEntityCollection();}

    //TODO : Ne donner qu'un move qui en fonction du type de l'entités choisis le bon move
    //private IMove move;
    private IMove move;

    //TODO : Ne donner qu'un Collider qui en fonction du type de l'entités choisis le bon collider
    private ICollider collider;
    private ICollider colliderShoot;

    public Level1(GameManager gameManager){
        this.gameManager=gameManager;
        entityManager=new EntityManager();

        move = new Move();
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
        //TODO : Ajouter quand une entité n'a plus de vie et setUnUsedEntity()
        try {
            for (IEntity e : getUsedEntityCollection()) {
                //Gestion des tirs
                if (e instanceof IShoot) {
                    ColliderInfo ci=move.move(e, colliderShoot, "RIGHT");
                    if (ci.IsCollision()) {
                        System.out.println(ci);//DEBUG
                        entityManager.setUnUsedEntity(e);
                    }
                }
                //Gestion de la vie
                /*
                if(e instanceof IHasLife){ //Si l'entité a de la vie
                    e.decreaseHp();
                    System.out.println("Name : "+e1.getName()+" || Name : "+e.getName()+" HP : "+e.getHp());//DEBUG
                }*/
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void movePlayer (String key) throws Exception {
        IEntity e=entityManager.getUsedEntity(EType.Player);
        if(key.equals("SPACE")){
            IEntity s = entityManager.getUnUsedEntity(EType.Shoot); //Je récupère un tir qui n'est pas utilisé
            if (!(s instanceof Shoot)) { //Il se peut que que cela soit autre chose qu'un tir
                throw new Exception("Impossible d'ajouter le tir \""+e.getName()+"\" car il n'est pas une instance de Shoot");
            }
            ((Shoot)s).applyToEntity(entityManager.getUsedEntity(EType.Player)); //Je donne l'appartenance du tir au joueur
            entityManager.setUsedEntity(s); //Je l'ajoute à la collection des entitées visible
        }else {
            move.move(e, collider, key);
        }
    }
}
