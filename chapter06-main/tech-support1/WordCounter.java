import java.util.HashMap;
import java.util.HashSet;

public class WordCounter {
    private HashMap<String, Integer> counts;

    public WordCounter() {
        counts = new HashMap<>();
    }

    public void addWords(HashSet<String> input) {
        for (String word : input) {
            int counter = counts.getOrDefault(word, 0);
            counts.put(word, counter + 1);
        }
    }

    public void printWordCount() {
        counts.forEach((word, count) -> System.out.println(word + " -> " + count));
    }
}
