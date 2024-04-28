public class AnalyticsDemo {
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
