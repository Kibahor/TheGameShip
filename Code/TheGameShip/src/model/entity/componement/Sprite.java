package model.entity.componement;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Sprite extends  Componement{

    private String sprite;
        public String getSprite() { return sprite; }
        public void setSprite(String sprite) { this.sprite = sprite; }

    private final BooleanProperty visible = new SimpleBooleanProperty();
        public boolean getVisible() { return visible.get(); }
        public void setVisible(boolean b) { visible.set(b); }
        public BooleanProperty getVisibleBooleanProperty() { return visible; }

    public Sprite(String sprite){
        super(EComponementType.Sprite);
        setSprite(sprite);
    }

    public Sprite(){
        super(EComponementType.Sprite);
        setSprite(null);
    }

    public static Sprite cast(IHasComponements e){
            return (Sprite) e.getComponement(EComponementType.Sprite);
    }
}
