//https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
package model.entity;

public class EntityDecorator implements Entity {
    protected Entity decoratedEntity;

    public EntityDecorator(Entity entity) {
        this.decoratedEntity=entity;
    }
    public void draw(){
        decoratedEntity.draw();
    }
}
