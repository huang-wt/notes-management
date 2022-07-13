package uk.ac.ucl.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class NoteManager
{
  protected final String DATA_DIR_PATH = ".." + File.separator + "COMP0004CW" + File.separator + "data";
  protected static List<File> notesList;

  public NoteManager()
  {
    notesList = new ArrayList<>();
    listAllFiles(new File(DATA_DIR_PATH));
  }

  // store all note files from data directory
  public void listAllFiles(File file)
  {
    if (file.isDirectory())
    {
      File[] allFiles = file.listFiles();
      for (File note : allFiles)
      {
        if (!note.isDirectory())
        {
          notesList.add(note);
        }
      }
    }
  }

  public String getDATA_DIR_PATH()
  {
    return DATA_DIR_PATH;
  }
}
