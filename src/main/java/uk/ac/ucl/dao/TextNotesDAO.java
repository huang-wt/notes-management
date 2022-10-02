package uk.ac.ucl.dao;

import java.io.File;
import java.util.List;

public interface TextNotesDAO {

    void writeTextFile(File file, String content);

    void deleteFile(File file);

    void renameFile(File oldFile, File newFile);

    List<String> getIndexNamesInOrderAdded();

    List<String> getIndexNamesInSortedOrder();

    List<String> readTextFile(File file);

    List<String> searchFor(String keyword);

}
