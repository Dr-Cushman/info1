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
public class NotebookRemoveTest
{
    /**
     * Default constructor needs to be present for JUnit!
     */
    public NotebookRemoveTest()
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
        
    }


    @Test
    public void testNotInList()
    {
        Notebook notebook1 = new Notebook();
        notebook1.storeNote("a");
        notebook1.storeNote("b");
        notebook1.storeNote("c");
        notebook1.removeWithIndex("d");
        java.lang.String string1 = notebook1.getAll(",");
        assertEquals("a,b,c", string1);
    }
    
    @Test
    public void testTwoB()
    {
        Notebook notebook1 = new Notebook();
        notebook1.storeNote("a");
        notebook1.storeNote("b");
        notebook1.storeNote("b");
        notebook1.storeNote("c");
        notebook1.removeWithIndex("b");
        java.lang.String string1 = notebook1.getAll(", ");
        assertEquals("a, c", string1);
    }
    
        @Test
    public void testTwoBDifferentPlaces()
    {
        Notebook notebook1 = new Notebook();
        notebook1.storeNote("a");
        notebook1.storeNote("b");
        notebook1.storeNote("c");
        notebook1.storeNote("b");
        
        notebook1.removeWithIndex("b");
        java.lang.String string1 = notebook1.getAll(", ");
        assertEquals("a, c", string1);
    }
    
    @Test
    public void testEmpty()
    {
        Notebook notebook1 = new Notebook();
        notebook1.removeWithIndex("b");
        java.lang.String string1 = notebook1.getAll();
        assertEquals("", string1);
    }
    
}


