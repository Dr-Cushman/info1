
/**
 * Demonstrates the Fraction Class.
 * 
 * @author Barne Kleinen 
 */
public class TestFraction
{
    public void testOneHalf(){
        Fraction a = new Fraction(1, 2);
        
        System.out.println(a + "(" +a.getValue()+")");
    }

    public void testOneThird(){
        Fraction a = new Fraction(1, 3);
        System.out.println(a + "(" +a.getValue()+")");
    }

}
