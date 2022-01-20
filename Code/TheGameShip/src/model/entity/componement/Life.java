package model.entity.componement;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Life extends Componement {

    private final DoubleProperty hp = new SimpleDoubleProperty();
        public double getHp() { return hp.get(); }
        public void setHp(double hp) {
            this.hp.set(hp);
            if (getHp()<=0) {
                setDead(true);
            }
        }
        public void decreaseHp() { setHp(getHp()-1); }
        public DoubleProperty hpProperty() { return hp; }


    private final BooleanProperty isDead = new SimpleBooleanProperty();
        public boolean isDead(){return isDead.getValue();}
        public void setDead(boolean dead) { isDead.set(dead); }
        public BooleanProperty isDeadProperty() { return isDead; }


    protected Life(double hp){
        super(EComponementType.Life);
        setHp(hp);
        setDead(false);
    }

    public static Life cast(IHasComponements e) {
        return (Life) e.getComponement(EComponementType.Life);
    }
}
