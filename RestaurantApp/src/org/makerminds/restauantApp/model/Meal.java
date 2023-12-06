package org.makerminds.restauantApp.model;

public class Meal extends Product{
	
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Meal(int productId, String name, double productPrice, String description){
		this(productId, name, productPrice);
		this.description = description;
	}
	public Meal(int productId, String name, double productPrice) {
		setProductId(productId);
		setName(name);
		setProductPrice(productPrice);;
	}

}
