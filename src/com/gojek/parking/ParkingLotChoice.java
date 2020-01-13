package com.gojek.parking;

public class ParkingLotChoice {

	public static void Choice(String choice, String color, String regNum) {

		switch (choice) {

			case ParkingLotConstant.CREATE_PARKING_SLOT:
				// create_parking_lot
				parkingLotOperations.createParkingSlots(Integer.valueOf(color));
				break;
			case ParkingLotConstant.PARK:
				// park
				parkingLotOperations.parkVehicle(regNum, color, parkingLotOperations.parkingSpots.size() + 1);
				break;
			case ParkingLotConstant.LEAVE:
				// leave
				parkingLotOperations.removeVehicleBySlotNum(Integer.valueOf(color));
				break;
			case ParkingLotConstant.STATUS:
				// status
				parkingLotOperations.displayParkingStatus();
				break;
	
			case ParkingLotConstant.REG_NUM_FOR_CARS_BY_COLOR:
				// registration_numbers_for_cars_with_colour
				parkingLotOperations.regNumByColour(color);
	
				break;
	
			case ParkingLotConstant.SLOT_NUM_FOR_CARS_BY_COLOR:
				// slot_numbers_for_cars_with_colour
				parkingLotOperations.slotNumByColour(color);
				break;
			case ParkingLotConstant.SLOT_NUM_FOR_REG_NUM:
				// slot_number_for_registration_number
				parkingLotOperations.slotNumByRegNum(color);
				break;
			case ParkingLotConstant.EXIT:
				System.out.println("exit the sytem: ");
				System.exit(1);
				break;
	
			default:
				System.out.println("invalid option..........");

		}

	}
}
