package org.makerminds.restauantApp;

import org.makerminds.restauantApp.controller.LocationMenager;
import org.makerminds.restauantApp.controller.MenuPrinter;
import org.makerminds.restauantApp.controller.order.AbOrderCalculato;
import org.makerminds.restauantApp.controller.order.OrderCalculatorAL;
import org.makerminds.restauantApp.controller.order.OrderCalculatorGermany;
import org.makerminds.restauantApp.controller.order.OrderMenager;
import org.makerminds.restauantApp.controller.order.OrderPrinter;
import org.makerminds.restauantApp.enums.ApplicationMode;
import org.makerminds.restauantApp.enums.Location;
import org.makerminds.restauantApp.model.Client;
import org.makerminds.restauantApp.model.Menu;
import org.makerminds.restauantApp.model.Restaurant;
import org.makerminds.restauantApp.model.order.Order;
import org.makerminds.restauantApp.model.order.OrderAmount;

public class RestaurantApp {
	private static Location selectedLocation;

	public static void main(String[] args) {

		String applicationModeArgument = args[0];
		ApplicationMode selectApplicationMode = getSlectedApplicationMode(applicationModeArgument);

		String locationString = args[1];
		selectedLocation = LocationMenager.getLocationFromString(locationString);

		switch(selectApplicationMode) {
		case ORDER :
			runOrderProccess();
			break;
		case TABLE_REZERVATION:
			runTableReservationProccess();
			break;
		default:
			System.err.println("[Error] No valid application mode provided.");
		}

	}

	private static ApplicationMode getSlectedApplicationMode(String applicationModeArgument) {
		for(ApplicationMode applicationMode : ApplicationMode.values()) {
			if(applicationMode.name().equals(applicationModeArgument))
			
				return applicationMode;
		}
		System.err.println("Provided application mode arg not suported");
		return null;
	}

	private static void runTableReservationProccess() {
		System.out.println("Table reserved successfully!");
	}

	private static void runOrderProccess() {
		Restaurant restaurant = new Restaurant("Route 66", "Te Heroinat, Prishtin");

		//Client object
		Client client = new Client("Filan","(+333) 360 245 545");

		Menu menu = new Menu();
		MenuPrinter menuPrinter = new MenuPrinter();
		menuPrinter.printMenu(menu);

		OrderMenager orderMenager = new OrderMenager();
		Order order = orderMenager.createOrder(menu);
		orderMenager.getOrders().add(order);

		//order object
		AbOrderCalculato calculator = getOrderCalculator();

		OrderAmount orderAmount = calculator.calculateOrderAmount(order);

		OrderPrinter orderPrinter = new OrderPrinter();
		orderPrinter.printOrderInfo(restaurant, client, order, orderAmount);
	}

	private static AbOrderCalculato getOrderCalculator() {
		switch (selectedLocation) {
		case ALBANIA:
			return new OrderCalculatorAL();
		case GERMANY:
			return new OrderCalculatorGermany();
		default:
			System.err.println("Unexpected value: ");
		return null;}

	}
}
