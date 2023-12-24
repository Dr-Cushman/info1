import java.util.Arrays;

public class SortingTest {
    int[] testNumberArray = {1, 4, 5, 6, 6, 123, 2};

    public void sortAndPrint(int[] numbers) {
        Arrays.sort(numbers);

        
       for (int i : numbers) {
            System.out.println(i);
       }

       // Stream 
       // Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
    }



    public static void main(String[] args) {
        SortingTest test = new SortingTest();
        test.sortAndPrint(test.testNumberArray);
        
    }
}
