/*
 * E1.Java
 * Lesson 8 - OOP
 * Exercise 1 - Piggy Bank
 */

public class E1 extends Problem{

	// Constructor to initialize fields in parent class
	public E1() {
		super(1, "Piggy Bank", "Piggy bank emulator");
	}

	/**
	 * Main function run from outside
	 */
	@Override
	public void run() {
		// Create a new piggy bank and flag
		PiggyBank bank = new PiggyBank();
		boolean running = true;
		
		// Loop until user exits
		while(running) {
			// Prompt user for inputs
			System.out.print(
				"Please select the operation you would like to perform on the bank:\n" +
				"\t0. QUIT\n" +
				"\t1. SHOW money in the bank\n" +
				"\t2. ADD money to the bank\n" +
				"\t3. REMOVE money from the bank\n" +
				" > "
			);
			String option = super.inputReader.nextLine().toUpperCase().strip();

			// Initialize variables for coin inputs
			int coin, count;

			switch(option) {
				case "0":
				case "ZERO":
				case "QUIT":
					running = false;
					break;
				case "1":
				case "ONE":
				case "SHOW":
					// Call functions to get value of coins from bank
					double value = bank.getAmount();
					int[] coins = bank.getCoins();
					// Display total value with plural and singular depending on count
					System.out.printf(
						"There is currently $%.2f in the bank, comprised of:\n" +
						"\t%d penn%s\n" +
						"\t%d nickel%s\n" +
						"\t%d dime%s\n" +
						"\t%d quarter%s\n",
						value,
						coins[0], (coins[0] == 1 ? "y" : "ies"),
						coins[1], (coins[1] == 1 ? "" : "s"),
						coins[2], (coins[2] == 1 ? "" : "s"),
						coins[3], (coins[3] == 1 ? "" : "s")
					);
					break;
				case "2":
				case "ADD":
					// Prompt user for coin, if return value is -1, the coin is invalid
					coin = selectCoin();
					if(coin == -1) {
						System.out.println("Invalid coin");
						break;
					}
					// Prompt for quantity of coins
					System.out.print("Please enter the quantity of coins to add > ");
					count = super.inputReader.nextInt();
					super.inputReader.nextLine();
					// Call function to add coin, then inform user
					bank.addCoin(coin, count);
					System.out.println("Coins added.");
					break;
				case "3":
				case "REMOVE":
					// Prompt user for coin, if return value is -1, the coin is invalid
					coin = selectCoin();
					if (coin == -1) {
						System.out.println("Invalid coin");
						break;
					}
					// Prompt for quantity of coins
					System.out.print("Please enter the quantity of coins to remove > ");
					count = super.inputReader.nextInt();
					super.inputReader.nextLine();
					// Call function to remove coin.  If there are not enough, nothing happens, inform user.
					boolean removeFailure = bank.removeCoin(coin, count);
					if (removeFailure) {
						System.out.println("There are not enough coins to remove from the bank.");
						break;
					}
					System.out.println("Coins removed.");
					break;
				default:
					System.out.println("Sorry, I don't know what you mean!");
			}
			// Add new line for spacing
			System.out.println();
		}
	}

	/**
	 * Function to select a coin 
	 * Returns -1 if the coin is invalid, the coin id if valid.
	 */	
	private int selectCoin() {
		// Prompt user for input
		System.out.print(
			"Please select a coin:\n" +
			"\t1. PENNIES\n" +
			"\t2. NICKELS\n" +
			"\t3. DIMES\n" +
			"\t4. QUARTERS\n" +
			" > "
		);
		String option = super.inputReader.nextLine().toUpperCase().strip();
		switch (option) {
			case "1":
			case "PENNIES":
				return 0;
			case "2":
			case "NICKELS":
				return 1;
			case "3":
			case "DIMES":
				return 2;
			case "4":
			case "QUARTERS":
				return 3;
			default:
				// Return -1 if coin is invalid
				return -1;
		}
	}
}
