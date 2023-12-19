import java.util.ArrayList;
import java.util.Iterator;
/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Notebook
{
    // Storage for an arbitrary number of notes.
    private ArrayList<String> notes;

    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public Notebook()
    {
        notes = new ArrayList<String>();
    }

    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(String note)
    {
        if ((null == note) || "".equals(note)) return;
        notes.add(note);
    }

    /**
     * @return The number of notes currently in the notebook.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Print a note.
     * @param noteNumber The number of the note to be shown.
     */
    public void printNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // This is not a valid note number, so do nothing.
        }
        else if(noteNumber < numberOfNotes()) {
            // This is a valid note number, so we can print it.
            System.out.println(notes.get(noteNumber));
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }

    public String getAll() {
        String x = "";
        String y = "";
        if(numberOfNotes() == 0) {
            return "No notes Stored";
        }
        
        for(int i = 0; i < notes.size(); i++){
            x = x + (notes.get(i) + "\n");
            y = y + notes.get(i);
        }
        
        System.out.println(x);
        return x;
    }
    
    public String getNotesWith(String searchString) {
        for(String i : notes) {
            if(notes.contains(searchString)) {
                System.out.println(notes);
            }
        }
        return null;
    }
    
    public String removeNotes(String searchString) {
        // Find Index in collection containing the searchString
        Iterator<String> iterator = notes.iterator();
        while (iterator.hasNext()) {
            String note = iterator.next();
            if (note.equals(searchString)) {
                iterator.remove();
            } else {
                System.out.println("No such string found to remove");
            }
        }
        
        
        return null;
    }
    
    public String removeNotesWithIndex(String searchString) {
        for(int i=0; i<notes.size(); i++) {
            if(notes.get(i) == searchString) {
                // Remove index from collection
                notes.remove(i);
            } else {
                System.out.println("No such String found to remove in Notes");
            }
        }
        return null;
    }
    
    public String getAllNumbered() {
        int indexCounter = 0;
        for(String i : notes) {
            System.out.println(indexCounter + ":" + i);
            indexCounter++;
        }
        return null;
    }
}
