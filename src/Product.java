
public class Product {
	private String name;
	private int quantity;
	private int numSold;
	private double sellPrice;	// unit sell price
	private double amtInvested;	// unit cost, how much to produce
	private int daysUntilExpiration;

	public Product(String name, int quantity, int numSold, double sellPrice, double amtInvested, int daysUntilExpiration) {
			this.name = name;
			this.quantity = quantity;
			this.numSold = numSold;
			this.sellPrice = sellPrice;
			this.amtInvested = amtInvested;
			this.daysUntilExpiration = daysUntilExpiration;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSold() {
		return numSold;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public double getAmtInvested() {
		return amtInvested;
	}

	public int getExpiration() {
		return daysUntilExpiration;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setSold(int numSold) {
		this.numSold = numSold;
	}	
	
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public void setAmtInvested(double amtInvested) {
		this.amtInvested = amtInvested;
	}

	// manually set expiration
	public void setExpiration(int daysUntilExpiration) {
		this.daysUntilExpiration = daysUntilExpiration;
	}

	// decrement expiration based on days passed
	public void updateExpiration(int daysPassed) {
		if(daysPassed > daysUntilExpiration)
			daysUntilExpiration = daysUntilExpiration - daysPassed;
		else
			daysUntilExpiration = 0;
	}

	@Override
	public String toString() {
		return	"Product: " + name +
				"\nIn Stock: " + quantity + 
				"\nNumber Sold: " + numSold +
				"\nPrice: " + sellPrice + 
				"\nDay(s) Until Expiration: " + daysUntilExpiration + "\n";
	}

}
