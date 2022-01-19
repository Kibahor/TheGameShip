package launch;

import model.entity.Componement.EComponementType;
import model.entity.Entity;
import model.entity.Componement.EntityFabric;
import model.entity.Componement.Location;

public class Main {
    public static void main(String[] args) {
        EntityFabric fabrique=new EntityFabric();
        Entity test = fabrique.createPlayer("Vaisseau", "/Sprites/Spaceship.png", 70, 70, 1, 0, 250, 10, 10);
        Location l= (Location) test.getComponement(EComponementType.Location);
        System.out.println(l.getX());

    }
}