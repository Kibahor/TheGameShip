package model.util.save;

import model.util.data.HighScore;
import model.util.data.Settings;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public final class PersistenceManager {

    private static final File settingsFile = new File("./res/Settings/settings.xml");
    private static final File highScoreFile = new File("./res/Settings/highscore.xml");

    public static void saveSettings(Settings settings) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(settingsFile)));
            SerializeSettings data = new SerializeSettings(settings);
            encoder.writeObject(data);
            encoder.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSettings(Settings settings) {
        if (settingsFile.length() == 0) { return; }
        SerializeSettings data = null;

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(settingsFile)));
            data = (SerializeSettings) decoder.readObject();

            settings.setDifficulty(data.getDifficulty());
            settings.setVolume(data.getVolume());

            settings.setUp(data.getUp());
            settings.setLeft(data.getLeft());
            settings.setDown(data.getDown());
            settings.setRight(data.getRight());
            settings.setShoot(data.getShoot());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveHighScore(HighScore highScore) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(highScoreFile)));
            SerializeHighScore data = new SerializeHighScore(highScore);
            encoder.writeObject(data);
            encoder.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadHighScore(HighScore highScore) {
        if (highScoreFile.length() == 0) { return; }
        SerializeHighScore data = null;

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(highScoreFile)));
            data = (SerializeHighScore) decoder.readObject();

            highScore.loadListe(data.getListHighScore());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
