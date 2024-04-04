public class E1 extends Problem{

	public E1() {
		super(1, "Piggy Bank", "test");
	}

	@Override
	public void run() {
		PiggyBank bank = new PiggyBank();
		boolean running = true;
		
		while(running) {
			System.out.print(
				"Please select the operation you would like to perform on the bank:\n" +
				"\t0. QUIT\n" +
				"\t1. SHOW money in the bank\n" +
				"\t2. ADD money to the bank\n" +
				"\t3. REMOVE money from the bank\n" +
				" > "
			);
			String option = super.inputReader.nextLine().toUpperCase().strip();

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
					double value = bank.getAmount();
					int[] coins = bank.getCoins();
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
					coin = selectCoin();
					if(coin == -1) {
						System.out.println("Invalid coin");
						break;
					}
					System.out.print("Please enter the quantity of coins to add > ");
					count = super.inputReader.nextInt();
					super.inputReader.nextLine();
					bank.addCoin(coin, count);
					System.out.println("Coins added.");
					break;
				case "3":
				case "REMOVE":
					coin = selectCoin();
					if (coin == -1) {
						System.out.println("Invalid coin");
						break;
					}
					System.out.print("Please enter the quantity of coins to remove > ");
					count = super.inputReader.nextInt();
					super.inputReader.nextLine();
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
			System.out.println();
		}
	}
	
	private int selectCoin() {
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
				return -1;
		}
	}
}
