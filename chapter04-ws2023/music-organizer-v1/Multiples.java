public class Multiples {

    public void printMultiplesOfFive(int endNumber) {
        int index = 0;
        while(index <= endNumber) {
            System.out.println(index);
            index += 5;
        }
    }

    public int sumBetween(int a, int b) {
        int result = 0;
        int index = a;
        while (index <= b) {
            result += index;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Multiples multiples = new Multiples();

        // multiples.printMultiplesOfFive(30);
        System.out.println(multiples.sumBetween(0,4));
    }
}