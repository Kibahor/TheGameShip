package launch;
import model.Boucle;
import model.entity.*;


public class Main {
    public static void main(String[] args) throws Exception {
        //Exemple de jeu en javafx : https://edencoding.com/game-loop-javafx/
        IEntity simpleIEntity =new Entity("file://test.jpg","Test","Joueur");

        //printEntity(simpleEntity);
        IEntity decorate = new EntityDecorator(new HasLifeDecorator(new MovableDecorator(simpleIEntity,5, 5),10));
        //printEntity(decorate);
        EntityManager manager=new EntityManager();

        manager.add(simpleIEntity);
        manager.add(decorate);
        manager.add(new Entity("file://blabla.jpg","Monstre","Ennemy"));
        //manager.setLocation("Joueur",56,99);
        //printEntity(simpleEntity);

        //Problème de détection de MovableDecorator dans manager.move()
        //manager.moveX(decorate);
        //printEntity(decorate);

        //Le set ne doit posséder qu'un seul objet avec un unique id
        manager.listEntity();

        // Création et lancement du beeper
        Thread b = new Thread(new Boucle());
        b.start();
    }

    public static void printEntity(IEntity IEntity){
        System.out.print("Entity : ");
        IEntity.printDecorationName();
        System.out.println(IEntity +"\n");
    }
}