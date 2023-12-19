
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BetterNotebookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BetterNotebookRemoveTest
{

    BetterNotebook notebook;
    /**
     * Default constructor for test class BetterNotebookTest
     */
    public BetterNotebookRemoveTest()
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

    
  
}
