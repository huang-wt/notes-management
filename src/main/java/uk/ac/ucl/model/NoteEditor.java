package uk.ac.ucl.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// responsible for writing, deleting, and renaming
public class NoteEditor extends NoteManager
{
  public void writeTextFile(File file, String content)
  {
    BufferedWriter bw = null;

    try
    {
      bw = new BufferedWriter(new FileWriter(file, false));
      bw.write(content);

      if (!notesList.contains(file))
      {
        notesList.add(file);
      }
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (bw != null)
      {
        try
        {
          bw.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
  }

  public void deleteFile(File file)
  {
    file.delete();
    notesList.remove(file);
  }

  public void renameFile(File oldFile, File newFile)
  {
    oldFile.renameTo(newFile);
    notesList.remove(oldFile);
    notesList.add(newFile);
  }
}
