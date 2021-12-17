package model.entity;
import java.util.UUID;
import java.net.*;

public interface Entity {
    void draw();

    public int hashCode();
    public boolean equals(Entity obj);
}
