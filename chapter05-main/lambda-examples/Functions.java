import java.util.function.*;
import java.util.stream.*;
/**
 * Example for simple Math functions as Lambdas.
 *
 * @author Barne Kleinen
 * @version (a version number or a date)
 */
public class Functions
{
    public Functions(){}

    public static void demo(){
        Functions instance = new Functions();
        instance.printValuesFromTo(0,20,1);
    }

    /** 
     * let's say you're writing a method that plots a function,
     * or, for the ease of implementation, computes and prints
     * the values in a specified range.
     */
    public void printValuesFromTo(int from, int to, int step){
        for(int i= from; i <= to; i += step){
            System.out.println("x: "+i + " f(x) = "+i+"??");
        }
    }

    /**
     * it would be nice if the function could be passed as a 
     * parameter! Here's how we would use it:
     */

    public void demoLambdaStraight(){
        // printValuesFromToF("n*2",0,20,1,n -> n * 2);
        printValuesFromToF("n",0,5,1,n -> n);
        // printValuesFromToF("n/2",0,20,1,n -> n/2);
        // printValuesFromToF("n*n",0,20,1,n -> n*n);

    }

    /**
     * and here's the enhanced printValuesFromToF method
     * that takes the funtion - a IntToDoubleFunction - 
     * as Parameter
     */
    public void printValuesFromToF(String message,int from, int to,
    int step, IntToDoubleFunction f ){
        System.out.println("Function: "+message);
        for(int i= from; i <= to; i += step){
            System.out.println("i: "+i + " f(i) = "+f.applyAsDouble(i));
        }
    }

    /**
     * Repeating the same thing more than once should be done in
     * a loop, so let's put the functions in an array and call 
     * the method in a loop.
     */
    public void demoLambdaLoop(){
        IntToDoubleFunction[] function ={ n -> n * 2, n -> n , n -> n/2, n -> n*n};
        String[] message = {"n * 2","n","n/2","n*n"};
        for(int i=0;i<function.length;i++)
            printValuesFromToF(message[i],0,20,1,function[i]);

    }

    public void avoidForLoop(){
       IntStream indices = IntStream.range(0,20);
       indices.mapToObj(n -> ""+n+": "+n * 2).forEach(System.out::println);
       
       IntStream intStream = IntStream.iterate(0,i->i+1).limit(20);
       intStream.mapToObj(n -> ""+n+": "+n * 2).forEach(System.out::println);
    }
}
