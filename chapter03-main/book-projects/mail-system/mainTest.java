public class mainTest {
    public static void main(String[] args) {
        // Create Mail server
        MailServer server1 = new MailServer();

        // Create Mail Clients
        MailClient user1 = new MailClient(server1, "User1");
        MailClient user2 = new MailClient(server1, "User2");

        // Send mail from user1 to user2
        user1.sendMailItem("User2", "Test Message", "Test Subject");

        // Print first Message from user2
        user2.printNextMailItem();
    }
}
