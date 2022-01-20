package launch;

import model.entity.componement.EComponementType;
import model.entity.Entity;
import model.entity.componement.EntityFabric;
import model.entity.componement.Location;

public class Main {
    public static void main(String[] args) {
        EntityFabric fabrique=new EntityFabric();
        Entity test = fabrique.createPlayer("Vaisseau", "/Sprites/Spaceship.png", 70, 70, 1, 0, 250, 10, 10);
        Location l= (Location) test.getComponement(EComponementType.Location);
        System.out.println(l.getX());

    }
}