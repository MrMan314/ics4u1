/**
 * Piggy Bank class for E1
 */
public class PiggyBank {

	// Private global variables for coin count	
	private int pennies, nickels, dimes, quarters;

	// On initialization, set all global variables to zero
	public PiggyBank() {
		pennies = 0;
		nickels = 0;
		dimes = 0;
		quarters = 0;
	}

	/**
	 * Function to add coins and count.  If the coin is invalid, nothing happens.
	 */
	public void addCoin(int coin, int count) {
		switch (coin) {
			case 0:
				pennies += count;
				break;
			case 1:
				nickels += count;
				break;
			case 2:
				dimes += count;
				break;
			case 3:
				quarters += count;
		}
	}

	/**
	 * Calculates amount based on coins
	 */
	public double getAmount() {
		return pennies * 0.01 + nickels * 0.05 + dimes * 0.10 + quarters * 0.25;
	}

	/**
	 * Function to get each coin, returns an int array for each count:
	 * 0: pennies
	 * 1: nickels
	 * 2: dimes
	 * 3, quarters
	 */
	public int[] getCoins() {
		int[] coins = {
			pennies,
			nickels,
			dimes,
			quarters
		};
		return coins;
	}

	/**
	 * Removes a coin from the bank
	 * Returns true if there are not enough coins in the bank, otherwise return false
	 */
	public boolean removeCoin(int coin, int count) {
		switch (coin) {
			case 0:
				pennies -= count;
				if (pennies < 0) {
					pennies += count;
					return true;
				}
				break;
			case 1:
				nickels -= count;
				if (nickels < 0) {
					nickels += count;
					return true;
				}
				break;
			case 2:
				dimes -= count;
				if (dimes < 0) {
					dimes += count;
					return true;
				}
				break;
			case 3:
				quarters -= count;
				if (quarters < 0) {
					quarters += count;
					return true;
				}
				break;
		}
		return false;
	}
}
