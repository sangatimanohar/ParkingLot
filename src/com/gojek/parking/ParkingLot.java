package com.gojek.parking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ParkingLot {

	public static void main(String[] args) throws IOException {
		
		//Parking by file parsing
		if (args.length != 0) {
			File fis = new File(args[0]);
			BufferedReader b = new BufferedReader(new FileReader(fis));
			String readLine = "";
			String choice = null;
			String color = null;
			String regNum = null;

			// System.out.println("Reading file using Buffered Reader");

			while ((readLine = b.readLine()) != null) {
				// System.out.println(readLine);
				if (readLine != null) {
					String[] split = readLine.split(" ");
					if (split.length == 2) {
						choice = split[0].trim();
						color = split[1].trim();
					} else if (split.length == 3) {
						choice = split[0].trim();
						regNum = split[1].trim();
						color = split[2].trim();
					} else {
						choice = readLine.trim();
					}
				}
				
				ParkingLotChoice.Choice(choice, color, regNum);

			}
		} else {
			//Parking by commands
			Boolean existVal = false;
			do {

				String choice = null;
				String color = null;
				String regNum = null;

				Scanner scanner = new Scanner(System.in);
				String line = scanner.nextLine();
				String[] split2 = line.split(" ");
				if (split2.length != 0 && split2[0].equalsIgnoreCase("exit")) {
					existVal = true;
					System.exit(0);
				} else {
					if (line != null) {
						String[] split = line.split(" ");
						if (split.length == 2) {
							choice = split[0].trim();
							color = split[1].trim();
						} else if (split.length == 3) {
							choice = split[0].trim();
							regNum = split[1].trim();
							color = split[2].trim();
						} else {
							choice = line.trim();
						}
					}
					ParkingLotChoice.Choice(choice, color, regNum);
				}

			} while (!existVal);

		}

	}

}
