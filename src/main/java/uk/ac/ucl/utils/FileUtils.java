package uk.ac.ucl.utils;

import java.io.File;

public class FileUtils {

    private final static String DATA_DIR_PATH = ".." + File.separator + "Notes-Management-Web-Application"
            + File.separator + "data";

    public static String getPath(String fileName) {
        return DATA_DIR_PATH + File.separator + fileName;
    }

}
