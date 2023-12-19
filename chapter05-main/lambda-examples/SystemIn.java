import java.io.*;
import java.util.function.*;
import java.util.stream.Stream;

public class SystemIn
{
    private SystemIn(){}

    public static void demo(){

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines();
        stream
            //.limit(10).
        .filter(line -> line.contains("a"))
        .map(line -> "Your line containted an a: "+line )
        .map(line -> line + "\n(and was "+line.length() +" chars long)")
        .forEach(System.out::println);

        System.out.println("Done!");
    }

    public static void demoTerminating(){

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines();
        stream
            //.limit(10).
        .filter(line -> line.contains("a"))
        .map(line -> "Your line containted an a: "+line )
        .map(line -> line + "\n(and was "+line.length() +" chars long)")
        .map(line -> {
                System.out.println(line);
                return line;
            })
        .anyMatch(line -> {
                boolean result = line.contains("quit");
                System.out.println(result);
                return result;
            });

        System.out.println("Done!");
    }

    public static void gameStream(){

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines();
        stream
        .map(line -> processCommand(line))
        .anyMatch(result -> {
                System.out.println(result);
                return result == null;
            });
        System.out.println("Done!");
    }

    public static String processCommand(String line){
        if (line.contains("quit"))
            return null;
        else 
            return "Game processed: "+line;
    }
}
