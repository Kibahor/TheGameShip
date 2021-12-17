package launch;
import model.entity.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Entity simpleEntity=new SimpleEntity(new URI("file://test.jpg"),"Test","Joueur");
        printEntity(simpleEntity);
        Entity decorate=new EntityDecorator(new HasLifeDecorator(new MovableDecorator(simpleEntity,5),10));
        printEntity(decorate);
        EntityManager manager=new EntityManager();

        manager.add(simpleEntity);
        manager.add(decorate);
        manager.setLocation(simpleEntity,56,99);
        printEntity(simpleEntity);

        System.out.println(decorate instanceof EntityDecorator);
        //manager.moveX(decorate);
        //printEntity(decorate);

    }

    public static void printEntity(Entity entity){
        System.out.print("Entity : ");
        entity.draw();
        System.out.println(entity+"\n");
    }
}