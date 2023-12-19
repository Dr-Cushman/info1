import java.util.*;
/**
 * Fill in your solutions for the PreLab in
 * the corresponding methods.
 * 
 * @author Barne Kleinen
 */
public class PreLab
{
    public static void printMultiplesOf5()
    {
        for (int i = 10; i <= 95; i++) {
            // Check if the number is a multiple of 5
            if (i % 5  ==  0) {
                // Print the multiple of 5
                System.out.println( i + " is a multiple of 5" );
            }
        }
    }

    public int sumBetween(int a, int b){ 
        int sum = 0;
        /*Check if a != b and increase a’s counter by one after one run. b will not get included in the sum if a’s counter reaches the value of b.*/
        for(; a != b; a++) {
            sum +=  a;
        }
        return sum;
    }

    public void printStudentList(Collection<Student> imi1)
    {
        for(Student student : imi1) {
            System.out.println(student);
        }
    }
    
    public boolean isPrimee(int n){
        return false;
    }
    
    public static void isPrime(int i)
    {
        int isDevisibleCount = 0;
        int j = i;
        while(j != 0) {
            if(i % j == 0){
                isDevisibleCount++;
            } 
            j--;
        }
        
        if(isDevisibleCount != 2) {
            System.out.println("Die Zahl " + i + " ist keine Primzahl");
        } else {
            System.out.println("Die Zahl " + i + " ist eine Primzahl");
        }
    }

    
    public int countPrimesSmallerThan1000(){
        return 0;
    }
    
}
