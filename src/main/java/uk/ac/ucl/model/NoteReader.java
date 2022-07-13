package uk.ac.ucl.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// responsible for sorting and reading
public class NoteReader extends NoteManager
{
  public List<String> getIndexNamesInOrderAdded()
  {
    List<String> noteNamesInSortedOrdered = new ArrayList<>();
    List<File> notesListCopy = new ArrayList<>(notesList);
    Comparator<File> com = (o1, o2) ->
    {
      BasicFileAttributes bfa1 = null;
      BasicFileAttributes bfa2 = null;
      try {
        bfa1 = Files.readAttributes(o1.toPath(), BasicFileAttributes.class);
        bfa2 = Files.readAttributes(o2.toPath(), BasicFileAttributes.class);
      } catch (IOException e)
      {
        e.printStackTrace();
      }
      return bfa1.creationTime().compareTo(bfa2.creationTime());
    };

    notesListCopy.sort(com);
    for (File file : notesListCopy)
    {
      noteNamesInSortedOrdered.add(file.getName());
    }

    return noteNamesInSortedOrdered;
  }

  public List<String> getIndexNamesInSortedOrder()
  {
    List<String> noteNamesInSortedOrder = new ArrayList<>();
    List<File> notesListCopy = new ArrayList<>(notesList);
    Comparator<File> com = Comparator.comparing(File::getName);

    notesListCopy.sort(com);
    for (File file : notesListCopy)
    {
      noteNamesInSortedOrder.add(file.getName());
    }

    return noteNamesInSortedOrder;
  }

  public List<String> readTextFile(File file)
  {
    BufferedReader br = null;
    List<String> textContents = null;

    try
    {
      br = new BufferedReader(new FileReader(file));
      textContents = new ArrayList<>();

      String line;
      while ((line = br.readLine()) != null)
      {
        textContents.add(line);
      }

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (br != null)
      {
        try
        {
          br.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
      return textContents;
    }
  }
}
