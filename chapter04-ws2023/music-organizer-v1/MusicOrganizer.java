import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }
    
    public void listAllFiles() {
        int index = 0;
        for (String fileName : files) {
            System.out.println("Index: " + index + " Value: " + fileName);
            index++;
        }
    }

    // List all files in reversed alphabetical order and save the set in a new ArrayList that is returned
    public ArrayList<String> listAllFilesReversed() {
        ArrayList<String> reversedArrayList = new ArrayList<>();
        for (int i = files.size() - 1; i >= 0; i--) {
            reversedArrayList.add(files.get(i));
        }
        return reversedArrayList;
    }

    public void printReversedArrayList(ArrayList<String> reversedArrayList) {
        if (reversedArrayList.size() == 0) {
            System.out.println("No files in the list");
        } else {
            for (String fileName : reversedArrayList) {
                System.out.println(fileName);
            }
        }
    }

    public void updateDatabase(Track track) {
        files.clear();
        
        // Update the empty files ArrayList with the track ArrayList
        for (String trackName : track.getTrack()) {
            files.add(trackName);
        }
    }

    // Write a method that interacts with the Track class and updates the files ArrayList
    public void updateDatabase(Track track, String trackName) {
        files.clear();
        
        // Update the empty files ArrayList with the track ArrayList
        for (String trackNamee : track.getTrack()) {
            files.add(trackNamee);
        }

        // Add the new trackName to the files ArrayList
        files.add(trackName);
    }

    public void listMatching(String searchString) {
        boolean found = false;

        // Loop through the files ArrayList and check if the searchString is contained in any of the filenames
        for (String filename : files) {
            if (filename.contains(searchString)) {
                // If the searchString is contained in the filename, print the filename
                System.out.println(filename);
                // Set found to true
                found = true;
            } else {
                found = false;
            }
        }

        // If found is true, print that the file was found, otherwise print that the file was not found
        if (found) {
            System.out.println("File was found");
        } else {
            System.out.println("File was not found");
        }
    }
    

    public static void main(String[] args) {
        MusicOrganizer organizer = new MusicOrganizer();
        
        organizer.addFile("test1.mp3");
        organizer.addFile("test2.mp3");
        organizer.addFile("test3.mp3");
        organizer.addFile("test4.mp3");

        organizer.listAllFiles();
        organizer.printReversedArrayList(organizer.listAllFilesReversed());

        organizer.listMatching("test4.mp3");
    }
}
