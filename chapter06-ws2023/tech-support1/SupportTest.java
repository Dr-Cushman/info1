import java.util.Random;

public class SupportTest {
    public static void main(String[] args) {
        // Create a support system and start it
        SupportSystem supportSystem = new SupportSystem();
        supportSystem.start(); 

        // Create a random object and assign a random int 
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        // Assign a random number to a integer variable in one line
        // Creates a random object while assinging it to randomNumber2
        int randomNumber2 = new Random().nextInt(100);

    }
}
