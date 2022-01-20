package model.util.save;

import model.util.data.Settings;

import java.io.File;

public interface IPersistance {
    void save(Object obj, File file) throws Exception;
    Object load(File file) throws Exception;

}
