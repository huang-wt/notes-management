package uk.ac.ucl.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Searcher extends NoteManager
{
  public List<String> searchFor(String keyword)
  {
    List<String> matchedNotes = new ArrayList<>();
    for (File note : notesList)
    {
      String noteName = note.getName();

      // search for notes whose titles containing the keyword
      if (noteName.contains(keyword))
      {
        matchedNotes.add(noteName);
      }
    }

    return matchedNotes;
  }
}
