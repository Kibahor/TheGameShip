package model.save;

import model.util.settings.Settings;

public class SerializeSettings implements ISerialize {

    private double difficulty;
    private double volume;

    public SerializeSettings(Settings settings) {

        difficulty = settings.getDifficulty();
        volume = settings.getVolume();
    }


    @Override
    public ISerialize serialize() {
        return this;
    }
}
