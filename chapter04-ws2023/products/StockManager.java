import java.util.ArrayList;
import java.util.Iterator;
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        // Iterate through the stock List and check if there is already a Produckt with the same id as the 
        // given object Product item
        // With Iterator<>
        Iterator<Product> it = stock.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getID() == item.getID()) {
                System.out.println("Product with ID " + item.getID() + " already exists");
            } else {
                stock.add(item);
            }
        }

        // for (Product product : stock) {
        //     if (product.getID() == item.getID()) {
        //     }
        // }
    }

    public void doWhileMethod(int i, int j) {
        int counter = i; // Start from i to j
        do {
            System.out.println(counter);
            counter++;
        } while (counter <= j);
    }
    
    public Product findProduct(String name) {
        for (Product product : stock) {
            // If product name matches the given name return the product object
            if (product.getName() == name) {
                return product;
            }
        }
        // If no product with the given name is found return null
        return null;
    }
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        // // Look for the product id in the stock and increase its quanity by amount
        // for (Product product : stock) {
        //     if (product.getID() == id) {
        //         product.increaseQuantity(amount);
        //         System.out.println(amount + " Total Amount delivered");
        //     }
        // }

        stock.get(id).increaseQuantity(amount);
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        // Find product object by id and return it else return null if not found
        for (Product product : stock) {
            if (product.getID() == id) {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int remaining = stock.get(id).getQuantity();
        return remaining;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        // Iterate through the product objects stored in the stock list and print the details
        for (Product product : stock) {
            System.out.println(product.toString());
        }
    }

    public void printBelowThreshold(int threshold) {
        // Check if product object quantity is below threshold and iterate to next
        for (Product product : stock) {
            if (product.getQuantity() < threshold) {
                System.out.println(product.getName() + " is below the threshold");
            }
        }
    }
}
