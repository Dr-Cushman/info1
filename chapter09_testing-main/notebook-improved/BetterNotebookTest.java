
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BetterNotebookTest
{

    BetterNotebook notebook;
    /**
     * Default constructor for test class BetterNotebookTest
     */
    public BetterNotebookTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        notebook = new BetterNotebook();
        notebook.storeNote("a");
        notebook.storeNote("b");
        notebook.storeNote("c");
        notebook.storeNote("d");
    }

    @Test
    public void testGetAllEmpty(){
        notebook = new BetterNotebook();
        assertEquals("",notebook.getAll());
    }

    @Test
    public void testGetAllOneElement(){
        notebook = new BetterNotebook();
        notebook.storeNote("b");
        String expected = """
# New Note
b

""";
        assertEquals(expected,notebook.getAll());
    }

    @Test
    public void testGetAllTwoElements(){
        notebook = new BetterNotebook();
        notebook.storeNote("b");
        notebook.storeNote("c");

        String expected = """
# New Note
b

# New Note
c

""";
        assertEquals(expected,notebook.getAll());
    }

    @Test
    public void testGetAllDelim(){
        String expected = """
# New Note
a

# New Note
b

# New Note
c

# New Note
d

""";
        assertEquals(expected,notebook.getAll());
    }


  
}
