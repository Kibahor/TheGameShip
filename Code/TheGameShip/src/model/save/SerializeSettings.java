package model.save;

import model.util.settings.Settings;

public class SerializeSettings {

    private double difficulty;
    private double volume;

    public SerializeSettings() {
        difficulty = 2;
        volume = 50;
    }

    public SerializeSettings(Settings settings) {
        difficulty = settings.getDifficulty();
        volume = settings.getVolume();
    }

    public double getDifficulty() { return difficulty; }
    public double getVolume() { return volume; }

    public void setDifficulty(double difficulty) { this.difficulty = difficulty; }
    public void setVolume(double volume) { this.volume = volume; }

    @Override
    public String toString() {
        return "SerializeSettings{" +
                "difficulty=" + difficulty +
                ", volume=" + volume +
                '}';
    }
}
