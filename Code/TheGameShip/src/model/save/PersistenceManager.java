package model.save;

import model.util.settings.Settings;
import java.io.*;

public class PersistenceManager {

    private static final File SettingsFile = new File("./res/Settings/settings.json");

        public static void saveSettings(Settings settings) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SettingsFile))) {
                ISerialize serializableSettings = new SerializeSettings(settings);

                //TODO: Utiliser une bibliotèque pour faire du JSON
                //oos.writeObject(serializableSettings);
            } catch (IOException e) {
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
