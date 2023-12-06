package org.makerminds.restauantApp.controller.order;

import java.util.ArrayList;

import org.makerminds.restauantApp.model.Product;
import org.makerminds.restauantApp.model.order.Order;
import org.makerminds.restauantApp.model.order.OrderAmount;
import org.makerminds.restauantApp.model.order.OrderItem;
import org.makerminds.restauantApp.model.order.OrderItemSize;

public abstract class AbOrderCalculato {

	public double calculateTotalOrderAmount(Order order) {
		
		ArrayList<OrderItem> orderItems = order.getOrderItems();
		
		double totalOrderAmount = 0.0;
		
		for(OrderItem orderItem : orderItems) {
			totalOrderAmount += calculateOrderItemPrice(orderItem);
		}
		
		return totalOrderAmount;
	}
	
	private double calculateOrderItemPrice(OrderItem orderItem) {
		double sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
		
		if(sizeRateAmount == 0.0) {
			return 0.0;
		}
		
		Product product = orderItem.getProduct();
		double totalOrderItemPriceSingle = product.getProductPrice() * sizeRateAmount;
		orderItem.setOrderItemPrice(totalOrderItemPriceSingle);
		return totalOrderItemPriceSingle * orderItem.getQuantity();
	}
	
	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
		
		return totalOrderAmount * getVatRate() ;
	}
	
	public OrderAmount calculateOrderAmount(Order order) {
		
		double totalOrderAmount = calculateTotalOrderAmount(order);
		double totalOrderAmountVAT = calculateTotalOrderAmountVAT(totalOrderAmount);
		double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT;
		
		OrderAmount orderAmount = new OrderAmount(totalOrderAmount, totalOrderAmountVAT, totalOrderAmountWithVAT);
		
		return orderAmount;
	}
	protected abstract double getVatRate();
	protected abstract double getSizeRateAmount(OrderItemSize orderItemSize);
	

}
