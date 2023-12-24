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

    public static void main(String[] args) {
        HashMapTest test = new HashMapTest();
        System.out.println(test.contacts.size());
    }

}
