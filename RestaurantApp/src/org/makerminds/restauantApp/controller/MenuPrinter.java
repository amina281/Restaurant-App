package org.makerminds.restauantApp.controller;
import java.util.Map.Entry;

import org.makerminds.restauantApp.model.Menu;
import org.makerminds.restauantApp.model.Product;

public class MenuPrinter {

	public void printMenu(Menu menu) {
		System.out.println("-------------------MENU------------------");
		for(Entry<Integer, Product> menuEntry : menu.getMenuItems().entrySet()) {
			Product menuItem = menuEntry.getValue();
			System.out.println(menuItem.getProductId() + ". " + menuItem.getName() + " | " + menuItem.getProductPrice() + " $");
		}

		System.out.println("-----------------------------------------");
	}
}
