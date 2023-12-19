
/**
 * This class demonstrates the differences in 
 * Scope between instance variables (fields) and local variables.
 *
 * @author Barne Kleinen
 */
public class ScopeExample
{
    
    private int x = 0;

    public int countField(){
        x = x + 1;
        return x;
    }
    
    public int countLocal(){
        int x = 0; 
        x = x + 1;
        return x;
    }
    
    public int getX(){
        return x;
    }

}
