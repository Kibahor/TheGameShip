package model.util.settings;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Settings {

    /*
    private double difficulty = 2;
    private double volume = 50;
    public double getDifficulty() { return difficulty; }
    public void setDifficulty(double difficulty) { this.difficulty = difficulty; }
    public double getVolume() { return volume; }
    public void setVolume(double volume) { this.volume = volume; }
    */

    private final DoubleProperty difficulty = new SimpleDoubleProperty();
        public double getDifficulty() { return difficulty.get(); }
        public void setDifficulty(double difficulty) { this.difficulty.set(difficulty); }
        public DoubleProperty difficultyProperty() { return difficulty; }


    private final DoubleProperty volume = new SimpleDoubleProperty();
        public double getVolume() { return volume.get(); }
        public void setVolume(double volume) { this.volume.set(volume); }
        public DoubleProperty volumeProperty() { return volume; }
}
