import java.util.Scanner;

// Your Star Wars first name:
// 1.  Take the first three letters of your last name.
// 2.  Add to that the first two letters of your first name.
// Your Star Wars last name:
// 1.  Take the first two letters of your mother’s maiden name.
// 2.  Add to this the first three letters of the name of the town or city where you were born.
// And now your task: Create a new BlueJ project named star-wars. In it create 
// a class named NameGenerator. This class should have a method named 
// generateStarWarsName that generates a Star Wars name, following the 
// method described above. You will need to find out about a method of the 
// String class that generates a substring


public class NameGenerator {

    private String firstName, lastName, motherMaidenName, birthCity;
    private Scanner scanner;

    public NameGenerator() {
        scanner = new Scanner(System.in);
    }
    
    public void generateStarWarsName() {
        // Generate Star Wars first name
        String starWarsFirstName = lastName.substring(0, 3) + firstName.substring(0, 2);

        // Generate Star Wars last name
        String starWarsLastName = motherMaidenName.substring(0, 2) + birthCity.substring(0, 3);

        // Combine first and last names
        System.out.println("Your Star Wars Name is: " + starWarsFirstName + " " + starWarsLastName);
    }

    public void getUserInput() {
        System.out.print("Please enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Please enter your last name: ");
        lastName = scanner.nextLine();

        System.out.print("Please enter your mothers maiden name: ");
        motherMaidenName = scanner.nextLine();

        System.out.print("Please enter your birth city: ");
        birthCity = scanner.nextLine();
    }

    
    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.getUserInput();
        nameGenerator.generateStarWarsName();
        
    }
}
