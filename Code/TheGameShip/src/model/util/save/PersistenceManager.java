package model.util.save;

import model.util.settings.Settings;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public final class PersistenceManager {

    private static final File settingsFile = new File("./res/Settings/settings.xml");

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
}
