public class AuctionTester {
    public static void main(String[] args) {
        // Create a new Auction object
        Auction auction = new Auction();
        // Create a new Lot object
        auction.enterLot("Mon Lisa");
        auction.enterLot("Car");
        auction.enterLot("House");
        // Create a two Person objects
        Person person = new Person("Franz");
        Person person2 = new Person("Hans");

        // Franz bids 100 for Mona Lisa
        auction.makeABid(1, person, 100);
        // Hans bids 200 for the House
        auction.makeABid(3, person2, 200);

        System.out.println("Closing Auction");
        auction.close();
        auction.getUnsoldLots();
    }
}
