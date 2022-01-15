package model.entity;

import javafx.beans.property.BooleanProperty;

import java.net.URI;
import java.util.UUID;

public interface IEntity extends IReset {

    UUID getId();

    String getName();

    EType getType();

    //TODO : mettre sa dans une interface IHasLocation et caster avec cette interface a tout les endroit où c'est utiliser avec l'interface IEntity

    //

    URI getSprite();
    void setSprite(URI sprite);

    boolean getVisible();
    void setVisible(boolean b);
    BooleanProperty getVisibleBooleanProperty();

}
