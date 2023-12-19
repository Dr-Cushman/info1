import java.util.*;
public class PhoneBook
{
    Map<String,Integer> phoneBook = new HashMap<>();
    
    public PhoneBook(){
        enterNumber("Zhang",3738);
        enterNumber("Jung",2877);
        enterNumber("Barthel",2416);
        enterNumber("Lenz",3642);
        enterNumber("Strippgen",3593);
        enterNumber("Busch",4711);
        enterNumber("Kleinen",3499);
        enterNumber("Weber-Wulff",2320);
    }

    public void enterNumber(String name, Integer number){
        phoneBook.put(name,number);
    }

    public int lookupNumber(String name){
        return phoneBook.get(name);
    }
    public static PhoneBook demo(){
        
        PhoneBook pb = new PhoneBook();
        return pb;
        
    }
    
    public void printPhoneBook(){
        for(String name : phoneBook.keySet()){
            System.out.println(name+": "+lookupNumber(name));
        }
    }
}
