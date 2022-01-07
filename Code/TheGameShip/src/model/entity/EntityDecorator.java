//https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
package model.entity;

public class EntityDecorator implements IEntity {
    protected IEntity decoratedIEntity;

    public EntityDecorator(IEntity IEntity) {
        this.decoratedIEntity = IEntity;
    }
    public void draw(){
        decoratedIEntity.draw();
    }

    @Override
    public String toString() {
        return decoratedIEntity.toString();
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(IEntity obj){
        return super.equals(obj);
    }

    @Override
    public String getName() {
        return "defaultEntityDecorator name";
    }
}
