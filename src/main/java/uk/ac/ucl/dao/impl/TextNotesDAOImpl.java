package uk.ac.ucl.dao.impl;

import uk.ac.ucl.dao.TextNotesDAO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextNotesDAOImpl extends BaseNotesDAO implements TextNotesDAO {

    @Override
    public void writeTextFile(File file, String content) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(file, false));
            bw.write(content);

            if (!notesList.contains(file)) {
                notesList.add(file);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteFile(File file) {
        file.delete();
        notesList.remove(file);
    }

    @Override
    public void renameFile(File oldFile, File newFile) {
        oldFile.renameTo(newFile);
        notesList.remove(oldFile);
        notesList.add(newFile);
    }

    @Override
    public List<String> getIndexNamesInOrderAdded() {
        List<String> noteNamesInSortedOrdered = new ArrayList<>();
        List<File> notesListCopy = new ArrayList<>(notesList);
        Comparator<File> com = (o1, o2) -> {
            BasicFileAttributes bfa1 = null;
            BasicFileAttributes bfa2 = null;
            try {
                bfa1 = Files.readAttributes(o1.toPath(), BasicFileAttributes.class);
                bfa2 = Files.readAttributes(o2.toPath(), BasicFileAttributes.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bfa1.creationTime().compareTo(bfa2.creationTime());
        };

        notesListCopy.sort(com);
        for (File file : notesListCopy) {
            noteNamesInSortedOrdered.add(file.getName());
        }

        return noteNamesInSortedOrdered;
    }

    @Override
    public List<String> getIndexNamesInSortedOrder() {
        List<String> noteNamesInSortedOrder = new ArrayList<>();
        List<File> notesListCopy = new ArrayList<>(notesList);
        Comparator<File> com = Comparator.comparing(File::getName);

        notesListCopy.sort(com);
        for (File file : notesListCopy) {
            noteNamesInSortedOrder.add(file.getName());
        }

        return noteNamesInSortedOrder;
    }

    @Override
    public List<String> readTextFile(File file) {
        BufferedReader br = null;
        List<String> textContents = null;

        try {
            br = new BufferedReader(new FileReader(file));
            textContents = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                textContents.add(line);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return textContents;
        }
    }

    @Override
    public List<String> searchFor(String keyword) {
        List<String> matchedNotes = new ArrayList<>();
        for (File note : notesList) {
            String noteName = note.getName();

            // search for notes whose titles containing the keyword
            if (noteName.contains(keyword)) {
                matchedNotes.add(noteName);
            }
        }

        return matchedNotes;
    }
}
