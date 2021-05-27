package pricing.Entities.DiscountEntities;

/**
 * Represents all possible types of offers
 * @author natma
 *
 */
public interface Offer {

	/**
	 * The condition to fill up the discount (number of product required)
	 */
	Integer getLimit();
	
	/**
	 * Return the amount of the discount;
	 * @return
	 */
	double getDiscount(final double price);
	
}
