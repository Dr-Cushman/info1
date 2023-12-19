package codequizz;
import static org.junit.jupiter.api.Assertions.*;

public class Expect
{
    public static boolean ON = false;
    public static final String ____ = "FILL THIS IN";
    
    public static void expect(Object expected, Object actual){
    //public static void expect(String expected, String actual){
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String context = caller.toString();
        
        if(!ON || expected.equals(actual)) return;
        if(____.equals(expected))
            fail("replace ____ with your expectation in: "+context);
        else 
            fail("\""+expected + "\" is not correct! - try again: "+context);
    }
}
