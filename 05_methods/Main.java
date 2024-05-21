/*
 * Main.java
 * Lesson 05 - Methods
 * Exercises 2 and 5
 */

import java.util.Scanner;

public class Main {
	
	// Global input reader
	private static Scanner inputReader = new Scanner(System.in);
	
	/**
	 * Main function to select problem
	 */
	public static void main(String[] args) {
		// Loop until the user decides to stop
		boolean running = true;
		while (running) {
			// Prompt user to select the problem
			System.out.print(
				"Please select the question you want to run from the following list:\n" + 
				"\t2. Metric Conversion\n" +
				"\t\tConverts between metric and imperail units\n" +
				"\t5. Get Dollar Amount\n" +
				"\t\tCalculates the final total when given the amont of each coin\n" +
				"Please enter the question number or name, or 'q' to quit >"
			);
			String option = inputReader.nextLine().toUpperCase();
			// Add padding for output
			System.out.println();
			// Check for every option
			switch(option) {
				case "2":
				case "TWO":
				case "METRIC CONVERSION":
					metricConversion();
					break;
				case "5":
				case "FIVE":
				case "GET DOLLAR AMOUNT":
					getDollarAmountOutput();
					break;
				case "Q":
				case "QUIT":
					running = false;
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Sorry, I don't know what you mean!");
			}
			// Add padding for output
			System.out.println();
		}
	}
	
	/**
	 * Functions to convert units, based on ratios given in textbook
	 */
	private static double inchesToCentimeters(double inches) {
		return inches * 2.54;
	}

	private static double feetToCentimeters(double feet) {
		return feet * 30f;
	}

	private static double yardsToMeters(double yards) {
		return yards * 0.91;
	}

	private static double milesToKilometers(double miles) {
		return miles * 1.6;
	}

	private static double centimetersToInches(double centimeters) {
		return centimeters / 2.54;
	}

	private static double centimetersToFeet(double centimeters) {
		return centimeters / 30f;
	}

	private static double metersToYards(double meters) {
		return meters / 0.91;
	}

	private static double kilometersToMiles(double kilometers) {
		return kilometers / 1.6;
	}

	/**
	 * Convert between metric and imperial measurements
	 */
	private static void metricConversion() {
		// Prompt user to enter a number
		System.out.print("Enter a number: ");
		double length = inputReader.nextDouble();
		inputReader.nextLine();
		// Prompt user for the conversion desired
		System.out.print(
			"\nConvert:\n" +
			"1. Inches to Centimeters\t\t5. Centimeters to Inches\n" +
			"2. Feet to Meters\t\t\t6. Centimeters to Feet\n" +
			"3. Yards to Meters\t\t\t7. Meters to Yards\n" +
			"4. Miles to Kilometers\t\t\t8. Kilometers to Miles\n\n" +
			"Enter your choice: "
		);
		int conversion = inputReader.nextInt();
		inputReader.nextLine();
		// Run the function to to convert units based on user input
		switch (conversion) {
			case 1:
				System.out.printf("%f inches equals %f centimeters\n", length, inchesToCentimeters(length));
				break;
			case 2:
				System.out.printf("%f feet equals %f centimeters\n", length, feetToCentimeters(length));
				break;
			case 3:
				System.out.printf("%f yards equals %f meters\n", length, yardsToMeters(length));
				break;
			case 4:
				System.out.printf("%f miles equals %f kilometers\n", length, milesToKilometers(length));
				break;
			case 5:
				System.out.printf("%f centimeters equals %f inches\n", length, centimetersToInches(length));
				break;
			case 6:
				System.out.printf("%f centimeters equals %f feet\n", length, centimetersToFeet(length));
				break;
			case 7:
				System.out.printf("%f meters equals %f yards\n", length, metersToYards(length));
				break;
			case 8:
				System.out.printf("%f kilometers equals %f miles\n", length, kilometersToMiles(length));
				break;
			default:
				System.out.println("Sorry, I don't know what you mean.");
		}
	}	
	
	/**
	 * Calculates the final amount when given the number of coins
	 */
	private static double getDollarAmount(int quarters, int dimes, int nickels, int pennies) {
		return quarters * 0.25 + dimes * 0.10 + nickels * 0.05 + pennies * 0.01;
	}

	/**
	 * Outputs the final amount when inputted the number of each coin
	 */
	private static void getDollarAmountOutput() {
		// Prompt user to enter the amount of quarters
		System.out.print(
			"Enter your total coins:\n\n" +
			"Quarters: "
		);
		int quarters = inputReader.nextInt();
		inputReader.nextLine();

		// Prompt user to enter the amount of dimes
		System.out.print("Dimes: ");
		int dimes = inputReader.nextInt();
		inputReader.nextLine();

		// Prompt user to enter the amonunt of nickels
		System.out.print("Nickels: ");
		int nickels = inputReader.nextInt();
		inputReader.nextLine();

		// Prompt user to enter the amount of pennies
		System.out.print("Pennies: ");
		int pennies = inputReader.nextInt();
		inputReader.nextLine();

		// Output the final total
		System.out.printf("\nTotal: $%.2f\n", getDollarAmount(quarters, dimes, nickels, pennies));
	}
}
