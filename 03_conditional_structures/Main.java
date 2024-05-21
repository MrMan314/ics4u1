/*
 * Main.java
 * Lesson 03 - Conditional Structures
 * Exercises 1, 4, 5, 6, and 9
 */

import java.util.Scanner;
import java.util.Random;

public class Main {
	// Global input reader and random number generator
	private static Scanner inputReader = new Scanner(System.in);
	private static Random randomGenerator = new Random();
	
	/**
	 * Calculates the cost of printing from the given amount of pages
	 */
	private static void printing() {
		// Prompt user to enter the number of copies to be printed
		System.out.print("Enter the number of copies to be printed: ");
		int copiesCount = inputReader.nextInt();
		// Read a line of input to avoid glitching
		inputReader.nextLine();
		// Get the price per copy based on the number of copies
		float pricePerCopy = 0.25f;
		if (copiesCount < 100) {
			pricePerCopy = 0.30f;
		} else if (copiesCount < 500) {
			pricePerCopy = 0.28f;
		} else if (copiesCount < 750) {
			pricePerCopy = 0.27f;
		} else if (copiesCount < 1000) {
			pricePerCopy = 0.26f;
		}
		// Calculat total cost and tell user
		System.out.printf(
			"Price per copy is: $%.2f\n" +
			"Total cost is: $%.2f\n", pricePerCopy, (float)copiesCount * pricePerCopy);
	}
	
	/**
	 * Determines whether the car is defective based on the model number
	 */
	private static void carRecall() {
		// Prompt user to enter the car's model number	
		System.out.print("Enter the car's model number: ");
		int modelNumber = inputReader.nextInt();
		// Read a line of input to avoid glitching
		inputReader.nextLine();
		// Tell the user whether to car is defective based on the model number
		System.out.print("Your car is ");
		switch(modelNumber) {
			case 119:
			case 179:
			case 189:
			case 195:
			case 221:
			case 780:
				System.out.println("defective. It must be repaired.");
				break;
			default:
				System.out.println("not defective.");
		}
	}

	/**
	 * Determines the grade letter based on the percentage
	 */
	private static void grade() {
		// Prompt user to enter the percentage grade
		System.out.print("Enter the percentage: ");
		int grade = inputReader.nextInt();
		// Read a line of input to avoid glitching
		inputReader.nextLine();
		// Tell user what the corresponding letter grade is
		System.out.print("The corresponding letter grade is: ");
		if(grade < 60) {
			System.out.println("F");
		} else if (grade < 70) {
			System.out.println("D");
		} else if (grade < 80) {
			System.out.println("C");
		} else if (grade < 90) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}

	/**
	 * Generates a random math question for the user to answer
	 */
	private static void mathTutor() {
		// Generate the random numbers and operation for the math question
		int firstNumber = randomGenerator.nextInt(10) + 1;
		int secondNumber = randomGenerator.nextInt(10) + 1;
		int operation = randomGenerator.nextInt(4);
		int expectedResult;
		// Prompt user to enter the question with the answer
		switch(operation) {
			case 0:
				expectedResult = firstNumber * secondNumber;
				System.out.printf("What is %d * %d? ", firstNumber, secondNumber);
				break;
			case 1:
				expectedResult = firstNumber + secondNumber;
				System.out.printf("What is %d + %d? ", firstNumber, secondNumber);
				break;
			case 2:
				expectedResult = firstNumber - secondNumber;
				System.out.printf("What is %d - %d? ", firstNumber, secondNumber);
				break;
			default:
				expectedResult = firstNumber / secondNumber;
				System.out.printf("What is %d / %d? (please truncate the decimal) ", firstNumber, secondNumber);
				break;
		}
		int result = inputReader.nextInt();
		// Read a line of input to avoid glitching
		inputReader.nextLine();
		// Check if the user is correct and then inform the user
		if(expectedResult == result) {
			System.out.println("Correct!");
		} else {
			System.out.printf("Wrong, it's %d.\n", expectedResult);
		}
	}

	/**
	 * User guesses the computer's generated number between 1 and 20 in one try
	 */
	private static void guessingGame() {
		// Prompt user to enter a number between 1 and 20
		System.out.print("Enter a number between 1 and 20: ");
		int guessedNumber = inputReader.nextInt();
		// Read line to avoid glitching
		inputReader.nextLine();
		// Generate the random number
		int generatedNumber = randomGenerator.nextInt(20) + 1;
		// Tell user the generated number and the user's number
		System.out.printf(
			"Computer's Number: %d\n" +
			"Player's Number: %d\n",
			generatedNumber, guessedNumber);
		// Check if the numbers are equal, and if so, the user wins, otherwise, the user loses.
		if (generatedNumber == guessedNumber) {
			System.out.println("You won!");
		} else {
			System.out.println("Better luck next time.");
		}
	}

	/**
	 * Main function to choose each question
	 */
	public static void main(String[] args) {	
		// Loop until user decides to stop running
		boolean running = true;
		while (running) {
			System.out.print(
				"Please select the question you want to run from the following list:\n" +
				"\t1. Printing\n" +
				"\t\tCalculates the cost of a printing when given a number of sheets.\n" +
				"\t4. Car recall\n" +
				"\t\tDetermines whether the car is defective from the model number.\n" +
				"\t5. Grade\n" +
				"\t\tDetermines the grade letter based on the percentage given.\n" +
				"\t6. Math tutor\n" +
				"\t\tGenerates a random simple question for user to answer.\n" +
				"\t9. Guessing game\n" +
				"\t\tUser guesses the random number generated between 1 and 20 inclusive.\n" +
				"Please enter the question number, or 'q' to quit > ");
			String option = inputReader.nextLine();
			// Add padding for output
			System.out.println();
			// Check for every option
			if(option.equals("1")) {
				printing();
			} else if (option.equals("4")) {
				carRecall();
			} else if (option.equals("5")) {
				grade();
			} else if (option.equals("6")) {
				mathTutor();
			} else if (option.equals("9")) {
				guessingGame();
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
