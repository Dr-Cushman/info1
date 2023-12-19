import java.util.*;

public class Note
{
    private static int instanceCount = 0;
    private static  List<Note> instances = new ArrayList<>();
    private String text;
    /**
     * Constructor for objects of class Note
     */
    public Note(String text)
    {
        this.text = text;
        instanceCount++;
        instances.add(this);
    }

    public static void demo(){
        new Note("A");
        new Note("C");
        new Note("D");
        new Note("E");
        System.out.println(instanceCount);
        for (Note n: instances){
            System.out.println(n.text);
        }
    }
}
