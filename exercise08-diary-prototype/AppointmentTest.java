

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AppointmentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AppointmentTest
{
    Appointment test;
    
    /**
     * Default constructor for test class AppointmentTest
     */
    public AppointmentTest()
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
        //test = new Appointment("test", 1);
    }
    /*
    @Test
    public void checkDescription()
    {   
        String expected = "test";
        String actual = test.getDescription();   
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkDuration()
    {   
        int expected = 1;
        int actual = test.getDuration();   
        assertEquals(expected, actual); 
    }
    */
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void record()
    {
        Appointment appointm1 = new Appointment("test", 1);
        assertEquals("test", test.getDescription());
        assertEquals(1, appointm1.getDuration());
    }
}


