import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    // Close the auction and print the details of all lots
    public void close() {
        // Itarete through the lots and get the details
        for (Lot lot : lots) {
            Bid temp = lot.getHighestBid();
            if (temp == null) {
                System.out.println("No bids on Lot Number: " + lot.getNumber());                
            } else {
                System.out.println("Lot number: " + lot.getNumber());
                System.out.println("Lot Description: " + lot.getDescription());
                System.out.println("Highest bidder name: " + lot.getHighestBid().getBidder().getName());
                System.out.println("Sold for: " + lot.getHighestBid().getValue());
            }
        }

    }

    public ArrayList<Lot> getUnsoldLots() {
        // Create a ArrayList that will contain the unsold Lots 
        ArrayList<Lot> unsoldLots = new ArrayList<>();
        // Itarete through the lots and check if there is a bidder object, if not then add this 
        // unsold lot to the new ArrayList and remove it from the lots ArrayList to bid on
        for (Lot lot : lots) {
            // If there is no Bidder object, then add this lot to the unsoldLots list
            if (lot.getHighestBid() == null) {
                unsoldLots.add(lot);
                System.out.println(unsoldLots);
            }
        }
        return unsoldLots;
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     * Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return The Lot with the given number, or null if
     * there is no such lot.
     */
    public Lot removeLot(int number) {
        Lot returnLot = null;
        // Use a iterator to iterate through the lots ArrayList and check for the lot number
        // If the lot number is found, then remove it from the lots ArrayList and return it
        for (Lot lot : lots) {
            if (lot.getNumber() == number) {
                returnLot = lot;
                lots.remove(lot);
            }
        }
        return returnLot;
    }
    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber) {
        for (Lot lot : lots) {
            if (lot.getNumber() == lotNumber) {
                return lot;
            }
        }
        System.out.println("Lot number: " + lotNumber + " does not exist.");
        return null;
    }
}
