import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    ArrayList<Membership> members, winnerList;
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        members = new ArrayList<Membership>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        members.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        int count = members.size();
        return count;
    }

    public void pickOneWinner() {
        // Generate a random number
        Random random = new Random();
        int randomMemberIndex = random.nextInt(members.size());
        System.out.println("Random Member at Index: " + randomMemberIndex + " chosen");
    }

    public List<Membership> createMemberPool() {
        // Create a List memberPool with a copy of all current Members
        List<Membership> memberPool = new ArrayList<>();
        // Copy each memberObject to the memberPool
        for (Membership m : members) {
            memberPool.add(m);
        }
        return memberPool;
    }

    // **
    // * Remove from the club’s collection all members who  
    // * joined in the given month, 
    // *  and return them stored in a separate collection object.
    // * @param month The month of the membership.
    // * @param year The year of the membership.
    // *  @return The members who joined in the given month and year.
    // *
    public ArrayList<Membership> purge(int month, int year) {
        if (month > 0 && month <= 12) {
            // create a iterator Iterator<Membership> it = members.iterator(); and loop 
            // through the members and delete the members with the given month and year
            Iterator<Membership> it = members.iterator();
            while (it.hasNext()) {
                Membership m = it.next();
                if (m.getMonth() == month && m.getYear() == year) {
                    it.remove();
                }
            }
            return members;
        } else {
            System.out.println("Error: Enter a month 1-12");
            return members;
        }
    }


    public void pickMultipleWinners(int numberOfWinners) {
        // Create a List memberPool with a copy of all current Member objects
        List<Membership> memberPool = createMemberPool();
        // Create a List winnerList to store the winners
        winnerList = new ArrayList<>();
        // Generate a random number
        Random random = new Random();
        // Loop numberOfWinners times
        for (int i = 0; i < numberOfWinners; i++) {
            // Generate a random number
            int randomMemberIndex = random.nextInt(memberPool.size());
            // Add the member at the random index to the winnerList
            winnerList.add(memberPool.get(randomMemberIndex));
            // Remove the member at the random index from the memberPool
            memberPool.remove(randomMemberIndex);
        }
        // Print the winnerList
        System.out.println("The winners are: ");
        // Loop through the winnerList
        for (Membership m : winnerList) {
            // Print the name of each member
            System.out.println(m.getName());
        }
    }
}
