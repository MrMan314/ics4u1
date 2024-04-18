public class E2 extends Problem {
	private ArrayList<Account> accounts = new ArrayList<Account>();

public E2() {
		super(2, "Accounts", "Simulates a personal and business account");
	}

	public void run() {
		boolean running = true;
		while (running) {
			System.out.print(
				"Please select the action you want to perform:\n" +
				"\t1. LIST accounts\n" +
				"\t2. SELECT account\n" +
				"\t3. REMOVE account\n" +
				"\t4. CREATE account\n" +
				"Enter your choice, or type 'quit' to quit > "
			);
			String option = super.inputReader.nextLine().toUpperCase().strip();
			switch(option) {
				case "1":
				case "LIST":
					listAccounts();
					break;
				case "2":
				case "SELECT":
					selectAccount();
					break;
				case "3":
				case "REMOVE":
					removeAccount();
					break;
				case "4":
				case "CREATE":
					createAccount();
					break;
				case "QUIT":
					running = false;
					break;
				default:
					System.out.println("Sorry, I don't know what you mean!");
			}
		}
	}

	private void listAccounts() {
		System.out.printf("There are currently %d accounts:\n");
		for(int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			
		}
	}

	private void selectAccount() {
		listAccounts();
	}

	private void removeAccount() {
		listAccounts();
	}
}
