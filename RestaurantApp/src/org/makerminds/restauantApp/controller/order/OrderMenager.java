package org.makerminds.restauantApp.controller.order;

import java.util.ArrayList;

import org.makerminds.restauantApp.model.Menu;
import org.makerminds.restauantApp.model.Product;
import org.makerminds.restauantApp.model.order.Order;
import org.makerminds.restauantApp.model.order.OrderItem;
import org.makerminds.restauantApp.model.order.OrderItemSize;

public class OrderMenager {

	private ArrayList<Order>  orders = new ArrayList<>();
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public Order createOrder(Menu menu) {
		Order order = new Order();
		
		addOrderItem(order, menu.getMenuItems().get(100), OrderItemSize.XXL, 1);
		addOrderItem(order, menu.getMenuItems().get(101), OrderItemSize.LARGE, 1);
		addOrderItem(order, menu.getMenuItems().get(200), OrderItemSize.XXL, 1);
		addOrderItem(order, menu.getMenuItems().get(200), OrderItemSize.XXL, 2);
		
		return order;
	}

	private void addOrderItem(Order order, Product product, OrderItemSize orderItemSize, int quantity) {
		
		OrderItem orderItem = createOrderItem(product, orderItemSize, quantity);
		order.getOrderItems().add(orderItem);
	}

	private OrderItem createOrderItem(Product product, OrderItemSize orderItemSize, int quantity) {
		return new OrderItem(product, orderItemSize, quantity);
	}
	
}
