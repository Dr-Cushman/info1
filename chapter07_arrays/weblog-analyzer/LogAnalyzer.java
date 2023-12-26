/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        // for(int hour = 0; hour < hourCounts.length; hour++) {
        //     System.out.println(hour + ": " + hourCounts[hour]);
        // }

        // Exercise 7.10 while loop
        int counter = 0;
        while (counter < hourCounts.length) {
            System.out.println(counter + ": " + hourCounts[counter]);
            counter++;
        }
    }

    /**
     * Return the number of accesses recorded in the log file.
     */
    public int numberOfAccesses() {
        analyzeHourlyData();

        int total = 0;
        // Add the value in each element of hourCounts to total
        System.out.println("Number of accesses:");
        for(int i = 0; i < hourCounts.length; i++) {
            // Get value at index i and add it to the total count
            total += hourCounts[i];
        }
        System.out.println(total);
        return total;
    }

    public int busiestHour() {

        int busiestHour = 0;
        // Approach 1 
        // int max;

        // // Get the maximum value of the hourCounts
        // max = Arrays.stream(hourCounts).max().getAsInt();

        // // Now compare the value at which index it is -> This is our busiestHour
        // for(int i = 0; i < hourCounts.length; i++) {
        //     if (max == hourCounts[i]) {
        //         busiestHour = i;
        //     }
        // }

        // Approach 2 
        int biggestValueFound = 0;
        int valueAtIndex = 0;
        for(int i = 0; i < hourCounts.length; i++) {
            // Scan through the Array and get the biggest value and temp save it to the temp Variables
            if (hourCounts[i] > biggestValueFound) {
                // Update biggestValue if it found a bigger value at next index and save the index at which it was found
                biggestValueFound = hourCounts[i];
                valueAtIndex = i;
            }
        }
        // Set the busiestHour to the biggest valueAtIndex found in the loop
        busiestHour = valueAtIndex;

        System.out.println(busiestHour);
        return busiestHour;
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
