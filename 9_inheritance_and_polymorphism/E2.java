import java.util.ArrayList;

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
		System.out.printf("There are currently %d accounts:\n", accounts.size());
		for(int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			System.out.printf("%d: %s $%.2f\n", i, account.getType(), account.getBalance());
			System.out.println(account.toCustomerString());
		}
	}

	private void selectAccount() {
		listAccounts();
		System.out.print("Please enter the index of the accocunt you want to perform operations on\n > ");
		int accountSelection = super.inputReader.nextInt();
		super.inputReader.nextLine();
		if(accountSelection < 0 || accountSelection >= accounts.size()) {
			System.out.println("The index is out of range.");
			return;
		}

		boolean running = true;

		while (running) {
			System.out.printf(
				"You currently have $%.2f in your account.\n" +
				"Please select the action you want to perform:\n" +
				"\t1. WITHDRAW money\n" +
				"\t2. DEPOSIT money\n" +
				"Enter your choice, or type 'quit' to quit > ",
				accounts.get(accountSelection).getBalance()
			);
			String option = super.inputReader.nextLine().toUpperCase().strip();
			double amount;
			switch (option) {
				case "1":
				case "WITHDRAW":
					System.out.print("Please enter the amount of money you would like to withdraw\n > $");
					amount = super.inputReader.nextDouble();
					super.inputReader.nextLine();
					accounts.get(accountSelection).withdrawal(amount);
					break;
				case "2":
				case "DEPOSIT":
					System.out.print("Please enter the amount of money you would like to withdraw\n > $");
					amount = super.inputReader.nextDouble();
					super.inputReader.nextLine();
					accounts.get(accountSelection).deposit(amount);
					break;
				case "QUIT":
					running = false;
					break;
				default:
					System.out.println("That is not a valid option.");
			}
		}
	}

	private void removeAccount() {
		listAccounts();
		System.out.print("Please enter the index of the accocunt you want to delete\n > ");
		int accountDeletion = super.inputReader.nextInt();
		super.inputReader.nextLine();
		if(accountDeletion < 0 || accountDeletion >= accounts.size()) {
			System.out.println("The index is out of range.");
			return;
		}
		accounts.remove(accountDeletion);
		System.out.printf("The account with index %d has been deleted.\n", accountDeletion);
	}

	private void createAccount() {
		System.out.print("Please enter your first name\n > ");
		String fName = super.inputReader.nextLine();
		System.out.print("Please enter your last name\n > ");
		String lName = super.inputReader.nextLine();
		System.out.print("Please enter your street name\n > ");
		String street = super.inputReader.nextLine();
		System.out.print("Please enter your city name\n > ");
		String city = super.inputReader.nextLine();
		System.out.print("Please enter your state name\n > ");
		String state = super.inputReader.nextLine();
		System.out.print("Please enter your ZIP code\n > ");
		String zip = super.inputReader.nextLine();
		System.out.print(
			"Please select the type of account you wish to create:\n" +
			"\t1. Personal\n" +
			"\t2. Business\n" +
			" > "
		);
		String accountType = super.inputReader.nextLine().toUpperCase().strip();
		switch (accountType) {
			case "1":
			case "P":
			case "PERSONAL":
				accounts.add(new PersonalAcct(fName, lName, street, city, state, zip));
				break;
			case "2":
			case "B":
			case "BUSINESS":
				accounts.add(new BusinessAcct(fName, lName, street, city, state, zip));
				break;
			default:
				System.out.println("Sorry, you have entered an invalid account type.");
				return;
		}
		System.out.printf("New account created with index %d.\n", accounts.size() - 1);
	}
}
