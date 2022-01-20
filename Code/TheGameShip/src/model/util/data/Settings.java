package model.util.data;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Settings {

    private final DoubleProperty difficulty = new SimpleDoubleProperty();

    public double getDifficulty() {
        return difficulty.get();
    }

    public void setDifficulty(double difficulty) {
        this.difficulty.set(difficulty);
    }

    public DoubleProperty difficultyProperty() {
        return difficulty;
    }

    private final DoubleProperty volume = new SimpleDoubleProperty();

    public double getVolume() {
        return volume.get();
    }

    public void setVolume(double volume) {
        this.volume.set(volume);
    }

    public DoubleProperty volumeProperty() {
        return volume;
    }


    private final StringProperty up = new SimpleStringProperty();

    public String getUp() {
        return up.get();
    }

    public void setUp(String up) {
        this.up.set(up);
    }

    public StringProperty upProperty() {
        return up;
    }

    private final StringProperty left = new SimpleStringProperty();

    public String getLeft() {
        return left.get();
    }

    public void setLeft(String left) {
        this.left.set(left);
    }

    public StringProperty leftProperty() {
        return left;
    }

    private final StringProperty down = new SimpleStringProperty();

    public String getDown() {
        return down.get();
    }

    public void setDown(String down) {
        this.down.set(down);
    }

    public StringProperty downProperty() {
        return down;
    }

    private final StringProperty right = new SimpleStringProperty();

    public String getRight() {
        return right.get();
    }

    public void setRight(String right) {
        this.right.set(right);
    }

    public StringProperty rightProperty() {
        return right;
    }

    private final StringProperty shoot = new SimpleStringProperty();

    public String getShoot() {
        return shoot.get();
    }

    public void setShoot(String shoot) {
        this.shoot.set(shoot);
    }

    public StringProperty shootProperty() {
        return shoot;
    }
}
