package model.entity;

import javafx.beans.property.BooleanProperty;
import java.net.URI;
import java.util.UUID;

public interface IEntity extends IReset {

    UUID getId();
    String getName();
    EType getType();

    //TODO :  le mettre autre part
    URI getSprite();
    void setSprite(URI sprite);

    boolean getVisible();
    void setVisible(boolean b);
    BooleanProperty getVisibleBooleanProperty();

}
