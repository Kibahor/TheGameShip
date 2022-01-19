package model.entity2;

import model.util.input.ECommand;

import java.util.UUID;

public class EntityFabric {

    public Entity createPlayer(String name, String sprite, double height, double width, double hp, double x, double y, float speedX, float speedY){
        Entity e=new Entity(name);
        e.addComponement(new Sprite(sprite));
        e.addComponement(new Location(x, y, height, width));
        e.addComponement(new Life(hp));
        e.addComponement(new Speed(speedX, speedY));
        return e;
    }

    public IEntity createShoot(UUID ownerId, ECommand direction){
        //        if (e.getType() == EType.Player) { setX(((IHasLocation)e).getX() + ((IHasLocation)e).getWidth() + 5); }
        //        else { setX(((IHasLocation)e).getX() + ((IHasLocation)e).getWidth() - 5); }
        //        setY(((IHasLocation)e).getY() + (((IHasLocation) e).getHeight() / 2) - 5);

        //String sprite, double height, double width, double hp, double x, double y, float speedX, float speedY,

    }
}
