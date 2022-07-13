package uk.ac.ucl.model;

import java.io.File;

public class Model
{
  public NoteReader noteReader;
  public NoteEditor noteEditor;
  public Searcher searcher;

  public Model()
  {
    noteReader = new NoteReader();
    noteEditor = new NoteEditor();
    searcher = new Searcher();
  }

  public String getPath(String fileName)
  {
    return noteReader.getDATA_DIR_PATH() + File.separator + fileName;
  }
}
