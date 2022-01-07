package model.entity;

public interface IEntity {
    void draw();

    int hashCode();
    boolean equals(IEntity obj);
    String getName();
}
