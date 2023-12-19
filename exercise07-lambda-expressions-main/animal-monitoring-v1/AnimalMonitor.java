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
    
    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        // for(Sighting record : sightings) {
        //     System.out.println(record.getDetails());
        // }
        sightings.forEach(sighting -> System.out.println(sighting.getDetails()));

        // Stream with count
        // System.out.println(sightings.stream().count());
            
    }
    
    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    {
        // for(Sighting record : sightings) {
        //     if(animal.equals(record.getAnimal())) {
        //         System.out.println(record.getDetails());
        //     }
        // }

        // Stream with filter
        sightings.stream()
            .filter(sighting -> animal.equals(sighting.getAnimal()))
            .forEach(sighting -> System.out.println(sighting.getDetails()));
    }
    
    /**
     * Print all the sightings by the given spotter.
     * @param spotter The ID of the spotter.
     */
    public void printSightingsBy(int spotter)
    {
        for(Sighting record : sightings) {
            if(record.getSpotter() == spotter) {
                System.out.println(record.getDetails());
            }
        }        
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
        sightings.stream()
            // Select only animals in animalNames
            .filter(sighting -> animalNames.contains(sighting.getAnimal()))
            // Map to count
            .map(sighting -> sighting.getCount())
            // Filter by dangerThreshold
            .filter(count -> count <= dangerThreshold)
            // Print
            .forEach(count -> System.out.println(count + " is endangered."));
            


    }
    
    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        int total = 0;
        for(Sighting sighting : sightings) {
            if(animal.equals(sighting.getAnimal())) {
                total = total + sighting.getCount();
            }
        }
        return total;
    }
    
    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    public void removeZeroCounts()
    {
        Iterator<Sighting> it = sightings.iterator();
        while(it.hasNext()) {
            Sighting record = it.next();
            if(record.getCount() == 0) {
                it.remove();
            }
        }
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

    public void addSighting(Sighting sighting) {
        sightings.add(sighting);
    }

    public void printSightingsInPeriod(int periodID) {
        sightings.stream()
            // Filter all sightings by periodID
            .filter(sighting -> sighting.getPeriod() == periodID)
            // Print all sightings
            .forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    public void printSightingsOfInPeriod(String animal, int periodID) {
        sightings.stream()
            // Filter all sightings by periodID
            .filter(sighting -> sighting.getPeriod() == periodID)
            // Filter all sightings by animal
            .filter(sighting -> animal.equals(sighting.getAnimal()))
            // Print all sightings
            .forEach(sighting -> System.out.println(sighting.getDetails()));

    }

    public void printCount(String animal) {
        sightings.stream()
            // Filter by animal name first
            .filter(sighting -> animal.equals(sighting.getAnimal()))
            // Map to count
            .map(sighting -> sighting.getCount())
            // Print
            .forEach(count -> System.out.println(count));

    }
    
}
