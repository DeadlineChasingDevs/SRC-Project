/**
 * Represents a product with its attributes such as name, quantity, sell price, etc.
 */

public class Product {
	private String name;
	private int quantity;
	private int numSold;
	private double sellPrice; // unit sell price
	private double amtInvested; // unit cost, how much to produce
	private int daysUntilExpiration;

	/**
	 * Constructs an object product given these attributes.
	 * 
	 * @param name
	 * @param quantity
	 * @param numSold
	 * @param sellPrice
	 * @param amtInvested
	 * @param daysUntilExpiration
	 */
	public Product(String name, int quantity, int numSold, double sellPrice, double amtInvested, int daysUntilExpiration) {
		this.name = name;
		this.quantity = quantity;
		this.numSold = numSold;
		this.sellPrice = sellPrice;
		this.amtInvested = amtInvested;
		this.daysUntilExpiration = daysUntilExpiration;
	}

	/**
	 * Gets name of product.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets stocked quantity of products.
	 * 
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Gets number of an item sold.
	 * 
	 * @return
	 */
	public int getSold() {
		return numSold;
	}

	/**
	 * Gets pricetag on product.
	 * 
	 * @return
	 */
	public double getSellPrice() {
		return sellPrice;
	}

	/**
	 * Gets the amount invested in a product.
	 * 
	 * @return
	 */
	public double getAmtInvested() {
		return amtInvested;
	}

	/**
	 * Gets time in days until expiration.
	 * 
	 * @return
	 */
	public int getExpiration() {
		return daysUntilExpiration;
	}
	
	/**
	 * Sets stocked quantity of products.
	 * 
	 * @return
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets number of an item sold.
	 * 
	 * @return
	 */
	public void setSold(int numSold) {
		this.numSold = numSold;
	}

	/**
	 * Sets pricetag on product.
	 * 
	 * @return
	 */
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	/**
	 * Sets the amount invested in a product.
	 * 
	 * @return
	 */
	public void setAmtInvested(double amtInvested) {
		this.amtInvested = amtInvested;
	}

	/**
	 * Manually sets days until expiration.
	 * 
	 * @param daysUntilExpiration
	 */
	public void setExpiration(int daysUntilExpiration) {
		this.daysUntilExpiration = daysUntilExpiration;
	}

	/**
	 * Decrement expiration based on days passed.
	 * 
	 * @param daysPassed
	 */
	public void updateExpiration(int daysPassed) {
		if (daysPassed > daysUntilExpiration)
			daysUntilExpiration = daysUntilExpiration - daysPassed;
		else
			daysUntilExpiration = 0;
	}

	/**
	* Returns a string representation of the product.
	* 
	* The string representation includes the name of the product,
	* the quantity in stock, the number of units sold, the selling
	* price per unit, and the number of days until expiration.
	*
	* @return
	*/
	@Override
	public String toString() {
		return "Product: " + name +
				"\nIn Stock: " + quantity +
				"\nNumber Sold: " + numSold +
				"\nPrice: " + sellPrice +
				"\nDay(s) Until Expiration: " + daysUntilExpiration + "\n";
	}

}
