//https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
package model.entity;

import java.net.URI;

public class EntityDecorator implements IEntity {
    protected IEntity entity;

    public EntityDecorator(IEntity e) {
        this.entity = e;
    }

    public void printDecorationName(){
        entity.printDecorationName();
    }

    @Override
    public String toString() {
        return entity.toString();
    }

    @Override
    public int hashCode(){
        return entity.hashCode();
    }
    @Override
    public boolean equals(IEntity obj){
        return entity.equals(obj);
    }
    @Override
    public String getName() {
        return entity.getName();
    }

    @Override
    public URI getSprite() {
        return entity.getSprite();
    }

    @Override
    public void setSprite(URI sprite) {

    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public void setX(double x) {

    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public void setY(double y) {

    }

    @Override
    public double getHitbox_radius() {
        return 0;
    }
}
