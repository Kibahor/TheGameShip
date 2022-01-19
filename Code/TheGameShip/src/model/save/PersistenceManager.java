package model.save;

import model.util.settings.Settings;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class PersistenceManager {

    private static final File SettingsFile = new File("./res/Settings/settings.xml");

    public static void saveSettings(Settings settings) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SettingsFile)));
            encoder.writeObject(new SerializeSettings(settings));
            encoder.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSettings(Settings settings) {
        if (SettingsFile.length() == 0) { return; }

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SettingsFile)));
            SerializeSettings data = (SerializeSettings) decoder.readObject();

            settings.setDifficulty(data.getDifficulty());
            settings.setVolume(data.getVolume());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
