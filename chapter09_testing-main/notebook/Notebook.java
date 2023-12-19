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

    public String getAll(){
        final String delim  =  "\n";
        String result = getAll(delim);
        if (result.length() > 0) result += delim;
        return result;
    }

    public String getAll(String delim){
        String result = "";
        String note = "";
        Iterator<String> i = notes.iterator();
        while (i.hasNext()){
            note = i.next();
            result += note;
            if (i.hasNext()) result = result + delim;
        }
        return result;
    }

    public void printAll(){
        for (String note : notes){
            System.out.println(note);
        }

    }

    public void removeWithIndex(String searchString){
        int size = notes.size();
        for(int i=0;i<notes.size();i++){
        //for(int i=0;i<size;i++){

            if (notes.get(i).contains(searchString)){
                notes.remove(i);
                i--;
            }
        }

    }

    public String getNotesWith(String searchString){
        String result = "";
        result = result +"??" +"\n";
        return result;

    }

    public static void test() 
    {
        int sum = 1;

        for (int i = 0; i <= 4; i++); 
        {
            sum = sum + 1;
        }

        System.out.println("The result is: " + sum);
        System.out.println("Double result: " + sum+sum);

        System.out.println( sum+sum+ "is the Double result");
    }

}
