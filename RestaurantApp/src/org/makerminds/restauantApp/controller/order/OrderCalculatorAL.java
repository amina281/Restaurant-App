package org.makerminds.restauantApp.controller.order;

import org.makerminds.restauantApp.model.order.OrderItemSize;

public class OrderCalculatorAL extends AbOrderCalculato{
	
	private final double VAT_RATE = 0.18;

	protected double getSizeRateAmount(OrderItemSize orderItemSize) {
		switch(orderItemSize) {
		case SMALL: return 0.7;
		case MEDIUM: return 1;
		case LARGE: return 1.2;
		case XXL: return 1.25;
		default:
			System.out.println("No valid order item size" + orderItemSize);
		return 0.0;
		}
	}
	
	protected double getVatRate() {
		return VAT_RATE;
	}
}
