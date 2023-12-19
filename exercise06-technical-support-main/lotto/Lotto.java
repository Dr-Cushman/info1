import java.util.Set;
import java.util.HashSet;
import java.util.Random;

/**
 * Draw and count Lotto Numbers
 *
 * @author Barne Kleinen
 */
public class Lotto
{
    private Random random = new Random();

    /**
     * The Method drawLotto() creates a new HashSet called
     * lottoNumbers, where it will be filled through a
     * while-loop with six random numbers between 1 and 49.
     */
    public Set<Integer> drawLotto() {
        Set<Integer> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(random.nextInt(49) + 1);
        }

        return lottoNumbers;
    }

    /**
     * The countNumbers() method takes an integer for the
     * Iterations it has to do. In the method an Array with
     * a size of 50 is created called frequencyTable. This
     * table is then filled with ones for every number there
     * is in a drawLotto() Iteration.
     */
    public int[] countNumbers(int iterations) {
        int[] frequencyTable = new int[49];

        for (int i = 0; i < iterations; i++) {
            Set<Integer> numbers = drawLotto();

            for (int number : numbers) {
                frequencyTable[number - 1]++;
            }
        }

        return frequencyTable;
    }

    /**
     * The generateAndPrintFrequencyTable() just uses the
     * countNumbers() method and prints them out in a readable
     * state in the console.
     */
    public void generateAndPrintFrequencyTable(int iterations) {
        int[] frequencyTable = countNumbers(iterations);

        System.out.println("Lotto Number Frequencies after " + iterations + " iterations:");
        System.out.println("Number\tFrequency");
        for (int i = 0; i < frequencyTable.length; i++) {
            System.out.println((i + 1) + "\t\t" + frequencyTable[i]);
        }
    }

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
    }
}