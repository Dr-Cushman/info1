import java.util.ArrayList;
import java.util.Iterator;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (imperative)
 */
public class AnimalMonitor 
{
    // Records of all the sightings of animals.
    private ArrayList<Sighting> sightings;
    
    /**
     * Create an AnimalMonitor.
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>();
    }
    
    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     */
    public void addSightings(String filename)
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings(filename));
    }
    
    public void test() {
       // Pseudo code to:  Write pseudo-code to determine how many elephants a particular 
       // spotter (spotterID) saw on a particular day (dayID).
       // sightings.filter(name == elephant).filter(spotter == spotterID).filter(day == dayID).reduce(add up)

       // Pseudo code to:  Write pseudo-code to determine how many elephants a particular spotter (spotterID) saw in a particular area (areaID).
         // sightings.filter(name == elephant).filter(spotter == spotterID).filter(area == areaID).reduce(add up)

        // Write pseudo-code to create a stream containing only those sightings that have a count greater than 0
        // sightings.filter(count > 0)

        //         Consider the music-organizer project from Chapter 4 and assume 
        // that each Track object in the collection contains a count of how many times 
        // it has been played. Write pseudo-code to determine the total number of times 
        // tracks by the artist Big Bill Broonzy have been played.
        // tracks.filter(artist == "Big Bill Broonzy").reduce(add up)
    }

    // Print details of all sightings recorded on a particular dayID
    public void printDetailsOnParticularDay(int dayID) {
        // For each representation 
        for (Sighting record : sightings) {
            // Check if  dayID is equal to the records
            if (record.getPeriod() == dayID) {
                // Print objects details
                System.out.println(record.getDetails());
            } 
        }

        // Lambda expression
        // sightings.forEach(record -> System.out.println(record.getDetails()));

        // Stream expression
        // sightings.stream()
        //      .forEach( element -> System.out.println(element.getDetails()));

    }

    public void checkHowManyAnimalsASpotterSawOnDay() {

    }
    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        for(Sighting record : sightings) {
            System.out.println(record.getDetails());
        }


        // Lambda expressions
        // sightings.forEach(
        //     (Sighting record) ->
        //     {
        //         System.out.println(record.getDetails());
        //     }
        // );

        // sightings.forEach(record -> System.out.println(record.getDetails()));

        // Stream
        // sightings.stream()
        //      .forEach( element -> System.out.println(element.getDetails()));

    }

    public void printDetailsOfAnimalOnDay(String animal, int dayID) {
        // Two filter calls
        sightings.stream()
                // Filter by animal
                .filter(sighting -> animal.equals(sighting.getAnimal()))
                // Filter by dayID
                .filter(sighting -> sighting.getPeriod() == dayID)
                // Print details
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }
    
    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    {
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                System.out.println(record.getDetails());
            }
        }

        // Lambda expression
        // sightings.forEach(record -> {System.out.println(record.getDetails());});

        // Stream
        // sightings.stream()
        //     .filter(s -> animal.equals(s.getAnimal()))
        //     .forEach(s -> System.out.println(s.getDetails()));
    }

    public void printCountTotalOfSightings() {
        // 1 Method: size of list
        int totalSightings = sightings.size();
        System.out.println("Total number of sightings: " + totalSightings);

        // 2 Method: Using a stream to count
        // long totalSightings = sightings.stream().count();
        // System.out.println("Total number of sightings: " + totalSightings);

        // 3 Method: lambda representation
        // sightings.forEach(element -> System.out.println(element.getDetails()));
    }
    
    /**
     * Print all the sightings by the given spotter.
     * @param spotter The ID of the spotter.
     */
    public void printSightingsBy(int spotter)
    {
        // For each representation
        // for(Sighting record : sightings) {
        //     if(record.getSpotter() == spotter) {
        //         System.out.println(record.getDetails());
        //     }
        // }        

        // Lambda expression
        // sightings.forEach(record -> {
        //     if(record.getSpotter() == spotter) {
        //         System.out.println(record.getDetails());
        //     }
        // });

        //Stream
        sightings.stream()
            .filter(sighting -> sighting.getSpotter() == spotter)
            .map(sighting -> sighting.getDetails())
            .forEach(System.out::println); 

        // Rewritten for Exercise 5.14
        // sightings.stream()
        //         .filter(sighting -> sighting.getSpotter() == spotter)
        //         .map(sighting -> sighting.getDetails())
        //         .forEach(System.out::println);

    }
    
    public void printCountsOfSightingsOfParticularAnimal(String animal) {
        // Stream 
        sightings.stream()
                // Filter by animal
                .filter(sighting -> animal.equals(sighting.getAnimal()))
                .map(sighting -> sighting.getCount())
                .forEach(count -> System.out.println(count));
        
    }


    public long getAnimalCountSpottedInEachSighting(int spotter) {
        // Stream
        long result = sightings.stream()
                                .filter(sighting -> sighting.getSpotter() == spotter)
                                .mapToLong(sighting -> sighting.getCount())
                                .sum();
        return result;
    }
    /**
     * Print a list of the types of animal considered to be endangered.
     * @param animalNames A list of animals names.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be dangerous.
     */
    public void printEndangered(ArrayList<String> animalNames, int dangerThreshold)
    {
        // for(String animal : animalNames) {
        //     if(getCount(animal) <= dangerThreshold) {
        //         System.out.println(animal + " is endangered.");
        //     }
        // }

        // Stream
        animalNames.stream()
                    // Go through each animal in the ArrayList and check if the count is below the threshold
                    .filter(animal -> getCount(animal) <= dangerThreshold)
                    // Print the animal name
                    .forEach(animal -> System.out.println(animal + " is endangered. And there are " + getCount(animal) + " of them."));
    }
    
    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        // int total = 0;
        // for(Sighting sighting : sightings) {
        //     if(animal.equals(sighting.getAnimal())) {
        //         total = total + sighting.getCount();
        //     }
        // }

        // Stream
        return sightings.stream()
                        .filter(sighting -> animal.equals(sighting.getAnimal()))
                        .map(sighting -> sighting.getCount())
                        .reduce(0, (total, count) -> total + count);
    }
    
    public int countOfSightings(String animal, int spotterID, int dayID) {
        return sightings.stream()
                        // Filter by animal first
                        .filter(sighting -> animal.equals(sighting.getAnimal()))
                        // Filter by spotterID
                        .filter(sighting -> sighting.getSpotter() == spotterID)
                        // Filter by dayID
                        .filter(sighting -> sighting.getPeriod() == dayID)
                        // count
                        .map(sighting -> sighting.getCount())
                        // reduce 
                        .reduce(0, (total, count) -> total + count);
    }

    public void streamSightingsThatHaveCount() {
        sightings.stream()
                .filter(s -> s.getCount() != 0)
                .forEach(s -> System.out.println(s.getAnimal() + " " + s.getCount()));
    }
    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    public void removeZeroCounts()
    {
        // Iterator<Sighting> it = sightings.iterator();
        // while(it.hasNext()) {
        //     Sighting record = it.next();
        //     if(record.getCount() == 0) {
        //         it.remove();
        //     }
        // }

        // Stream
        sightings.removeIf(sighting -> sighting.getCount() == 0);
    }
    
    public void removeSpotter(int spotterID) {
        sightings.removeIf(sighting -> sighting.getSpotter() == spotterID); 
    }


    // Return largest count of a particular animal
    public int getLargestCount(String animal) {
        int largestCount = 0;
        for(Sighting sighting : sightings) {
            if(animal.equals(sighting.getAnimal())) {
                if(sighting.getCount() > largestCount) {
                    largestCount = sighting.getCount();
                }
            }
        }
        return largestCount;

        // Stream
        // return sightings.stream()
        //                 .filter(sighting -> animal.equals(sighting.getAnimal()))
        //                 .map(sighting -> sighting.getCount())
        //                 .reduce(0, (largestCount, count) -> {
        //                     if (count > largestCount) {
        //                         return count;
        //                     } else {
        //                         return largestCount;
        //                     }
        //                 });
    }

    public String getAnimalNamesSeenOnDayBySpotter(int spotterID, int dayID) {
        // // For each representation
        // for(Sighting sighting : sightings) {
        //     if (sighting.getSpotter() == spotterID && sighting.getPeriod() == dayID) {
        //         return sighting.getAnimal();                
        //     }
        // }
        // return ""; // Add a default return value if no animal is found

        // Stream
        return sightings.stream()
                        // Filter by spotterID
                        .filter(sighting -> sighting.getSpotter() == spotterID)
                        // Filter by dayID
                        .filter(sighting -> sighting.getPeriod() == dayID)
                        // Filter out animals where the count is 0
                        .filter(sighting -> sighting.getCount() > 0)
                        // Get animal name
                        .map(sighting -> sighting.getAnimal())
                        // reduce
                        .reduce("", (animal, name) -> animal + name);
    }

    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     * @param animal The type of animal.
     * @param area The ID of the area.
     * @return A list of sightings.
     */
    public ArrayList<Sighting> getSightingsInArea(String animal, int area)
    {
        ArrayList<Sighting> records = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                if(record.getArea() == area) {
                    records.add(record);
                }
            }
        }
        return records;
    }
    
    /**
     * Return a list of all the sightings of the given animal.
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    public ArrayList<Sighting> getSightingsOf(String animal)
    {
        ArrayList<Sighting> filtered = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                filtered.add(record);
            }
        }
        return filtered;
    }
    
}
