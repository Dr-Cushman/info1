import java.util.HashMap;

public class HashMapTest {
    HashMap<String, String> contacts = new HashMap<>();
    
    public HashMapTest() {
        contacts.put("Anna", "01718949776");
        contacts.put("Jana", "01444546555");
        contacts.put("Peter", "0175664976");
        contacts.put("Olaf", "01315537746");
        contacts.put("Artha", "0135455464");
    }

    public void enterNumber(String name, String number) {
        contacts.put(name, number);
    }

    public String lookupNumber(String name) {
        return contacts.get(name);
    }

    public boolean checkKey(String name) {
        return contacts.containsKey(name);
    }

    public static void main(String[] args) {
        HashMapTest test = new HashMapTest();
        test.enterNumber("Anna", "001");
        System.out.println(test.lookupNumber("Anna"));
        System.out.println(test.checkKey("Anna"));
        System.out.println(test.contacts.containsValue("test"));
        System.out.println(test.contacts.keySet());
    }
}
