package testhelper;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Supplier;

public class Bug
{
    public static boolean FAIL_BUGS = true;
    public static boolean SILENCE_ALL_BUGS = false;

    public static void assertEqualsBug(Object expected, Object actual){
        if (!FAIL_BUGS || SILENCE_ALL_BUGS )
            return;
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String context = caller.toString();
        assertEquals(expected,actual,"found BUG in "+caller+":");
    }

    public static void assertEqualsBugException(Object expected, Supplier lambda){
        if (!FAIL_BUGS || SILENCE_ALL_BUGS )
            return;
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String context = caller.toString();
        Object actual = null;
        try {
            actual = lambda.get();
        }
        catch(Exception e){
            fail("found BUG that threw Exception "+ e.getClass() + ": "+e.getMessage() + " in "+caller);   
            return;
        }
        assertEquals(expected,actual,"found BUG with expected EXCEPTION (which was not thrown) in "+caller+":");
    }
}
