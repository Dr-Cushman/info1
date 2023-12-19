import java.util.*;
/**
 * Write a description of class Die here.
 *
 * @author Barne Kleinen
 * @version 2023.ws.1
 */
public class Die
{
    Random random = new Random();
    public int rollDie(){
        return random.nextInt(6) + 1;
    }

    public static void demo(){
        Die die = new Die();
        for(int i = 0; i<100; i++){
            System.out.println(die.rollDie());
        }
    }

    public static void frequencyTable(){
        Die die = new Die();
        int[] frequencyTable = new int[7];
        for(int i = 0; i<100000; i++){
            int zahl = die.rollDie();
            frequencyTable[zahl]++;  
            //frequencyTable[zahl-1] = frequencyTable[zahl-1] +1;
        }
        for(int i = 1; i<=6; i++){
            System.out.println("Die "+i+" wurde "+
                frequencyTable[i]+" mal gewürfelt.");         
        }
    }

    public static void frequencyTableArrayList(){
        Die die = new Die();
        ArrayList<Integer> frequencyTable = new ArrayList<>();
        for(int i = 0; i<=6; i++) frequencyTable.add(0);
        for(int i = 0; i<100000; i++){
            int zahl = die.rollDie();
            int oldValue = frequencyTable.get(zahl);
            frequencyTable.set(zahl, oldValue +1);
        }
        for(int zahl = 0; zahl<=6; zahl++){
            System.out.println("Die "+ zahl +" wurde "+
                frequencyTable.get(zahl) +" mal gewürfelt.");         
        }
    }

}
