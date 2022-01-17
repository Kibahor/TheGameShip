package model.save;

import model.util.settings.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersistanceManager {

    private static final File fichierDeSauvegarde = new File(System.getProperty("user.dir") + "/res/DataSaved/data.json" );

    public static void saveSettings(Settings settings) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierDeSauvegarde))) {
            ISerialize serializableSettings = new SerializeSettings(settings);


            //writeObject(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
