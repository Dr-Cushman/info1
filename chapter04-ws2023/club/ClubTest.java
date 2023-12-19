public class ClubTest {
    public static void main(String[] args) {
        Club club1 = new Club();
        Membership membership = new Membership("Franz", 2, 2024);
        Membership membership2 = new Membership("Jana", 3, 2023);
        Membership membership3 = new Membership("Heinrich", 1, 2023);
        Membership membership4 = new Membership("Ursula", 1, 2023);

        club1.join(membership);
        club1.join(membership2);
        club1.join(membership3);
        club1.join(membership4);
        
        System.out.println(club1.purge(3, 2023));
    }
}
