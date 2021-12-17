package launch;
import model.entity.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {
        //Exemple de jeu en javafx : https://edencoding.com/game-loop-javafx/
        Entity simpleEntity=new SimpleEntity(new URI("file://test.jpg"),"Test","Joueur");
        //printEntity(simpleEntity);
        Entity decorate=new EntityDecorator(new HasLifeDecorator(new MovableDecorator(simpleEntity,5),10));
        //printEntity(decorate);
        EntityManager manager=new EntityManager();

        manager.add(simpleEntity);
        manager.add(decorate);
        manager.add(new SimpleEntity(new URI("file://blabla.jpg"),"Monstre","Ennemy"));
        manager.setLocation(simpleEntity,56,99);
        //printEntity(simpleEntity);

        //Problème de détection de MovableDecorator dans manager.move()
        //manager.moveX(decorate);
        //printEntity(decorate);

        //Le set ne doit posséder qu'un seul objet avec un unique id
        manager.listEntity();
    }

    public static void printEntity(Entity entity){
        System.out.print("Entity : ");
        entity.draw();
        System.out.println(entity+"\n");
    }
}