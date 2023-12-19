
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The test class NotebookTest.
 *
 * @author  B. Kleinen */
public class NotebookTest
{
    Notebook notebook;
    /**
     * Default constructor for test class NotebookTest
     */
    public NotebookTest()
    {
    }

    /**
     * Create a Notebook with four notes as text fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        notebook = new Notebook();
        notebook.storeNote("a");
        notebook.storeNote("b");
        notebook.storeNote("c");
        notebook.storeNote("d");
    }

    @Test
    public void testGetAllEmpty(){
        notebook = new Notebook();
        assertEquals("",notebook.getAll());
    }

    @Test
    public void testGetAllOneElement(){
        notebook = new Notebook();
        notebook.storeNote("b");
        assertEquals("b\n",notebook.getAll());
    }

    @Test
    public void testGetAllTwoElements(){
        notebook = new Notebook();
        notebook.storeNote("b");
        notebook.storeNote("c");
        assertEquals("b, c",notebook.getAll(", "));
    }

    @Test
    public void testGetAllDelim(){
        assertEquals("a, b, c, d",notebook.getAll(", "));
    }

    @Test
    public void testGetAllDefault(){
        assertEquals("a\nb\nc\nd\n",notebook.getAll());
    }

}
