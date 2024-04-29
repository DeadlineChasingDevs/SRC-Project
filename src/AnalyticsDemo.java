/**
 * This class demonstrates the functionality of the InventoryAnalytics system.
 * It creates instances of products, adds them to the inventory, performs
 * sales operations, and calculates various analytics metrics.
 */
public class AnalyticsDemo {
    /**
     * The main method demonstrates the functionality of the InventoryAnalytics system.
     * It creates an instance of the InventoryAnalytics class, adds products to the inventory,
     * performs sales operations, and prints various analytics metrics.
     * @param args the command-line arguments (not used in this demo)
     * @throws Exception if there is an error during execution
     */
    public static void main(String[] args) throws Exception {
        InventoryAnalytics analytics = new InventoryAnalytics();

        Product prod1 = new Product("Tomato", 100, 0, 10.00, 8.00, 30);
        Product prod2 = new Product("Corn", 50, 0, 20.00, 15.00, 60);
        analytics.setExpenses(50.0);

        analytics.addProduct(prod1);
        analytics.addProduct(prod2);

        analytics.getInventory();
        System.out.println("Inventory Value: $" + analytics.getValInventory());

        analytics.sellItem(prod1, 70);
        analytics.sellItem(prod2, 20);

        System.out.println("Total Revenue: $" + analytics.getRevenue());
        System.out.println("Total Profits: $" + analytics.getProfits());
        System.out.println("Turnover Rate: " + analytics.getTurnoverRate());

    }
}
