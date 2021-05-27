package pricing.Entities;

import java.util.LinkedList;
import java.util.List;

/**
 * It is the product container, a bit like a shopping basket
 * @author natma
 *
 */
public class Basket {

	/**
	 * The list of products
	 */
	private List<Product> listProducts;
	
	/**
	 * The total price of the basket 
	 */
	private double totalAmount = 0;
	
	/**
	 * The waiting list of offer, offer in this list are not available for discount
	 */
	private List<OfferProduct> listWaitingOffer;
	
	/**
	 * Corresponding to listWaitingOffer variable
	 * Count the iteration
	 */
	private List<OfferProductCounter> listWaitingOfferCounter;

	/**
	 * Basket Constructor
	 */
	public Basket() {
		listProducts = new LinkedList<Product>();
		listWaitingOffer = new LinkedList<OfferProduct>();
		listWaitingOfferCounter = new LinkedList<OfferProductCounter>();
	}
	
	/**
	 * Allows us to add an item in our basket
	 * Add price to total amount
	 * @param product
	 */
	public void add(final Product product) {
		totalAmount += product.getPrice();
		listProducts.add(product);
	}
	
	/**
	 * Allows to remove an item of the basket
	 * @param product
	 */
	public void remove(final Product product) {
		listProducts.remove(product);
	}
	
	public Product getProduct(final Integer index) {
		return this.listProducts.get(index);
	}
	
	/**
	 * Determine the total price of the basket with discount applied
	 * @return
	 */
	public double calcTotalAmount() {
		manageDiscountOffers();		
		for (OfferProductCounter offerProductCounter : listWaitingOfferCounter) {
			if (!offerProductCounter.isComplete()) {
				continue;
			}
			
			totalAmount -= offerProductCounter.getOfferProduct().getAmountReduction();	
		}	
		return totalAmount;
	}
	
	/**
	 * Check for each product if a discount program exist
	 */
	private void manageDiscountOffers() {
		for (Product product : listProducts) {
			OfferProduct offerProduct = OfferProductService.getOfferForProduct(product.getName());
			if (offerProduct == null) {
				continue;
			}
			
			// We check if we already have an instance of the object in waiting room
			Integer indexWaitingRoom =  listWaitingOffer.indexOf(offerProduct);
			if (indexWaitingRoom != -1) {
				OfferProductCounter offerCounter = listWaitingOfferCounter.get(indexWaitingRoom);
				if (!offerCounter.isComplete()) {
					listWaitingOfferCounter.get(indexWaitingRoom).addIteration();
					continue;
				}	
			}
			
			listWaitingOfferCounter.add(new OfferProductCounter(offerProduct));
			listWaitingOffer.add(offerProduct);
			
		}	
	}
	
}
