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

    @Override
    public String toString() {
        return decoratedEntity.toString();
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(Entity obj){
        return super.equals(obj);
    }
}
