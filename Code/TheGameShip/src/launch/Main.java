package launch;
import model.Boucle;
import model.entity.*;
import java.net.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        //Exemple de jeu en javafx : https://edencoding.com/game-loop-javafx/
        Entity simpleEntity=new SimpleEntity(new URI("file://test.jpg"),"Test","Joueur");

        //printEntity(simpleEntity);
        Entity decorate = new EntityDecorator(new HasLifeDecorator(new MovableDecorator(simpleEntity,5, 5),10));
        //printEntity(decorate);
        EntityManager manager=new EntityManager();

        manager.add(simpleEntity);
        manager.add(decorate);
        manager.add(new SimpleEntity(new URI("file://blabla.jpg"),"Monstre","Ennemy"));
        manager.setLocation("Joueur",56,99);
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

    public static void printEntity(Entity entity){
        System.out.print("Entity : ");
        entity.draw();
        System.out.println(entity+"\n");
    }
}