package org.makerminds.restauantApp.model;

public class Drink extends Product {

	private boolean sugarfree;

	public Drink(int productId, String name, double productPrice, boolean sugarfree){
		this(productId, name, productPrice);
		this.sugarfree = sugarfree;
	}
	public Drink(int productId, String name, double productPrice) {
		setProductId(productId);
		setName(name);
		setProductPrice(productPrice);;
	}
	public boolean isSugarfree() {
		return sugarfree;
	}
	public void setSugarfree(boolean sugarfree) {
		this.sugarfree = sugarfree;
	}
	
	
}
