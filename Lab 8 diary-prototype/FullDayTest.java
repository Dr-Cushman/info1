

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FullDayTest
{
    private Day day1;
    private Appointment info1;
    private Appointment info2;

    /**
     * Default constructor for test class DayTest
     */
    public FullDayTest()
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
        day1 = new Day(1);
        info1 = new Appointment("long app.", 9);
        day1.makeAppointment(9, info1);
        info2 = new Appointment("info2", 2);
    }


    //@Test
    public void makeAppointmentInFullDay()
    {   //given 
        // full day
        // when trying to find space for app.
        int actual = day1.findSpace(info2);
        // then false should be returned
        int expected = -1;
        assertEquals(expected, actual);
    }
    
    // negative test
    @Test
    public void findSpaceInFullDay()
    {   //given 
        // day1 one has one 2h appointment at 1100
        // when I try to make 2hr app. at 10
        int actual = day1.findSpace(info2);
        // then false should be returned
        int expected = -1;
        assertEquals(expected, actual);
    }
}

