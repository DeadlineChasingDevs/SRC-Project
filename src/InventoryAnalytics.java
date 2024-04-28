import java.util.ArrayList;
import java.util.List;

public class InventoryAnalytics {
	private double revenue;
	private double profits;
	private double expenses;
	private List<Product> inventory;
	private double valInventory;	// amount spent on inventory
	private double turnoverRate;

	public InventoryAnalytics() {
		this.profits = 0.0;
		this.inventory = new ArrayList<>();
		this.valInventory = 0.0;
	}

	public double getRevenue() {
		return revenue;
	}

	public double getProfits() {
		return profits;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public void calcProfits() {
		profits = revenue - expenses;
	}

	public void addProduct(Product product) {
		inventory.add(product);
	}

	public void removeProduct(Product product) {
		inventory.remove(product);
	}

	public void getInventory() {
		for(Product product : inventory) {
			System.out.println("Item: " + product.getName());
			System.out.println("Stock: " + product.getQuantity());
			System.out.println("Price: $" + product.getSellPrice());
			System.out.println();
		}
	}

	public void sellItem(Product product, int numPurchased) {
		product.setQuantity(product.getQuantity() - numPurchased);
		product.setSold(product.getSold() + numPurchased);
		revenue += product.getSellPrice();
	}

	public double getValInventory() {
		return valInventory;
	}

	public double getTurnoverRate() {
		return turnoverRate;
	}

	public void calcValInventory() {
		for(Product product : inventory) {
			valInventory += product.getQuantity() * product.getAmtInvested();
		}

	}

	public void calcTurnoverRate() {
		double x = 0.0;
		for(Product product : inventory) {
			x += product.getSold() * product.getSellPrice();
		}
		turnoverRate = x / valInventory;
	}

}
