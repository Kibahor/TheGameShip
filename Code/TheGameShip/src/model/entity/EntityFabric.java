package model.entity;

import model.entity.componement.*;
import model.util.input.ECommand;
import java.util.UUID;

public class EntityFabric {

    private long numberShoot = 0;

    private long getShootNumber() {
        numberShoot++;
        return numberShoot;
    }

    private long numberEnemy = 0;

    private long getEnemyNumber() {
        numberEnemy++;
        return numberEnemy;
    }

    public Entity createPlayer(String name, String sprite, double height, double width, double hp, double x, double y, float speedX, float speedY) {
        Entity e = new Entity(name, EEntityType.Player);
        e.addComponement(new Sprite(sprite));
        e.addComponement(new Location(x, y, height, width));
        e.addComponement(new Life(hp));
        e.addComponement(new Speed(speedX, speedY));
        e.addComponement(new ShootCollection());
        return e;
    }

    public Entity createEnemy(String name, String sprite, double height, double width, double hp, double x, double y) {
        Entity e = createPlayer(name, sprite, height, width, hp, x, y, 3, 3);
        e.setEntityType(EEntityType.Enemy);
        return e;
    }

    public Entity createEnemy(double x, double y, double height, double width) {
        String name = "Shoot" + getEnemyNumber();
        return createEnemy(name, "/Sprites/Enemy.png", height, width, 5, x, y);
    }

    public void createShoot(IEntity e, Location l, ECommand direction) {
        //Pour la direction du tir
        double heightShoot = 10;
        double widthShoot = 30;
        double xShoot = l.getX();
        double yShoot = l.getY() + l.getHeight() / 2 - heightShoot / 2;
        switch (direction) {
            case RIGHT -> xShoot += l.getWidth() + 5;
            case LEFT -> xShoot -= l.getWidth() - 5;
        }

        String name = "Shoot" + getShootNumber() + "_" + e.getId().toString();
        Entity e1 = new Entity(name, EEntityType.Shoot);
        e1.addComponement(new Sprite(true));
        e1.addComponement(new Location(xShoot, yShoot, heightShoot, widthShoot));
        e1.addComponement(new Life(1));
        e1.addComponement(new Speed(15, 15));
        e1.addComponement(new Shoot(e.getId(), direction));
        ShootCollection.cast(e).addShoot(e1);
    }
}
