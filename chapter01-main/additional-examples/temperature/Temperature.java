
/**
 * Represents a single Temperature value.
 * Can be asked for its value in degrees 
 * celsius and fahrenheit
 *
 * @author Barne Kleinen
 */
public class Temperature
{
    private double celsius;

    public Temperature(double celsius)
    {
        this.celsius = celsius;
    }

    public double getCelsius()
    {
        return celsius;
    }
    public double getFahrenheit(){
        return celsius * 1.8 + 32;
    }
}
