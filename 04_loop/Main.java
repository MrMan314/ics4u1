/*
 * Main.java
 * Lesson 04 - Loop
 * Exercises 1, 5, 6, 11, 18, and 20
 */

import java.util.Scanner;

public class Main {
	// Global input reader
	private static Scanner inputReader = new Scanner(System.in);
	
	/**
	 * Checks if a given number is prime and returns a boolean
	 */
	private static boolean isPrime(int n) {
		// Any number less than two is not prime
		if(n < 2) return false;
		// Check divisibility of every number under its square root
		for(int i = 2; i <= (int)Math.sqrt(n); i++) {
			// If the number is divisible, return false
			if(n % i == 0) {
				return false;
			}
		}
		// If the loop completes without returning false, the number is prime - return true
		return true;
	}

	/**
	 * Checks if an inputted number is prime
	 */
	private static void checkPrime() {
		// Prompt user for input
		System.out.print("Please enter a number > ");
		int givenNumber = inputReader.nextInt();
		inputReader.nextLine();
		// Inform user
		System.out.printf("%d is ", givenNumber);
		// Print not if it is not
		if(!isPrime(givenNumber)) {
			System.out.print("not ");
		}
		System.out.println("prime.");
	}
	
	/**
	 * Determines all the prime numbers within a given range, inclusive
	 */
	private static void checkPrimeRange() {
		// Prompt user for lower and upper bounds
		System.out.print("Please enter the lower bound value > ");
		int lowerBound = inputReader.nextInt();
		inputReader.nextLine();
		System.out.print("Please enter the upper bound value > ");
		int upperBound = inputReader.nextInt();
		inputReader.nextLine();
		// Tell user the prime numbers in the range
		System.out.printf("The prime numbers between %d and %d, inclusive are:\n", lowerBound, upperBound);
		for(int i = lowerBound; i <= upperBound; i++) {
			// Print out the number if the number is prime
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	/**
	 * Mini problem selector to choose the parts of question 1
	 */
	private static void primeNumber() {
		// Prompt user for input
		System.out.print(
			"There are multiple parts to this problem, please select the part you want to run from the following list:\n" +
			"\ta. Prime number\n" +
			"\t\tChecks if a given number is prime\n" +
			"\tb. Prime number range\n" +
			"\t\tLists all prime numbers in a given range\n" +
			"Please enter the letter corresponding to the desired part > ");
		String option = inputReader.nextLine();
		// Check for every option
		switch(option.toUpperCase()) {
			case "A":
			case "PRIME NUMBER":
				checkPrime();
				break;
			case "B":
			case "PRIME NUMBER RANGE":
				checkPrimeRange();
				break;
			default:
				System.out.println("Sorry, I don't know what you mean.");
		}
	}

	/**
	 * Prints each digit of a positive integer on a line
	 */
	private static void digitsDisplay() {
		// Prompt user for input
		System.out.print("Enter a positive integer: ");
		int givenNumber = inputReader.nextInt();
		inputReader.nextLine();
		// Loop until input is positive
		while(givenNumber < 1) {
			System.out.print("Enter a POSITIVE integer: ");
			givenNumber = inputReader.nextInt();
			inputReader.nextLine();
		}
		// Get the digit count of the number, truncate the decimal
		int digitCount = (int) Math.log10(givenNumber);
		// ith digit is n / 10^i mod 10
		for(int i = digitCount; i >= 0; i--) {
			// Print the ith digit
			System.out.println((int) (givenNumber / Math.pow(10,i) % 10));
		}
	}

	/**
	 * Prints out the sum of all the digits in the positive integer
	 */
	private static void digitsSum() {
		// Prompt user for input
		System.out.print("Enter a positive integer: ");
		int givenNumber = inputReader.nextInt();
		inputReader.nextLine();
		// Loop until input is positive
		while(givenNumber < 1) {
			System.out.print("Enter a POSITIVE integer: ");
			givenNumber = inputReader.nextInt();
			inputReader.nextLine();
		}
		// Get the digit count of the number, truncate the decimal, initialize running total
		int digitCount = (int) Math.log10(givenNumber), sum = 0;
		// ith digit is n / 10^i mod 10
		for(int i = digitCount; i >= 0; i--) {
			// Add it to the running total
			sum += (int) (givenNumber / Math.pow(10,i) % 10);
		}
		// Tell user the total sum
		System.out.printf("The sum of the digits is: %d\n", sum);
	}

	/**
	 * Determines the time after an elapsed amount of hours since a given time
	 */
	private static void elapsedTimeCalculator() {
		// Prompt user for input
		System.out.print("Enter the starting hour: ");
		int startingHour = inputReader.nextInt();
		inputReader.nextLine();
		System.out.print("Enter am or pm: ");
		String halfDay = inputReader.nextLine().toUpperCase();
		// Repeat until user gives valid input
		while(!halfDay.equals("AM") && !halfDay.equals("PM")) {
			System.out.print("Invalid option, please enter am or pm: ");
			halfDay = inputReader.nextLine().toUpperCase();
		}
		// Conver to 24 hour time
		if (halfDay.equals("PM")) {
			if (startingHour != 12) {
				startingHour += 12;
			}
		} else if (startingHour == 12) {
			startingHour = 0;
		}
		// Get elapsed hours
		System.out.print("Enter the number of elapsed hours: ");
		int elapsedHours = inputReader.nextInt();
		inputReader.nextLine();
		// Increment time
		startingHour += elapsedHours;
		// Remove full days
		startingHour %= 24;
		// Convert back to 12-hour time and print
		System.out.print("The time is: ");
		if(startingHour == 0) {
			System.out.println("12:00 am");
		} else if (startingHour == 12) {
			System.out.println("12:00 pm");
		} else if (startingHour < 12) {
			System.out.printf("%d:00 am\n", startingHour);
		} else {
			System.out.printf("%d:00 pm\n", startingHour - 12);
		}
	}

	/**
	 * Generates a monogram based off a given full name
	 */
	private static void monogram() {
		// Prompt user for input
		System.out.print("Enter your first name: ");
		String firstName = inputReader.nextLine();
		System.out.print("Enter your middle initial: ");
		String middleInitial = inputReader.nextLine();
		System.out.print("Enter your last name: ");
		String lastName = inputReader.nextLine();

		// Generate monogram
		String monogram = "" +
			firstName.toLowerCase().charAt(0) +
			lastName.toUpperCase().charAt(0) +
			middleInitial.toLowerCase().charAt(0);

		// Print monogram
		System.out.printf("\nYour monotgram is: %s\n", monogram);
	}

	/**
	 * Counts the number of vowels in the given string
	 */
	private static void countVowels() {
		// Prompt user for input
		System.out.print("Enter text: ");
		String userInput = inputReader.nextLine();
		// Conver to uppercase to make processing easier
		String processedInput = userInput.toUpperCase();
		// Initialize running counter
		int vowelCount = 0;
		for(int i = 0; i < userInput.length(); i++) {
			// Increment the counter if ith character is a vowel
			if(	processedInput.charAt(i) == 'A' ||
				processedInput.charAt(i) == 'E' ||
				processedInput.charAt(i) == 'I' ||
				processedInput.charAt(i) == 'O' ||
				processedInput.charAt(i) == 'U'	) {
					vowelCount++;
				}
		}
		// Tell user the total
		System.out.printf("The number of vowels in %s is %d\n", userInput, vowelCount);
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
				"\t1. Prime Number\n" +
				"\t\tChecks if a number is prime.\n" +
				"\t5. Digits Display\n" +
				"\t\tPrints out the digits of a positive integer on separate lines.\n" +
				"\t6. Digits Sum\n" +
				"\t\tPrints out the sum of all the digits in an integer.\n" +
				"\t11. Elapsed Time Calculator\n" +
				"\t\tDetermines the time after an elapsed amount of hours since a given time.\n" +
				"\t18. Monogram\n" +
				"\t\tGenerates a monogram based off a given full name.\n" +
				"\t20. Count vowels\n" +
				"\t\tCounts the number of vowels in a given String.\n" +
				"Please enter the question number or name, or 'q' to quit > ");
			String option = inputReader.nextLine().toUpperCase();
			// Add padding for output
			System.out.println();
			// Check for every option
			switch(option) {
				case "1":
				case "ONE":
				case "PRIME NUMBER":
					primeNumber();
					break;
				case "5":
				case "FIVE":
				case "DIGITS DISPLAY":
					digitsDisplay();
					break;
				case "6":
				case "SIX":
				case "DIGITS SUM":
					digitsSum();
					break;
				case "11":
				case "ELEVEN":
				case "ELAPSED TIME CALCULATOR":
					elapsedTimeCalculator();
					break;
				case "18":
				case "EIGHTEEN":
				case "MONOGRAM":
					monogram();
					break;
				case "20":
				case "TWENTY":
				case "COUNT VOWELS":
					countVowels();
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
}
