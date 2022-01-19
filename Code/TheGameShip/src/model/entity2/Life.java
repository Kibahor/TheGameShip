package model.entity2;

import javafx.beans.property.DoubleProperty;
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

    private boolean isDead;
        public boolean isDead(){return isDead;}
        public void setDead(boolean dead) { isDead=dead; }

    protected Life(double hp){
        super(EComponementType.Life);
        setHp(hp);
        setDead(false);
    }

    public static Life cast(IHasComponements e) {
        return (Life) e.getComponement(EComponementType.Life);
    }

    /*
    public Life cast(IEntity e) {
        if (!(e instanceof IHasLife)) {
            System.err.println("L'Entité \""+e.getName()+"\" n'implémente pas IHasLife donc elle ne peut pas perdre de la vie !");
            return null;
        }
        return (IHasLife) e;
    }*/
}
