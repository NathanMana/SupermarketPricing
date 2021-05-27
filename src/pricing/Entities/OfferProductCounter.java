package pricing.Entities;

/**
 * Count the number of iteration of an offer product in a given basket
 * @author natma
 *
 */
public class OfferProductCounter {

	/**
	 * Count the number of iteration 
	 */
	private Integer counter = 0;
	
	/**
	 * A reference to OfferProduct
	 */
	private OfferProduct offerProduct;
	
	/**
	 * Indicates if our offer is complete and available for a discount
	 */
	private boolean isComplete = false;
	
	/**
	 * OfferProductCounter Constructor
	 * @param offerProduct
	 */
	public OfferProductCounter(final OfferProduct offerProduct) {
		this.offerProduct = offerProduct;
		addIteration();
	}
	
	/**
	 * Increment the counter
	 */
	public void addIteration() {
		counter++;
		if (counter >= offerProduct.getOffer().getLimit()) {
			this.isComplete = true;
		}
	}
	
	/**
	 * Method to check if counter is full
	 * @return
	 */
	public boolean isComplete( ) {
		return this.isComplete;
	}
	
	/**
	 * Send the offerProduct instance stored
	 * @return
	 */
	public OfferProduct getOfferProduct() {
		return offerProduct;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offerProduct == null) ? 0 : offerProduct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferProductCounter other = (OfferProductCounter) obj;
		if (offerProduct == null) {
			if (other.offerProduct != null)
				return false;
		} else if (!offerProduct.equals(other.offerProduct))
			return false;
		return true;
	}
	
	
	
}
