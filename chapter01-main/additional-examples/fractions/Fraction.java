
/**
 * Represents a Fraction.
 * (dt.: Bruch)
 * 
 * @author Barne Kleinen
 */
public class Fraction
{
    private int num;
    private int den;

    public Fraction(int numerator,int denominator)
    {
        this.num = numerator;
        this.den = denominator;
    }

    public String toString(){
        return ""+ num+"/" + den;
    }

    public double getValue(){
        return (double)num / den;
    }
}
