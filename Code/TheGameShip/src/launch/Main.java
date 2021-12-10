package launch;
import model.entity.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Entity test=new SimpleEntity(new URI("file://test.jpg"),100,100,"Test","Joueur");
        test.draw();
        System.out.println(test);

        Entity simplelife=new hasLifeDecorator(test,10);
        simplelife.draw();
        System.out.println(simplelife);
    }
}