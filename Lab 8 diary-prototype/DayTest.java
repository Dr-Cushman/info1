
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static testhelper.Bug.assertEqualsBug;
import static testhelper.Bug.assertEqualsBugException;
import static testhelper.Bug.FAIL_BUGS;
import static testhelper.Bug.SILENCE_ALL_BUGS;
public class DayTest
{
    private Day day1;
    private Day day2;
    private Appointment info1;
    private Appointment info2;
    private Appointment info3;   
    private Appointment info4;

    /**
     * Default constructor for test class DayTest
     */
    public DayTest()
    {
        FAIL_BUGS = false;
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        day1 = new Day(1);
        info1 = new Appointment("info1", 2);
        day1.makeAppointment(11, info1);
        info2 = new Appointment("info2", 2);
    }

    @Test
    public void makeAppointmentWith2ndHourFull()
    {   //given 
        // day1 one has one 2h appointment at 1100
        // when I try to make 2hr app. at 10
        boolean actual = day1.makeAppointment(10, info2);
        // then false should be returned
        boolean expected = false;
        assertEqualsBug(expected, actual);
    }

    @Test
    public void findSpace()
    {   //given 
        // day1 one has one 2h appointment at 1100
        // when I try to make 2hr app. at 10
        int actual = day1.findSpace(info2);
        // then false should be returned
        int expected = 9;
        assertEquals(expected, actual);
    }
    
    @Test
    public void findSpace10()
    {   
        info3 = new Appointment("info3", 1);        
        day1.makeAppointment(9, info3);
        int actual = day1.findSpace(info3);
        int expected = 10;
        assertEquals(expected, actual);
    }
    
    @Test
    public void findSpaceWhenFull()
    {   
        day2 = new Day(2);
        info3 = new Appointment("info3", 9);
        day1.makeAppointment(9, info3);
        int actual = day1.findSpace(info2);
        int expected = -1;
        assertEquals(expected, actual);
    }
    
    @Test
    public void negativeTest()
    {   
        info3 = new Appointment("info3", 1);        
        day1.makeAppointment(15, info3);
        boolean actual = day1.makeAppointment(15, info2);
        boolean expected = false;
        assertEqualsBug(expected, actual);
    }    
    
    @Test
    public void negativeNummber()
    {   
        info3 = new Appointment("info3", -1);        
        boolean actual = day1.makeAppointment(9, info3);
        boolean expected = false;
        assertEqualsBug(expected, actual);
    }  

    @Test
    public void zeroTest()
    {
        Appointment appointm1 = new Appointment("test", 0);
        assertEquals(false, day1.makeAppointment(9, appointm1));
    }
    
    @Test
    public void SameAppointment()
    {
        Appointment appointm1 = new Appointment("test", 1);
        day1.makeAppointment(14, appointm1);
        assertEquals(false, day1.makeAppointment(16, appointm1));
    }
    
    
}




