import java.util.ArrayList;
import java.util.List;

/**
 * This class calculates analytics for inventory management, including revenue, profits,
 * expenses, and inventory turnover rate.
 */
public class InventoryAnalytics {
	private double revenue;
	private double expenses;
	private List<Product> inventory;

	/**
	 * Constructor creates new inventory.
	 */
	public InventoryAnalytics() {
		this.inventory = new ArrayList<>();
	}
	
	/**
	 * Gets total revenue, needs to be set and/or calculated first
	 * 
	 * @return
	 */
	public double getRevenue() {
		return revenue;
	}

	/**
	 * Calculates profits based on revenue and total expenses.
	 */
	public double getProfits() {
		return revenue - expenses;
	}

	/**
	 * Gets expenses on inventory, needs to be set
	 * 
	 * @return
	 */
	public double getExpenses() {
		return expenses;
	}

	/**
	 * Sets expenses on inventory
  	 * 
	 * @return
	 */
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	/**
	 * Sets total revenue
	 * 
	 * @return
	 */
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	/**
	 * Adds a product to ArrayList inventory
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		inventory.add(product);
	}

	/**
	 * Removes a product from ArrayList inventory
	 * 
	 * @param product
	 */
	public void removeProduct(Product product) {
		inventory.remove(product);
	}

	/**
	 * Prints current inventory. Gives items, number of stock, pricetag.
	 */
	public void getInventory() {
		for (Product product : inventory) {
			System.out.println("Item: " + product.getName());
			System.out.println("Stock: " + product.getQuantity());
			System.out.println("Price: $" + product.getSellPrice());
			System.out.println();
		}
	}
	
	/**
	 * Sells a specified number of a specific product.
	 * Updates appropriate values of that product and adds to revenue.
	 * 
	 * @param product
	 * @param numPurchased
	 */
	public void sellItem(Product product, int numPurchased) {
		product.setQuantity(product.getQuantity() - numPurchased);
		product.setSold(product.getSold() + numPurchased);
		revenue += product.getSellPrice();
	}

	/**
	 * Calculates value spent on inventory.
	 */
	public double getValInventory() {
		double valInventory = 0.0;

		for (Product product : inventory) {
			valInventory += product.getQuantity() * product.getAmtInvested();
		}
		return valInventory;
	}

	/**
	 * Calculates turnover rate.
	 */
	public double getTurnoverRate() {
		double soldGoodsValue = 0.0;

		for (Product product : inventory) {
			soldGoodsValue += product.getSold() * product.getSellPrice();
		}
		return soldGoodsValue / getValInventory(); // turnover rate
	}

	/**
	 * Retrieves a product from the inventory by its name.
	 * 
	 * This method searches the inventory for a product with the specified name.
	 * If found, it returns the product; otherwise, it returns null.
	 *
	 * @param product
	 * @return
	 */
	public Product getProduct(String product) {
		int next = 0;
		boolean found = false;

		while (next < inventory.size() && !found) {
			Product nextItem = inventory.get(next);

			if (product.equals(nextItem.getName())) {
				found = true;
				return nextItem;
			}
			next++;
		}
		return null;
	}
}
