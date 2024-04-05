/*
 * Main.java
 * Lesson 8 - OOP
 * Exercises 1, 3, and ?
 */

import java.util.Scanner;

public class Main {
	
	/**
	 * Main function to choose each question
	 */
	public static void main(String[] args) {

		// Declare local input reader
		Scanner inputReader = new Scanner(System.in);

		// Create array for the problems
		Problem problems[] = {
			new E1(),
			new E3(),
			new E5()
		};

		// Running flag
		boolean running = true;

		// Loop until user decides to stop
		while (running) {
			// Prompt for input
			System.out.println("Please select the question you want to run from the following list, or 'quit' to quit:");
			
			// Display info of each problem
			for(Problem problem: problems) {
				System.out.printf(
					"\t%d. %s\n" +
					"\t\t%s\n",
					problem.getNumber(), problem.getName(),
					problem.getDescription()
				);
			}
			
			System.out.print(" > ");

			// Get user input
			String selection = inputReader.nextLine().strip().toUpperCase();
			
			// If user wants to quit, quit
			if(selection.equalsIgnoreCase("QUIT")) {
				System.out.println("Goodbye!");
				running = false;
			} else {
				// Flag variable to check if code was run
				boolean ran = false;

				// Check each problem for matching fields
				for(Problem problem: problems) {
					int problemNumber = problem.getNumber();
					if(	selection.equalsIgnoreCase(problem.getName().strip()) || 
						selection.equalsIgnoreCase(Integer.toString(problemNumber).strip())) {
							// If there is a match, run the question, set the flag variable, and exit the for loop.
							problem.run();
							ran = true;
							break;
					}
				}

				// If no code was run, inform user
				if(!ran) {
					System.out.println("Sorry, I don't know what you mean!");
				}
			}
			// Add line for spacing
			System.out.println();
		}
	}
}
