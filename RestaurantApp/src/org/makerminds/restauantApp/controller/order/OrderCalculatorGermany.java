package org.makerminds.restauantApp.controller.order;

import org.makerminds.restauantApp.model.order.OrderItemSize;

public class OrderCalculatorGermany extends AbOrderCalculato{
	
	private final double VAT_RATE = 0.19;

	protected double getSizeRateAmount(OrderItemSize orderItemSize) {
		switch(orderItemSize) {
		case SMALL: return 0.8;
		case MEDIUM: return 1;
		case LARGE: return 1.25;
		case XXL: return 1.3;
		default:
			System.out.println("No valid order item size" + orderItemSize);
		return 0.0;}
	}
	
	protected double getVatRate() {
		return VAT_RATE;
	}
}
