public class MonitorTest {
    public static void main(String[] args) {
        AnimalMonitor monitor = new AnimalMonitor();
        System.getProperty("user.dir");
        monitor.addSightings("sightings.csv");

        // Print endangered species.
        System.out.println("Endangered species:");
        

    }
}
