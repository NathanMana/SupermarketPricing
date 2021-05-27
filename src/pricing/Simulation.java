package pricing;

import java.util.Random;

import pricing.Entities.Basket;
import pricing.Entities.OfferProduct;
import pricing.Entities.OfferProductService;
import pricing.Entities.Product;
import pricing.Entities.DiscountEntities.Discount;
import pricing.Entities.DiscountEntities.Offer;
import pricing.Entities.DiscountEntities.PackagePrice;

/**
 * Simple simulation of the application
 * 
 * It seems to be very easy to add any form of discount program, 
 * the only thing to do is to add another class that implements Offer
 * and to associate product on this new program
 * 
 * @author natma
 *
 */
public class Simulation {
	
	public static void main(String[] args) {	
		// Product list creation
		Basket basket = createProductList(100);
		
		// Feeding the 'database'
		// We create a new offer
		Offer packagePrice = new PackagePrice(1, 10);
		// To the type of 4th product in our basket
		System.out.println("Discount on product of type : " + basket.getProduct(4).getName());
		OfferProduct assoc = new OfferProduct(basket.getProduct(4), packagePrice);
		OfferProductService.add(assoc);
		
		// And another one to the type of 1st product
		try {
			Offer discount = new Discount(0.50);
			System.out.println("Discount on product of type : " + basket.getProduct(1).getName());
			OfferProduct assoc2 = new OfferProduct(basket.getProduct(1), discount);
			OfferProductService.add(assoc2);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		
		System.out.println(basket.calcTotalAmount());

	}
	
	/**
	 * Allows to create a list of products with some duplicates
	 * @param max
	 * @return
	 */
	public static Basket createProductList(final Integer max) {
		
		Basket basket = new Basket();
		for (int i=0; i < max; i++) {
			try {
				basket.add(new Product(("RandomProduct" + generateIntBetweenRange(0, 10)), 12.0));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return basket;
		
	}
	
	/**
	 * Generate a random integer number in a given range
	 * @param min
	 * @param max
	 * @return
	 * @throws Exception
	 */
	public static Integer generateIntBetweenRange(final Integer min, final Integer max) throws Exception {
		 if (min >= max) {
			 throw new Exception();
		 }
		
		 Random r = new Random();
	     return r.nextInt((max - min) + 1) + min;
	}

}
