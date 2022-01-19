package launch;

import model.entity2.EType;
import model.entity2.Entity;
import model.entity2.EntityFabric;
import model.entity2.Location;

public class Main {
    public static void main(String[] args) {
        EntityFabric fabrique=new EntityFabric();
        Entity test = fabrique.createPlayer("Vaisseau", "/Sprites/Spaceship.png", 70, 70, 1, 0, 250, 10, 10);
        Location l= (Location) test.getComponement(EType.Location);
        System.out.println(l.getX());

    }
}