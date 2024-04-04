public class PiggyBank {
	private static int pennies, nickels, dimes, quarters;

	public PiggyBank() {
		pennies = 0;
		nickels = 0;
		dimes = 0;
		quarters = 0;
	}

	public static void addCoin(int coin, int count) {
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

	public static double getAmount() {
		return pennies * 0.01 + nickels * 0.05 + dimes * 0.10 + quarters * 0.25;
	}

	public static int[] getCoins() {
		int[] coins = {
			pennies,
			nickels,
			dimes,
			quarters
		};
		return coins;
	}

	public static boolean removeCoin(int coin, int count) {
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
