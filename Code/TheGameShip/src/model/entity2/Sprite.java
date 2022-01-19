package model.entity2;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Sprite extends  Componement{
    private String sprite;
        public String getSprite() { return sprite; }
        public void setSprite(String sprite) { this.sprite = sprite; }

    protected BooleanProperty visible = new SimpleBooleanProperty();
        public boolean getVisible() { return visible.get(); }
        public void setVisible(boolean b) { visible.set(b); }
        public BooleanProperty getVisibleBooleanProperty() { return visible; }

    public Sprite(String sprite){
        super(EType.Sprite);
        setSprite(sprite);
    }
    public Sprite(){
        super(EType.Sprite);
        setSprite(null);
    }
}
