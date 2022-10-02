package uk.ac.ucl.model;

import uk.ac.ucl.dao.TextNotesDAO;
import uk.ac.ucl.dao.impl.TextNotesDAOImpl;
import uk.ac.ucl.utils.FileUtils;

import java.io.File;
import java.util.List;

public class Model {

    public TextNotesDAO textNotesDAO = new TextNotesDAOImpl();

    public Model() {
    }

    public void writeTextFile(String fileName, String content) {
        File file = new File(FileUtils.getPath(fileName));
        textNotesDAO.writeTextFile(file, content);
    }

    public void deleteFile(String fileName) {
        File file = new File(FileUtils.getPath(fileName));
        textNotesDAO.deleteFile(file);
    }

    public void renameFile(String oldFileName, String newFileName) {
        File oldFile = new File(FileUtils.getPath(oldFileName));
        File newFile = new File(FileUtils.getPath(newFileName));
        textNotesDAO.renameFile(oldFile, newFile);
    }

    public List<String> getIndexNamesInOrderAdded() {
        return textNotesDAO.getIndexNamesInOrderAdded();
    }

    public List<String> getIndexNamesInSortedOrder() {
        return textNotesDAO.getIndexNamesInSortedOrder();
    }

    public List<String> readTextFile(String fileName) {
        File file = new File(FileUtils.getPath(fileName));
        return textNotesDAO.readTextFile(file);
    }

    public List<String> searchFor(String keyword) {
        return textNotesDAO.searchFor(keyword);
    }

}
