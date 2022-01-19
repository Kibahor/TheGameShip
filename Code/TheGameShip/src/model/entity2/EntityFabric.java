package model.entity2;

public class EntityFabric {

    public Entity createPlayer(String name, String sprite, double height, double width, double hp, double x, double y, float speedX, float speedY){
        Entity e=new Entity(name);
        e.addComponement(new Sprite(sprite));
        e.addComponement(new Location(x, y, height, width));
        e.addComponement(new Life(hp));
        e.addComponement(new Speed(speedX, speedY));
        return e;
    }
}
