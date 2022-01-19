package model.save;

import model.util.settings.Settings;

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

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SettingsFile))) {
            SerializeSettings serializeSettings = (SerializeSettings) ois.readObject();

            //TODO: set les valeurs dans Settings
            //settings.setDifficulty(SerializeSettings.getDifficulty());
            //settings.setVolume(SerializeSettings.getVolume());

        }
        catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
