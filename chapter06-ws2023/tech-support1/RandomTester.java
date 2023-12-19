import java.util.Random;

public class RandomTester {
    private Random random = new Random();

    public void printOneRandom() {
        System.out.println(random.nextInt(100));
    }

    public void printMultiRandom(int howMany) {
        for(int i = 0; i < howMany; i++) {
            System.out.println(random.nextInt(100));
        }
    }

    public static void main(String[] args) {
        RandomTester randomTester = new RandomTester();
        randomTester.printOneRandom();
        randomTester.printMultiRandom(10);
    }
}