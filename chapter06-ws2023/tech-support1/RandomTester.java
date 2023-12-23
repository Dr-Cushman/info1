import java.util.Random;
import java.util.ArrayList;;

public class RandomTester {
    private Random random = new Random();
    // Create an ArrayList with some answers
    private ArrayList<String> responseList = new ArrayList<String>();

    public void addItems() {
        responseList.add("Random Response 1");
        responseList.add("Random Response 2");
        responseList.add("Random Response 3");
        responseList.add("Random Response 4");
        responseList.add("Random Response 5");
    }

    public void printOneRandom() {
        System.out.println(random.nextInt(100));
    }

    public void printMultiRandom(int timesToPrintARandomNumber) {
        for(int i = 0; i < timesToPrintARandomNumber; i++) {
            System.out.println(random.nextInt());
        }
    }

    public void printTwoRandom() {
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
    }

    public void throwDie() {
        System.out.println(random.nextInt(1, 7));
    }

    // Exercise 6.20
    public void randomBetween(int i, int j) {
        System.out.println("Your random number between " + i + " and " + j + " is: " + random.nextInt(i, j + 1));
    }

    public void getRandomResponse() {
        // Generate a random number between 1 and 3 and assign it to the rResponseInt
        int rResponseInt = random.nextInt(0, responseList.size() + 1);
        System.out.println(rResponseInt);
        System.out.println(responseList.get(rResponseInt));
    }

    public static void main(String[] args) {
        RandomTester randomTester = new RandomTester();
        randomTester.randomBetween(1, 5);
    }
}
