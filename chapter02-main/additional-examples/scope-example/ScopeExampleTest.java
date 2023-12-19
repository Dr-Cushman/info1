

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ScopeExampleTest.
 *
 * @author  Barne Kleinen
 */
public class ScopeExampleTest
{
    private ScopeExample se1;
    private ScopeExample se2;

    /**
     * Default constructor for test class ScopeExampleTest
     */
    public ScopeExampleTest()
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
        se1 = new ScopeExample();
        se2 = new ScopeExample();
    }


    @Test
    public void testSe1Field()
    {
        assertEquals(1, se1.countField());
        assertEquals(2, se1.countField());
        assertEquals(3, se1.countField());
        assertEquals(3, se1.getX());
    }
    
    @Test
    public void testSe1Local()
    {
        assertEquals(1, se1.countLocal());
        assertEquals(1, se1.countLocal());
        assertEquals(1, se1.countLocal());
        assertEquals(0, se1.getX());
    }
    
    @Test
    public void test2Instances()
    {
        se1.countField();
        se1.countField();
        se1.countLocal();
        
        se2.countField();
        se2.countLocal();
        se2.countLocal();
        
        assertEquals(2, se1.getX());
        assertEquals(1, se2.getX());     
        
    }
    
}

