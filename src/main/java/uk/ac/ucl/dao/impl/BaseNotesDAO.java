package uk.ac.ucl.dao.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseNotesDAO {

    protected final String DATA_DIR_PATH = ".." + File.separator + "Notes-Management-Web-Application"
            + File.separator + "data";
    protected List<File> notesList;

     {
        notesList = new ArrayList<>();
        File dataDir = new File(DATA_DIR_PATH);
        if (dataDir.isDirectory()) {
            File[] allFiles = dataDir.listFiles();
            for (File note : allFiles) {
                if (!note.isDirectory()) {
                    notesList.add(note);
                }
            }
        }
    }


}
