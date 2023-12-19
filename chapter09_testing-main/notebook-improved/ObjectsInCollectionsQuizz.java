import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static codequizz.Expect.*;
import java.util.List;

/**
 * This class is an exercise in understanding object references.
 * First, start the code Quizz by setting ON = true;
 * Go through the test cases, and find the places where you need 
 * to fill in your solution, for example:
 * expect(____,note1.getText());
 * 
 * replace the ____ with your expectation of the result.
 */
public class ObjectsInCollectionsQuizz
{
    BetterNotebook notebook;
    /**
     * Constructor for objects of class ObjectsInCollectionsQuizz
     */
    public ObjectsInCollectionsQuizz()
    {
        ON = true;
    }

    @BeforeEach
    public void setUp()
    {
        notebook = new BetterNotebook();
        notebook.storeNote("Title","a");
        notebook.storeNote("Title","b");
        notebook.storeNote("Title","c");
        notebook.storeNote("Title","d");
    }

    @Test
    public void testChange01(){
        List<Note> bNotes = notebook.getNotesWith("b");
        assertEquals(1,bNotes.size());
        Note bNote = bNotes.get(0);
        bNote.setText("not B anymore");
        bNotes = notebook.getNotesWith("b");
        expect(0,bNotes.size());

    }

    @Test
    public void testChange02(){
        Note note1 = new Note("a title", "the text");
        expect("the text",note1.getText());
        notebook.storeNote(note1);
        Note note2 = notebook.getFirstNoteWith("text");
        expect(____, note1 == note2);
        note2.setText("another thing");
        expect(____,note1.getText());

        }
    @Test
    public void testIdentity(){
        Note note1 = new Note("a title", "the text");
        Note note2 = new Note("a title", "the text");
        expect(____, note1 == note2);
        expect(____, note1.equals(note2));
        
        note2.setTitle("new title");
        expect(____, note1.equals(note2));
    }

    @Test
    public void testChange03(){
        Note note1 = new Note("a title", "the text");
        Note note2 = new Note("a title", "the text");
        notebook.storeNote(note1);
        notebook.storeNote(note2);

        Note note3 = notebook.getFirstNoteWith("text");

        expect(____, note1 == note3);
        expect(____, note2 == note3);

        note3.setText("another thing");
        expect(____,note1.getText());
        expect(____,note2.getText());
        expect(____,note3.getText());

    }
    
    @Test
    public void twoNotebooks(){
        BetterNotebook notebook2 = new BetterNotebook();
        for (Note note : notebook){
            notebook2.storeNote(note);
        }
        Note note1 = notebook.getFirstNoteWith("c");
        Note note2 = notebook2.getFirstNoteWith("c");
        expect(____, note1.equals(note2));
        note2.setText("new text");
        expect(____, note1.equals(note2));

    }
    
    @Test
    public void twoNotebooksCopy(){
        BetterNotebook notebook2 = new BetterNotebook();
        for (Note note : notebook){
            notebook2.storeNote(note.getTitle(), note.getText());
        }
        Note note1 = notebook.getFirstNoteWith("c");
        Note note2 = notebook2.getFirstNoteWith("c");
        expect(____, note1.equals(note2));
        note2.setText("new text");
        expect(____, note1.equals(note2));

    }
}