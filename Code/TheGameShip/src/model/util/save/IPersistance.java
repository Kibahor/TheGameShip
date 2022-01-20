package model.util.save;

import java.io.File;

public interface IPersistance {
    void save(Object obj, File file) throws Exception;

    Object load(File file) throws Exception;

}
