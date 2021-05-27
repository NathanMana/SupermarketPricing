package pricing.Entities;

import pricing.Entities.DiscountEntities.Offer;

/**
 * Represents assocation between Offer and Products
 * This class tells us if a product has a special offer or not
 * @author natma
 *
 */
public class OfferProduct {
	

	/**
	 * Object offer
	 */
	private Offer offer;
	
	/**
	 * Object product
	 */
	private Product product;
	
	/**
	 * Constructor of OfferProduct
	 * @param product
	 * @param offer
	 */
	public OfferProduct (final Product product, final Offer offer) {
		this.product = product;
		this.offer = offer;
	}

	
	public Product getProduct() {
		return product;
	}

	public Offer getOffer() {
		return offer;
	}

	public double getAmountReduction() {
		return offer.getDiscount(product.getPrice());
	}
	
}
