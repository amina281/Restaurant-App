package org.makerminds.restauantApp.controller.order;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.makerminds.restauantApp.model.Client;
import org.makerminds.restauantApp.model.Product;
import org.makerminds.restauantApp.model.Restaurant;
import org.makerminds.restauantApp.model.order.Order;
import org.makerminds.restauantApp.model.order.OrderAmount;
import org.makerminds.restauantApp.model.order.OrderItem;

public class OrderPrinter {

	public void printOrderInfo(Restaurant restaurant,Client client, Order order, OrderAmount orderAmount) {

		ArrayList<OrderItem> orderItems = order.getOrderItems();
		printOrderInfoHeader(client);
		
		for(OrderItem orderItem : orderItems) {
			printOrderItemInfo(orderItem);
		}
		
		printOrderFooter(restaurant, orderAmount);
		
	}

	private void printOrderFooter(Restaurant restaurant, OrderAmount orderAmount, int vatRate) {
		System.out.println("-----------------------------------------");
		System.out.println("THe total price of the order is: ");
		System.out.println("SUB TOTAL: " + convertDoubleToString(orderAmount.getTotalOderAmount()) + "$");
		System.out.println("VAT " + vatRate + "%: " + convertDoubleToString(orderAmount.getTotalOrderAmountVAT()) + "$");
		System.out.println("TOTAL: " + convertDoubleToString(orderAmount.getTotalOrderAmountWithVAT()) + "$");
		
		System.out.println("-----------------------------------------");
		System.out.println(restaurant.getName() + " in " + restaurant.getAddress());
	}

	private void printOrderItemInfo(OrderItem orderItem) {
		Product product = orderItem.getProduct();
		double totalOrderItemPrice = orderItem.getOrderItemPrice() * orderItem.getQuantity();
		System.out.println(orderItem.getQuantity() + "x | " + product.getProductId() + ". " + product.getName() + " | "  + convertDoubleToString(orderItem.getOrderItemPrice()) + " | " + convertDoubleToString(totalOrderItemPrice)+" $" + " (" + orderItem.getOrderItemSize() + ")");
	}

	private void printOrderInfoHeader(Client client) {
		System.out.println("-----------------------------------------");

		System.out.println("Order from: " + client.getName());
		System.out.println("Contact number: " + client.getPhoneNr());
	}
	
	private String convertDoubleToString(double amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		return decimalFormat.format(amount);
	}
}
