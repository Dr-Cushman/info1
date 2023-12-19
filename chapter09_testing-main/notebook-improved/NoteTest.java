
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoteTest
{
    public NoteTest()
    {
    }

    @BeforeEach
    public void setUp()
    {
    }

    @Test
    public void testToString(){
        Note note = new Note("the title", "the text");
        assertEquals("# the title\nthe text\n",note.toString());
    }

    @Test
    public void testToStringNull(){
        Note note = new Note(null, "the text");
        assertEquals("# New Note\nthe text\n",note.toString());
    }

    @Test
    public void testEquals(){
        Note note1 = new Note("the title", "the text");
        Note note2 = new Note("the title", "the text");
        assertTrue(note1.equals(note2));
    }

    @Test
    public void testEqualsDifferent(){
        Note note1 = new Note("the title", "the text");
        Note note2 = new Note("other title", "the text");
        assertFalse(note1.equals(note2));
    }

    @Test
    public void testHashCodeEqual(){
        Note note1 = new Note("the title", "the text");
        Note note2 = new Note("the title", "the text");
        assertTrue(note1.hashCode() == note2.hashCode());
    }

    @Test
    public void testHashCodeDifferent(){
        Note note1 = new Note("the title", "the text");
        Note note2 = new Note("the title", "other text");
        assertFalse(note1.hashCode() == note2.hashCode());
    }

    @Test
    public void testIdentity1(){
        Note note1 = new Note("the title", "the text");
        Note note2 = new Note("the title", "the text");
        assertFalse(note1 == note2);
    }

    @Test
    public void testIdentity2(){
        Note note1 = new Note("the title", "the text");
        Note note2 = note1;
        assertTrue(note1 == note2);
    }

}
