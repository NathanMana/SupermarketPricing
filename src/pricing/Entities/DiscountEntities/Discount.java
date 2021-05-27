package pricing.Entities.DiscountEntities;

/**
 * A classic discount
 * -75% on it for example
 * @author natma
 *
 */
public class Discount implements Offer {

	/**
	 * Represents the amount of the discount (it is a ratio)
	 */
	private double amount;
	
	/**
	 * The condition to fill up the discount (number of product required)
	 */
	private Integer limit = 1;
	
	/**
	 * Constructor of Discount
	 * @param amount
	 * @throws Exception
	 */
	public Discount(final double amount) throws Exception {
		if (amount >= 1 && amount <= 0) {
			throw new Exception();
		}
		this.amount = amount;
	}

	/**
	 * Allow the system to calculate the total amount of the discount based on product price
	 * @param price
	 * @return
	 */
	@Override
	public double getDiscount(final double price) {
		return amount*price;
	}
	
	/**
	 * Return the limit of product that can benefits from this discount
	 */
	@Override
	public Integer getLimit() {
		return this.limit;
	}
	
	
}
