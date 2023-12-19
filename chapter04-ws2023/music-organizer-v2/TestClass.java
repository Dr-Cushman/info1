public class TestClass {
    public static void main(String[] args) {
        MusicOrganizer organizer = new MusicOrganizer();

        organizer.addFile("test.mp3");
        organizer.addFile("test2.mp3");
        organizer.addFile("test3.mp3");
        organizer.listFile(0);

        organizer.listAllFiles();

    }
}
