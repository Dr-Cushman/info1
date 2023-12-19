

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TemperatureTest.
 *
 * @author  Barne Kleinen
 */
public class TemperatureTest
{
    private Temperature temperature = new Temperature(20);


    @Test
    public void testCelsius()
    {
        assertEquals(20, temperature.getCelsius(), 0.001);

    }
    
    @Test
    public void testFahrenheit()
    {
        assertEquals(68, temperature.getFahrenheit(), 0.001);
    }
    
    @Test
    public void testMany()
    {
        assertEquals(32, new Temperature(0).getFahrenheit(), 0.001);
        assertEquals(212, new Temperature(100).getFahrenheit(), 0.001);
        assertEquals(50, new Temperature(10).getFahrenheit(), 0.001);
        assertEquals(86, new Temperature(30).getFahrenheit(), 0.001);
        assertEquals(90, new Temperature(32.2222).getFahrenheit(), 0.001);
        assertEquals(104, new Temperature(40).getFahrenheit(), 0.001);
    }
    
}

