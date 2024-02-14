/*
 * Main.java
 * Lesson 01 - Intro to Java
 * Excercises 1-3,8
 */

import java.util.Scanner;
import java.util.Random;

public class Main {

	/**
	 * Randomly generates a Bingo card
	 */	
	private static void bingoCard() {
		// Random number generator
		Random randomGenerator = new Random();
		// Bingo card header
		System.out.println("      B      I      N      G      O");
		// Create array for card to avoid duplicates
		int[] card = new int[25];
		// Bingo space variable
		int space = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				// If space is in the center, print "FREE"
				if (i == 2 && j == 2) {
					System.out.print("   FREE");
				} else {
					// Loop until generated number is not invalid
					boolean invalidNumber = true;
					while (invalidNumber) {
						// Assume generated number is valid until otherwise proven
						invalidNumber = false;
						// Generate a random number between 1 and 15 inclusive, then increment by the column number times 15
						space = randomGenerator.nextInt(15) + 1 + j * 15;
						// Store into an array
						card[i * 5 + j] = space;
						// Loop for every column until the current index.
						for(int k = j; k < (i * 5 + j); k += 5) {
							// If number exists (meaning it is invalid), set the invalidNumber to true to loop again
							if(space == card[k]) {
								invalidNumber = true;
								break;
							}
						}
					}
					// Calculate and print amount of spaces required to properly right-align the card as shown in the problem
					int spaces = 7 - Integer.toString(space).length();
					for(int k = 0; k < spaces; k++) System.out.print(" ");
					// Print out the bingo number
					System.out.print(space);
				}
			}
			// Create a new line for next row
			System.out.println();
		}
	}

	/**
	 * Displays the rules to a Bingo game
	 */
	private static void bingoRules() {
		System.out.println("Bingo Card\n");
		System.out.println("1. The caller randomly pulls out a numbered bingo ball.\n");
		System.out.println("2. The number is placed on the bingo board and called out.\n");
		System.out.println("3. Players look for the called number on their bingo card.\n");
		System.out.println("4. If the number is located, it is marked off.\n");
		System.out.println("5. Steps 1 to 4 are repeated until a player matches the BINGO pattern.\n");
		System.out.println("6. The winning player yells BINGO.\n");
	}

	/**
	 * Displays a box with the parameters width and height
	 */
	private static void box(int width, int height) {
		// First row
		for(int i = 0; i < width; i++) {
			System.out.print("*");
		}
		System.out.println();
		// Middle rows
		for(int i = 0; i < height - 2; i++) {
			System.out.print("*");
			for(int j = 0; j < width - 2; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		// Last row
		for(int i = 0; i < width; i++) System.out.print("*");
		System.out.println();
	}

	/**
	 * Displays five Java terms
	 */
	private static void javaTerminology() {
		System.out.println("Java Terminology\n");
		
		System.out.println("Argument:");
		System.out.println("Data passed to a method for processing.\n");

		System.out.println("Comment:");
		System.out.println("Text that provides information to the reader of program code.\n");

		System.out.println("Compiling:");
		System.out.println("The process where source code is converted to code the computer understands.\n");

		System.out.println("Execute:");
		System.out.println("To run a program.\n");

		System.out.println("Method:");
		System.out.println("A named set of statements that perform at single, well-defined task.  A method is always a member of a class\n");

		System.out.println("Statement:");
		System.out.println("An instruction in a program.\n");
	}

	/**
	 * Main function to choose each question
	 */
	public static void main(String[] args) {
		// Input reader
		Scanner inputReader = new Scanner(System.in);
		// Loop until user decides to stop running
		boolean running = true;
		while (running) {
			System.out.print(	"Please select the question you want to run from the following list:\n" +
								"\t1. Bingo card\n" +
								"\t\tGenerates a random Bingo Card\n" +
								"\t2. Bingo rules\n" +
								"\t\tPrints out the rules of the Bingo game\n" +
								"\t3. Box\n" +
								"\t\tPrints out a 15 wide, 7 high box made of asterisks.\n" +
								"\t8. Java Terminology\n" +
								"\t\tPrints out five Java terms and their definitions.\n" +
								"Please enter the question number, or 'q' to quit > ");
			String option = inputReader.nextLine();
			// Add padding for output
			System.out.println();
			// Check for every option
			if(option.equals("1")) {
				bingoCard();
			} else if (option.equals("2")) {
				bingoRules();
			} else if (option.equals("3")) {
				box(15, 7);
			} else if (option.equals("8")) {
				javaTerminology();
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
