

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class ArrayListExplorationTest
{
    // set up by fixture -> needs to be field!
    ArrayList<String> list;
    
    /**
     * Default constructor needs to be present for JUnit!
     */
    public ArrayListExplorationTest()
    {
    }

    /**
     * Create an ArrayList with four elements as text fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
    }


    @Test
    public void exploreAddWithIndex()
    {
        list.add(2,"z");
        // see https://www.baeldung.com/java-join-and-split
        String actual = list.stream().collect(Collectors.joining(","));
        assertEquals("a,b,z,c,d",actual);
        
    }

    @Test
    public void removeShiftsRestToLeft()
    {
        int initialSize = list.size();
        list.remove(1);
        assertEquals(initialSize-1,list.size());
        assertEquals("c",list.get(1));
        assertEquals("d",list.get(2));
    }
    
  
    
}


