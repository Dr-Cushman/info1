import java.util.ArrayList;

public class MonitorTest {
    public static void main(String[] args) {
        // Create a new monitor and add some sightings to it.
        AnimalMonitor monitor = new AnimalMonitor();
        Sighting sighting =  new Sighting("Tiger", 1, 4, 3, 1);
        Sighting sighting2 =  new Sighting("Tiger", 1, 0, 3, 1);
        Sighting sighting3 =  new Sighting("Tiger", 1, 1, 3, 1);
        Sighting sighting4 =  new Sighting("Bear", 1, 1, 3, 1);
        Sighting sighting5 =  new Sighting("Bear", 1, 5, 3, 2);
        
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Tiger");
        animals.add("Bear");
        
        monitor.addSighting(sighting);
        monitor.addSighting(sighting2);
        monitor.addSighting(sighting3);
        monitor.addSighting(sighting4);
        monitor.addSighting(sighting5);

        // PrintList
        monitor.printSightingsOfInPeriod("Bear", 1);
        monitor.printCount("Bear");

        // Test printEndangered
        monitor.printEndangered(animals,5);



    }
}
