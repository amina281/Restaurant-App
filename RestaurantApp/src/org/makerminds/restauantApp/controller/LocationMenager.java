package org.makerminds.restauantApp.controller;

import org.makerminds.restauantApp.enums.Location;

public class LocationMenager {

	public static Location getLocationFromString(String locationString) {
		for(Location location : Location.values()) {
			if(location.name().equals(locationString)) {
				return location;
			}
		}
		System.err.println("No location could be found from given locati" + locationString);
		return null;
	}
}
