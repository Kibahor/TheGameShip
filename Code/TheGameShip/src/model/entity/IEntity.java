package model.entity;

public interface IEntity {
    void printDecorationName();
    int hashCode();
    boolean equals(IEntity obj);
    String getName();
}
