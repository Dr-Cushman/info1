import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class BetterNotebook implements Iterable<Note>
{
    // Storage for an arbitrary number of notes.
    private ArrayList<Note> notes;

    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public BetterNotebook()
    {
        notes = new ArrayList<Note>();
    }

    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(Note note)
    {
        if (null == note)
            return;
        notes.add(note);
    }

    public void storeNote(String note)
    {
        if ((null == note) || "".equals(note)) return;
        notes.add(new Note(null,note));
    }

    public void storeNote(String title, String note)
    {
        if ((null == note) || "".equals(note)) return;
        notes.add(new Note(title, note));
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

    public String getAll(){
        String result = "";
        for (Note note : notes){
            result += note+"\n";
        }
        return result;
    }

    public void printAll(){
        for (Note note : notes){
            System.out.println(note);
        }

    }

    public void removeWithIndex(String searchString){
        int size = notes.size();
        for(int i=0;i<size;i++){

            if (notes.get(i).text.contains(searchString)){
                notes.remove(i);
                i--;
            }
        }

    }

    public Note getFirstNoteWith(String searchString){
        List<Note> results = getNotesWith(searchString);
        if (results.size() == 0) return null;
        return results.get(0);
    }

    public List<Note> getNotesWith(String searchString){
        List<Note> result = new ArrayList<Note>();
        for(Note note : notes){
            if (note.getTitle().contains(searchString) || 
            note.getText().contains(searchString))
                result.add(note);
        }
        return result;

    }

    public Iterator<Note> iterator(){
        return notes.iterator();
    }

}
