/**
 * E5.java
 * Lesson 8 - OOP
 * Exercise 5 - Nim2
 */

public class L8E5 extends Problem {

	// Constructor to initialize fields in parent class	
	public L8E5() {
		super(8, 5, "Nim2", "Emulates a name of Nim2");
	}

	/**
	 * Main function run from outside
	 */
	@Override
	public void run() {
		// Creates a new Nim2 game object
		Nim2 nimGame = new Nim2();
		// Initialize the result variable, if the result is negative, the game has ended
		int result;
		do {
			// Prompt user for input
			System.out.printf(
				"There are currently %d stones\n" +
				"How many would you like to take? ",
				nimGame.getStoneCount()
			);
			result = nimGame.playerPlay(super.inputReader.nextInt());
			super.inputReader.nextLine();
			// If the input is invalid, keep prompting until valid
			while (result == 1) {
				System.out.print("That is not a valid amount, please try again.\n > ");
				result = nimGame.playerPlay(super.inputReader.nextInt());
				super.inputReader.nextLine();
			}
			// Computer plays the game
			result = nimGame.computerPlay();
			// The function returns 0 if the player wins 
			if (result == 0) {
				// Inform the user of their victory
				System.out.println("The player wins!");
			// The function returns the number of stones it takes if the computer wins, but negative
			} else if (result < 0) {
				// Inform the user of the computer vitory
				System.out.printf(
					"The computer takes %d stone%s\n",
					-result, (-result == 1 ? "" : "s")
				);
				System.out.println("The computer wins!");
			// The function returns the number of stones it takes otherwise
			} else {
				// Inform the user of the number of stones the computer takes
				System.out.printf(
					"The computer takes %d stone%s\n",
					result, (result == 1 ? "" : "s")
				);
			}
		} while (result > 0);
	}
}
