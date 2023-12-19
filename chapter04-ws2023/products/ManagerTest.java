public class ManagerTest {
    public static void main(String[] args) {
        // Initialize a new Manager and add some products
        StockManager manager = new StockManager();
        Product investment1 = new Product(0, "Gold");
        Product investment2 = new Product(1, "Silver");

        // Add fish to the StockManager
        manager.addProduct(investment1);
        manager.addProduct(investment2);

        manager.delivery(0, 100);
        manager.delivery(0, 500);
        manager.delivery(1, 5000);

        System.out.println(investment1.getQuantity());
        System.out.println(manager.numberInStock(0));
        System.out.println(manager.numberInStock(1));

        manager.printProductDetails();
        manager.printBelowThreshold(5000);
    }
}
