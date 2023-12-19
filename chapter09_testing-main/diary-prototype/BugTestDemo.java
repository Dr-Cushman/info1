
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static testhelper.Bug.assertEqualsBug;
import static testhelper.Bug.assertEqualsBugException;
import static testhelper.Bug.FAIL_BUGS;
import static testhelper.Bug.SILENCE_ALL_BUGS;

/**
 * This Class shows an example how to document a bug
 * with using assertEqualsBug from the testhelper 
 * package
 *
 * @author Barne Kleinen
 */
public class BugTestDemo
{
    static {
        // this can be used to force all bugs to be silent
        // as it is executed while loading the class, 
        // which should be done before any test execution
        // at least after a full re-compilation.
        FAIL_BUGS = true;
        System.out.print(java.time.LocalTime.now()+" loaded class BugTestDemo, static{} executed, ");
        System.out.println("FAIL_BUGS = "+FAIL_BUGS);
    }

    public BugTestDemo(){
        // change this setting only if working on this class.
        // otherwise, let the setting above in static{} take effect
        // FAIL_BUGS = false;
    }

    @Test
    public void demoOKTest(){
        String expected = "expected is the same as actual value";
        String actual = "expected is the same as actual value";
        assertEquals(actual, expected);
    }

    @Test
    public void demoBugTest(){
        String expected = "expected value";
        String actual = "actual value";

        assertEqualsBug(expected, actual);
    }

    @Test
    public void demoBugTestExceptionThrown(){
        String expected = "expected value";
        String actual = "actual value";

        assertEqualsBugException(expected, () -> throwsException());
    }

    private String throwsException() {
        throw new RuntimeException("yeah! I can throw an Exception!");
    }

    private String throwsNOException() {
        return "expected value";
    }

    @Test
    public void demoBugTestNOExceptionThrown(){
        String expected = "expected value";
        //String actual = "actual value";

        assertEqualsBugException(expected, () -> throwsNOException());
        // as all goes well now, this line can be replaced with 
        assertEquals(expected, throwsNOException());
    }

    private String throwsNOExceptionButReturnsWrongValue() {
        return "actual value";
    }

    @Test
    public void demoBugTestNOExceptionThrownButStillFailing(){
        String expected = "expected value";

        assertEqualsBugException(expected, () -> throwsNOExceptionButReturnsWrongValue());
        
    }
}
