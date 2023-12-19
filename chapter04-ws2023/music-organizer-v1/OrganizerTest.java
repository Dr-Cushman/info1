public class OrganizerTest {
    public static void main(String[] args) {
        MusicOrganizer organizer = new MusicOrganizer();

        organizer.addFile("file1");
        organizer.addFile("file2");
        organizer.addFile("file3");
        organizer.addFile("file4");

        organizer.listAllFiles();
    }
}
