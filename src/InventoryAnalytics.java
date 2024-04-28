import java.util.ArrayList;
import java.util.List;

public class InventoryAnalytics {
	private double revenue;
	private double expenses;
	private List<Product> inventory;

	public InventoryAnalytics() {
		this.inventory = new ArrayList<>();
	}

	public double getRevenue() {
		return revenue;
	}

	public double getProfits() {
		return revenue - expenses;
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

	public void addProduct(Product product) {
		inventory.add(product);
	}

	public void removeProduct(Product product) {
		inventory.remove(product);
	}

	public void getInventory() {
		for (Product product : inventory) {
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
		double valInventory = 0.0;

		for (Product product : inventory) {
			valInventory += product.getQuantity() * product.getAmtInvested();
		}
		return valInventory;
	}

	public double getTurnoverRate() {
		double soldGoodsValue = 0.0;
		double turnoverRate = 0.0;

		for (Product product : inventory) {
			soldGoodsValue += product.getSold() * product.getSellPrice();
		}
		return turnoverRate = soldGoodsValue / valInventory;
	}
}