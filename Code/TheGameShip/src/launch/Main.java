package launch;
import model.entity.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Entity simpleEntity=new SimpleEntity(new URI("file://test.jpg"),100,100,"Test","Joueur");
        printEntity(simpleEntity);
        Entity hasLife=new HasLifeDecorator(simpleEntity,10);
        printEntity(hasLife);

    }

    public static void printEntity(Entity entity){
        System.out.print("Entity : ");
        entity.draw();
        System.out.println(entity+"\n");
    }
}