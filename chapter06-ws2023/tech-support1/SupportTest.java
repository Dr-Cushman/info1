public class SupportTest {
    public static void main(String[] args) {
        // Create a support system and start it
        // SupportSystem supportSystem = new SupportSystem();
        // supportSystem.start();

        // Generate a InputReader
        InputReader reader = new InputReader();
        // Test InputReader method
        String input = reader.getInput();
        System.out.println(input);

        // Generate a Responder
        Responder responder = new Responder();
        // Test Responder method
        String response = responder.generateResponse();
        System.out.println(response);
    }
}
