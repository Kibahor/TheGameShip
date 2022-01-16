package model;

import model.input.ECommand;
import model.input.Input;
import model.collider.Collider;
import model.collider.ColliderInfo;
import model.collider.ICollider;
import model.entity.*;
import model.move.*;
import model.util.Boucle;
import model.util.IObserver;

import java.util.Collection;

//TODO: A la place faire une fabrique, qui se basera sur un fichier xml/json qui spécifie toute les caractéristiques
//Todo : Level1 doit hériter de Level qui contiendra les méthode et propriété de base et le comportement classique.

public class Level1 implements ILevel, IObserver, IHasEntityCollection {

    private Boucle boucle;

    private Input input;

    private EntityManager entityManager;
        @Override public Collection<IEntity> getUnusedEntityCollection(){return entityManager.getUnusedEntityCollection();}
        @Override public Collection<IEntity> getUsedEntityCollection(){return entityManager.getUsedEntityCollection();}

    private IMove move;

    private ICollider collider;

    //TODO:Donner Liste de boucle à la place du gameManager
    public Level1(Boucle boucle, Input input){
        this.boucle=boucle;
        this.input=input;
        entityManager=new EntityManager();
        move = new Move();
        collider = new Collider(this);
    }

    @Override
    public void init() throws Exception {
        //ENTITIES
        int nbShootPreGenerate=50;
        for(int i=0; i < nbShootPreGenerate; i++){
            entityManager.add(new Shoot());
        }
        entityManager.add(new Player("Vaisseau","file://test.jpg",50,50,1,0,250,5,5));
        entityManager.setUsedEntity("Vaisseau");
        /*entityManager.add(new Entity("Obstacle1","file://test.jpg", EType.Obstacle,35,5,500,500));
        entityManager.setUsedEntity("Obstacle1");*/
        entityManager.add(new Entity("Ennemy1","file://test.jpg", EType.Ennemy,40,40,5,150,300));
        entityManager.setUsedEntity("Ennemy1");
    }

    @Override
    public void start() {
        try {
            boucle.subscribe(this);
        }
        catch(Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void exit() {
        //TODO: Unscribe les événement ajouter aux boucle (créer une méthode destroy dans boucle)
    }

    //TODO: Au lieu de faire if/else, il faudrait trouver un autre moyen
    @Override
    public void update() {
        try {
            for (IEntity e : getUsedEntityCollection()) {
                if (e instanceof Player) { //Gestion mouvement du joueur
                    for (ECommand key : input.getKeyPressed()){
                        move.move(e, collider, key);
                        if(key.equals(ECommand.SHOOT)) {
                            IEntity s = entityManager.getUnUsedEntity(EType.Shoot); //Je récupère un tir qui n'est pas utilisé
                            IShoot.cast(s).applyToEntity(entityManager.getUsedEntity(EType.Player)); //Je donne l'appartenance du tir au joueur
                            entityManager.setUsedEntity(s); //Je l'ajoute à la collection des entitées visible
                        }
                    }
                } else if (e instanceof IShoot) { //Gestion des tirs
                    ColliderInfo ci=move.move(e, collider, ECommand.RIGHT);
                    if (ci.IsCollision()) {
                        entityManager.setUnUsedEntity(e);
                        if(ci.getEntity() instanceof IHasLife){
                            ((IHasLife) ci.getEntity()).decreaseHp();
                        }
                    }
                } else if(e instanceof IHasLife){ //Gestion de la vie
                    //Si l'entité a de la vie
                    if(((IHasLife) e).isDead()){
                        entityManager.setUnUsedEntity(e);
                    }
                }
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
