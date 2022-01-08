//https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
package model.entity;

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
        return super.hashCode();
    }
    @Override
    public boolean equals(IEntity obj){
        return super.equals(obj);
    }
    @Override
    public String getName() {
        return entity.getName();
    }
}
