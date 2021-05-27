package pricing.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Represent the list of OfferProduct, a bit like a dbb
 * @author natma
 *
 */
public class OfferProductService {
	
	private static List<OfferProduct> listOfferProducts = new LinkedList<OfferProduct>();
	
	/**
	 * Represents a list of different product type which has a discount program associated
	 */
	private static Set<String> setProductsType = new HashSet<String>();
	
	public static void add(final OfferProduct offerProduct) {
		listOfferProducts.add(offerProduct);
		setProductsType.add(offerProduct.getProduct().getName());
	}
	
	/**
	 * Return if the given product has an offer and the dedicated OfferProduct object if so
	 * @param product
	 * @return
	 */
	public static OfferProduct getOfferForProduct(final String product) {
		List<String> listProductsType = new ArrayList<String>(setProductsType);
		Object obj = product;
		Integer indexProductOffer = listProductsType.indexOf(obj);
		if (indexProductOffer != -1) {
			return listOfferProducts.get(indexProductOffer);
		}		
		return null;
	}
	
}
