import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class Responder
{
    private Random randomGenerator;
    private ArrayList<String> defaultResponses;
    private HashMap<String, String> responseMap;


    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        randomGenerator = new Random();
        defaultResponses = new ArrayList<>();
        responseMap = new HashMap<>();

        fillDefaultResponses();
        fillResponseMap();
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(String word){
        if (responseMap.get(word) != null ) {
            return responseMap.get(word);
        } else {
            return pickDefaultResponse();
        }
    }

    private String pickDefaultResponse() {
        return defaultResponses.get(randomGenerator.nextInt(defaultResponses.size()));
    }

    private void fillDefaultResponses() {
        defaultResponses.add("That sounds odd. Clould you describe this in more detail?");
        defaultResponses.add("No other customer has ever complained about this \n" + 
                             "before. What is your system configuration=");
        defaultResponses.add("I need a bit more information on that.");
        defaultResponses.add("Have you checked that you do not have a dll conflict?");
        defaultResponses.add("That is covered in the manual. Have you read the manual?");
        defaultResponses.add("Thats not a bug. That's a feature.");
        defaultResponses.add("Fart...");
    }

    private void fillResponseMap() {
        responseMap.put("slow", "Upgrade your computer");
        responseMap.put("bug", "I write clean code, no bugs will ever be found");
        responseMap.put("expensive", "Work harder or stop wasting your money on useless stuff");
    }
}

