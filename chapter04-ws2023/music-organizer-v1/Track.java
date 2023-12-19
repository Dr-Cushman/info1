import java.util.ArrayList;

public class Track {
ArrayList<String> track = new ArrayList<>();


public void addTrack(String trackName) {
    track.add(trackName);
}

public int getNumberOfTracks() {
    return track.size();
}

public void removeTrack(String trackToRemove) {
    if (track.contains(trackToRemove)) {
        track.remove(trackToRemove);
    } else {
        System.out.println(trackToRemove + " Was not found in your Tracklist");
    }
}



public String[] getTrack() {
    // Convert the ArrayList to an Array
    String[] trackArray = new String[track.size()];

    trackArray = track.toArray(trackArray);
    return trackArray;
}
}