package pricing.Entities.DiscountEntities;

/**
 * Represents the situation where there is a certain discount when buying multiple item of same type
 * @author natma
 *
 */
public class PackagePrice implements Offer {
	
	/**
	 * Total discount on this offer
	 */
	private double amount;
	
	/**
	 * The condition to fill up the discount (number of product required)
	 */
	private Integer limit;
	
	/**
	 * Constructor of PackagePrice
	 * @param limit
	 * @param price
	 */
	public PackagePrice(final Integer limit, final double price) {
		this.amount = price;
		this.limit = limit;
	}

	/**
	 * Allow the system to calculate the total amount of the discount based on product price
	 * @param price
	 * @return
	 */
	@Override
	public double getDiscount(final double price) {
		return amount;
	}
	
	@Override
	public Integer getLimit() {
		return this.limit;
	}
	
}
