import java.util.ArrayList;

public class ArrayListPlayground
{
    ArrayList<String> myList = new ArrayList<>();
    public ArrayList<String> testArrayList()
    {

        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");

        myList.remove(1);
        System.out.println(myList.size());
        System.out.println(myList.get(1));

        return myList;

        
    }
    public
}
