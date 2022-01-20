package model.entity.componement;

import model.entity.EEntityType;
import model.entity.Entity;
import model.entity.IEntity;
import model.util.input.ECommand;

import java.util.UUID;

public class EntityFabric {
    private long number = 0;
        private long getShootNumber(){
            number++;
            return number;
        }

    public Entity createPlayer(String name, String sprite, double height, double width, double hp, double x, double y, float speedX, float speedY){
        Entity e=new Entity(name, EEntityType.Player);
        e.addComponement(new Sprite(sprite));
        e.addComponement(new Location(x, y, height, width));
        e.addComponement(new Life(hp));
        e.addComponement(new Speed(speedX, speedY));
        e.addComponement(new Score());
        return e;
    }

    public Entity createEnnemy(String name, String sprite, double height, double width, double hp, double x, double y){
        Entity e = createPlayer(name,sprite,height,width,hp,x,y,5,7);
        e.setEntityType(EEntityType.Ennemy);
        return e;
    }

    public IEntity createShoot(UUID ownerId, Location l, ECommand direction){
        //Pour la direction du tir
        double heightShoot = 10;
        double widthShoot = 30;
        double xShoot = l.getX();
        double yShoot = l.getY() + l.getHeight()/2 - heightShoot/2;
        switch (direction){
            case RIGHT -> xShoot += l.getWidth() + 5;
            case LEFT -> xShoot -= l.getWidth() - 5;
        }

        String name = "Shoot" + getShootNumber() + "_" + ownerId.toString();
        Entity e=new Entity(name, EEntityType.Shoot);
        e.addComponement(new Sprite(null));
        e.addComponement(new Location(xShoot,yShoot,heightShoot,widthShoot));
        e.addComponement(new Life(1));
        e.addComponement(new Speed(15,15));
        e.addComponement(new Shoot(ownerId));

        return e;
    }


}
