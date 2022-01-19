package model.entity.Componement;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Location extends Componement {
    private final DoubleProperty x = new SimpleDoubleProperty();
        public double getX() { return x.get(); }
        public void setX(double x) { this.x.set(x); }
        public DoubleProperty xProperty() { return x; }

    private final DoubleProperty y = new SimpleDoubleProperty();
        public double getY() { return y.get(); }
        public void setY(double y) { this.y.set(y); }
        public DoubleProperty yProperty() { return y; }

    private final DoubleProperty width = new SimpleDoubleProperty();
        public double getWidth() { return width.get(); }
        public void setWidth(double width) { this.width.set(width); }
        public DoubleProperty widthProperty() { return width; }

    private final DoubleProperty height = new SimpleDoubleProperty();
        public double getHeight() { return height.get(); }
        public void setHeight(double height) { this.height.set(height); }
        public DoubleProperty heightProperty() { return height; }

    public Location(double x, double y, double height, double width) {
        super(EComponementType.Location);
        setX(x);
        setY(y);
        setHeight(height);
        setWidth(width);
    }

    public static Location cast(IHasComponements e){
            return (Location) e.getComponement(EComponementType.Location);
    }
}
