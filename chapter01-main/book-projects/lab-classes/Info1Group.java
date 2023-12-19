
/**
 * Info1 Group creates a LabClass with your Group
 * as enrolled Students.
 *
 * @author Barne Kleinen
 */
public class Info1Group
{

    public Info1Group(){

    }  

    public LabClass createGroup()
    {
        LabClass labClass = new LabClass(4);
        return labClass;
    }
}
