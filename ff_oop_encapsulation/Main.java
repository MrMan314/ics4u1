/*
 * Main.java
 * Lesson 8 - OOP
 * Exercises 1, 3, and 5
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
			new L8E1(),
			new L8E3(),
			new L8E5(),
			new L9E2(),
			new L9E3()
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
					"\tLesson %d, E%d. %s\n" +
					"\t\t%s\n",
					problem.getLessonNumber(), problem.getNumber(), problem.getName(),
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

				// Prompt for lesson number
				System.out.print("Please enter the lesson number\n > ");
				int lessonNumber = inputReader.nextInt();
				inputReader.nextLine();

				// Check each problem for matching fields
				for(Problem problem: problems) {
					int problemNumber = problem.getNumber();
					if(	(lessonNumber == problem.getLessonNumber() && 
						selection.equalsIgnoreCase(Integer.toString(problemNumber).strip())) || 
						selection.equalsIgnoreCase(problem.getName().strip())) {
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
