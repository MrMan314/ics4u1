/*
 * Main.java
 * Lesson 02 - Variables and Constants
 * Exercises 2,6,8,11
 */

import java.util.Scanner;

public class Main {
	// Input reader
	private static Scanner inputReader = new Scanner(System.in);
	
	/**
	 * Calculates the cost of a pizza depending on its diameter
	 */
	private static void pizzaCost() {
		// Define constant costs
		final float labourCost = 0.75f;
		final float rentCost = 1.00f;
		// Prompt user to enter the diameter of pizza in inches
		System.out.print("Enter the diameter of the pizza in inches: ");
		float diameter		= inputReader.nextFloat();
		// Read a line of input to avoid glitching
		inputReader.nextLine();
		// Calulate materials cost
		float materialsCost = 0.05f * diameter * diameter;
		// Calculate total cost
		float totalCost = labourCost + rentCost + materialsCost;
		// Tell the user the total cost
		System.out.printf("The cost of making pizza is: $%.2f\n", totalCost);
	}

	/**
	 * Calculates the minimum number and types of coins to use to create a value of change
	 */
	private static void change() {
		// Prompt user for change value
		System.out.print("Enter the change in cents: ");
		int change = inputReader.nextInt();
		// Read line to avoid glitching
		inputReader.nextLine();
		// Define counters for the coins
		int quarters = 0, dimes = 0, nickels = 0, pennies = 0;
		// Loop until the change is zero
		while(change > 0) {
			// Decrement a coin value and increase the counter, use the highest possible coin value to use first, minimizing coin count.
			if(change >= 25) {
				change -= 25;
				quarters++;
			} else if (change >= 10) {
				change -= 10;
				dimes++;
			} else if (change >= 5) {
				change -= 5;
				nickels++;
			} else {
				change--;
				pennies++;
			}
		}
		// Print out the amounts of coins
		System.out.printf(
			"The minimum number of coins is:\n" + 
			"\tQuarters: %d\n" +
			"\tDimes: %d\n" +
			"\tNickels: %d\n" +
			"\tPennies: %d\n",
			quarters, dimes, nickels, pennies);
	} 
	
	/**
	 * Calculates the division and modulus of two numbers both ways
	 */
	private static void divAndMod() {
		// Prompt user for the two numbers
		System.out.print("Enter an integer: ");
		int firstNumber = inputReader.nextInt();
		System.out.print("Enter a second integer: ");
		int secondNumber = inputReader.nextInt();
		// Read line to avoid glitching
		inputReader.nextLine();
		// Tell user the results of modulus and division
		System.out.printf(
			"\n%d / %d = %d\n" + 
			"%d %% %d = %d\n\n" +
			"%d / %d = %d\n" +
			"%d %% %d = %d\n",
			firstNumber, secondNumber, firstNumber / secondNumber,
			firstNumber, secondNumber, firstNumber % secondNumber,
			secondNumber, firstNumber, secondNumber / firstNumber,
			secondNumber, firstNumber, secondNumber % firstNumber);
	}

	/**
	 * Calculates the total before tax, tax, final total, and change depending on the user's orders
	 */
	private static void order() {
		// Define the constants
		final float burgerCost = 1.69f;
		final float friesCost = 1.09f;
		final float sodaCost = 0.99f;
		// Prompt user for input
		System.out.print("Enter the number of burgers: ");
		int burgerCount = inputReader.nextInt();
		System.out.print("Enter the number of fries: ");
		int friesCount = inputReader.nextInt();
		System.out.print("Enter the number of sodas: ");
		int sodaCount = inputReader.nextInt();
		// Read line to avoid glitching
		inputReader.nextLine();
		

		// Calculate total before tax, tax(6.5%, i wish :/), and final total
		float totalBeforeTax = burgerCount * burgerCost + friesCount * friesCost + sodaCount * sodaCost;
		float tax = totalBeforeTax * 0.065f;
		float finalTotal = totalBeforeTax + tax;
		// Print out the values calculated
		System.out.printf(
			"Total before tax: $%.2f\n" +
			"Tax: $%.2f\n" + 
			"Final total: $%.2f\n\n",
			totalBeforeTax, tax, finalTotal);
		
		// Prompt user for input of amount tendered
		System.out.print("Enter amount tendered: $");
		
		// Define amount tendered and change counters
		float amountTendered = 0, change = 0;
		// Loop until user has paid enough
		do {
			// Calculate change amount
			amountTendered += inputReader.nextFloat();
			change = amountTendered - finalTotal;
			// If change is negative, re-prompt user
			if(change < 0) {
				System.out.printf(
					"Not enough money, still need $%.2f\n" +
					"Please enter additional amount tendered: $",
					-change);
			}
		} while (change < 0);
		// Read line to avoid glitching
		inputReader.nextLine();
		// Print out change amount
		System.out.printf("Change: $%.2f\n", change);
	}

	/**
	 * Main function to choose each question
	 */
	public static void main(String[] args) {	
		// Loop until user decides to stop running
		boolean running = true;
		while (running) {
			System.out.print(	"Please select the question you want to run from the following list:\n" +
								"\t2. Pizza cost\n" +
								"\t\tCalculates the cost of a pizza depending on the diameter.\n" +
								"\t6. Change\n" +
								"\t\tCalculates the minimum amount and types of coins to give a change.\n" +
								"\t8. Division and Modulus\n" +
								"\t\tCalculates the division and modulus of numbers both ways.\n" +
								"\t11. Order\n" +
								"\t\tAn application for the employees of a restaurant to calculate the total cost and change.\n" +
								"Please enter the question number, or 'q' to quit > ");
			String option = inputReader.nextLine();
			// Add padding for output
			System.out.println();
			// Check for every option
			if(option.equals("2")) {
				pizzaCost();
			} else if (option.equals("6")) {
				change();
			} else if (option.equals("8")) {
				divAndMod();
			} else if (option.equals("11")) {
				order();
			} else if (option.equals("q")) {
				running = false;
			} else {
				System.out.println("Sorry, I don't know what you mean.");
			}
			// Add padding for output
			System.out.println();
		}
	}
}
