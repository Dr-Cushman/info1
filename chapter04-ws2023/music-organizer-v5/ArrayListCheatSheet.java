import java.util.ArrayList;

public class ArrayListCheatSheet
{

    public void run(){

    }

    // Worksheet 
    ArrayList<String> files = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();

    public void eins(){
        // a
        items.get(4);
        // b
        String favouriteTrack = "x.mp2";
        files.add(favouriteTrack);

        
    }

    // c
    public boolean validIndex(int index){
        if ((index <= 0) || (files.size() < index))
            return false;
        else
            return true;

    }
    
    public boolean validIndexImproved(int index){
        if ((0 <= index) && (index < files.size()))
            return true;
        else
            return false;

    }
    
    public boolean validIndexImproved2(int index){
        return ((0 <= index) && (index < files.size()));

    }

}
