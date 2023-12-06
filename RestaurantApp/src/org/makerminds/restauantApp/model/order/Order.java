package org.makerminds.restauantApp.model.order;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<OrderItem> orderItems =  new ArrayList<>();
	
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

}
