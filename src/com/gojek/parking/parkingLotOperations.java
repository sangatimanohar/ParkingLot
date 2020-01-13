package com.gojek.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class parkingLotOperations {

	static Map<Integer, ParkingSpot> parkingSpots = null;
	private static int slotCapacity;
	private static Set<Integer> freeSlots;

	public static void createParkingSlots(int noOfSlots) {

		parkingSpots = new HashMap<>();
		slotCapacity = noOfSlots;
		freeSlots = new HashSet<>();
		for (int i = 1; i <= noOfSlots; i++) {
			freeSlots.add(i);
		}
		System.out.println("Created a parking lot with " + noOfSlots + " slots");

	}

	/* Park the vehicle in a spot.Return false if failed. */

	public static void parkVehicle(String vehicleNum, String colour, int spotNumber) {

		try {

			if (slotCapacity > parkingSpots.size()) {
				spotNumber = freeSlots.iterator().next();
				Vehicle vehicle = new Vehicle();
				vehicle.setRegistrationNum(vehicleNum);
				vehicle.setColour(colour);
				ParkingSpot parkingSpot = new ParkingSpot();
				parkingSpot.setSpotNumber(spotNumber);
				parkingSpot.setVehicle(vehicle);
				parkingSpots.put(spotNumber, parkingSpot);
				freeSlots.remove(spotNumber);
				System.out.println("Allocated slot number:" + spotNumber);
			} else {
				System.out.println("Sorry, parking lot is full");
			}
		} catch (Exception e) {

			System.out.println("Error Occured While Processing the Requst..Please try after Some time...");

		}

	}

	/* Remove vehicle from spot, and notify level that a new spot is available */

	public static void removeVehicleBySlotNum(int slotNum) {

		ParkingSpot remove = parkingSpots.remove(slotNum);

		if (remove != null) {
			// availableSlots = availableSlots-parkingSpots.size();
			freeSlots.add(remove.getSpotNumber());
			System.out.println("Slot number " + remove.getSpotNumber() + " is free");
		} else {
			System.out.println("Unable to Remove Slot number " + remove.getSpotNumber());
		}

	}

	/* Display Parking Status */

	public static void displayParkingStatus() {

		System.out.println("Slot No." + "   " + "Registration No" + "   " + "Colour");
		parkingSpots.forEach((k, v) -> System.out.println((k + "          " + v.getVehicle().getRegistrationNum()
				+ "            " + v.getVehicle().getColour())));

	}

	/* registration_numbers_for_cars_with_colour White */

	public static void regNumByColour(String color) {

		// parkingSpots.entrySet().stream().filter(x->colour.equalsIgnoreCase(x.getValue().getVehicle().getColour()).;

		Map<Integer, ParkingSpot> result = parkingSpots.entrySet().stream()
				.filter(x -> color.equalsIgnoreCase(x.getValue().getVehicle().getColour()))
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

		List<String> result1 = new ArrayList<>();
		result.forEach((k, v) -> result1.add((v.getVehicle().getRegistrationNum())));
		String regnumCommaSeparated = result1.stream().map(String::toUpperCase).collect(Collectors.joining(","));
		if (regnumCommaSeparated != null && !regnumCommaSeparated.isEmpty()) {
			System.out.println(regnumCommaSeparated);
		} else {
			System.out.println("Not Found");
		}

	}

	// slot_numbers_for_cars_with_colour
	public static void slotNumByColour(String color) {

		// parkingSpots.entrySet().stream().filter(x->colour.equalsIgnoreCase(x.getValue().getVehicle().getColour()).;

		Map<Integer, ParkingSpot> result = parkingSpots.entrySet().stream()
				.filter(x -> color.equalsIgnoreCase(x.getValue().getVehicle().getColour()))
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		List<String> result1 = new ArrayList<>();
		result.forEach((k, v) -> result1.add((String.valueOf(v.getSpotNumber()))));
		String slotnumCommaSeparated = result1.stream().map(String::toUpperCase).collect(Collectors.joining(","));
		if (slotnumCommaSeparated != null && !slotnumCommaSeparated.isEmpty()) {
			System.out.println(slotnumCommaSeparated);
		} else {
			System.out.println("Not Found");
		}

	}

	// slot_number_for_registration_number

	public static void slotNumByRegNum(String regNum) {

		// parkingSpots.entrySet().stream().filter(x->colour.equalsIgnoreCase(x.getValue().getVehicle().getColour()).;

		Map<Integer, ParkingSpot> result = parkingSpots.entrySet().stream()
				.filter(x -> regNum.equalsIgnoreCase(x.getValue().getVehicle().getRegistrationNum()))
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		List<String> result1 = new ArrayList<>();
		result.forEach((k, v) -> result1.add((String.valueOf(v.getVehicle().getRegistrationNum()))));
		String slotnumCommaSeparated = result1.stream().map(String::toUpperCase).collect(Collectors.joining(","));
		//System.out.println("slotnumCommaSeparated::"+slotnumCommaSeparated);
		if (slotnumCommaSeparated != null && !slotnumCommaSeparated.isEmpty()) {
			System.out.println(slotnumCommaSeparated);
		} else {
			System.out.println("Not Found");
		}

	}

}
