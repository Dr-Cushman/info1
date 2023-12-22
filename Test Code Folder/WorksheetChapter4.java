import java.util.ArrayList;
/**
 * Write a description of class WorksheetChapter4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorksheetChapter4
{
    // instance variables - replace the example below with your own
    private ArrayList<String> items;

    /**
     * Constructor for objects of class WorksheetChapter4
     */
    public WorksheetChapter4()
    {
        items = new ArrayList<>();
    }
    
    public void addItem(String itemToAdd) {
        items.add(itemToAdd);
    }
    
    public void listItems() {
        for(String item : items) {
            System.out.println(item);
        }
    }
    
    public void getItem(int position) {
        System.out.println(items.get(position));
    }
    
    public boolean validIndex(int indexToCheck) {
        boolean isValid = false;
        if(indexToCheck >= 0 && indexToCheck < items.size()) {
            isValid = true;
        }
        
        return isValid;
    }
}
