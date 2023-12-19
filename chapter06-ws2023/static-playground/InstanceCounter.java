
public class InstanceCounter
{
    private static int instanceCount = 0;

    private int exampleForIntanceVariable = 0;

    /**
     * Constructor for objects of class InstanceCounter
     */
    public InstanceCounter()
    {

        instanceCount++;
    }

    public static void demoInstance(){
        System.out.println(instanceCount);
    }

    public static void demo(){
        //exampleForIntanceVariable++;
        new InstanceCounter();
        new InstanceCounter();
        new InstanceCounter();
        new InstanceCounter();
        System.out.println(instanceCount);
    }
}
