/*
 * E2.java
 * Exercise 2: Accounts
 */

import java.util.ArrayList;

public class L9E2 extends Problem {
	// ArrayList to store accounts
	private ArrayList<Account> accounts = new ArrayList<Account>();

	/**
	 * Constructor
	 * pre: none
	 * post: E2 problem created
	 */
	public L9E2() {
		super(9, 2, "Accounts", "Simulates a personal and business account");
	}

	/**
	 * Function to run for problem
	 * pre: none
	 * post: account problem run
	 */
	public void run() {
		// Loop until user exits
		boolean running = true;
		while (running) {
			// Prompt user for input
			System.out.print(
				"Please select the action you want to perform:\n" +
				"\t1. LIST accounts\n" +
				"\t2. SELECT account\n" +
				"\t3. REMOVE account\n" +
				"\t4. CREATE account\n" +
				"Enter your choice, or type 'quit' to quit > "
			);
			String option = super.inputReader.nextLine().toUpperCase().strip();
			// Run function based on input
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

	/**
	 * Lists the accounts stored in the ArrayList
	 * pre: none
	 * post: the information of the accounts are displayed to the user
	 */
	private void listAccounts() {
		// Print a "header" for the list
		System.out.printf("There are currently %d accounts:\n", accounts.size());
		// Iterate over the list and print out its information
		for(int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			System.out.printf("%d: %s $%.2f\n", i, account.getType(), account.getBalance());
			System.out.println(account.toCustomerString());
		}
	}

	/**
	 * Selects an account and perfroms actions on it
	 * pre: none
	 * post: money is withdrawn or deposited, necessary penalties are charged
	 */
	private void selectAccount() {
		// Show user a list of accounts
		listAccounts();
		// Prompt user for input
		System.out.print("Please enter the index of the account you want to perform operations on\n > ");
		int accountSelection = super.inputReader.nextInt();
		super.inputReader.nextLine();
		// Check if the input is valid or in range
		if(accountSelection < 0 || accountSelection >= accounts.size()) {
			// If not, return immediately
			System.out.println("The index is out of range.");
			return;
		}

		// Loop until user decides to stop
		boolean running = true;

		while (running) {
			// Show the balance of the account and the options available
			System.out.printf(
				"You currently have $%.2f in your account.\n" +
				"Please select the action you want to perform:\n" +
				"\t1. WITHDRAW money\n" +
				"\t2. DEPOSIT money\n" +
				"Enter your choice, or type 'quit' to quit > ",
				accounts.get(accountSelection).getBalance()
			);
			// Read user input
			String option = super.inputReader.nextLine().toUpperCase().strip();
			// Define the amount to be used
			double amount;
			// Call the necessary functions based on input
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

	/**
	 * Account removal function
	 * pre: none
	 * post: account selected is deleted if exists
	 */
	private void removeAccount() {
		// List accounts
		listAccounts();
		// Prompt user for input
		System.out.print("Please enter the index of the account you want to delete\n > ");
		int accountDeletion = super.inputReader.nextInt();
		super.inputReader.nextLine();
		// Check if input is in range
		if(accountDeletion < 0 || accountDeletion >= accounts.size()) {
			// If not in range, return immediately
			System.out.println("The index is out of range.");
			return;
		}
		// Otherwise, delete the account and inform user
		accounts.remove(accountDeletion);
		System.out.printf("The account with index %d has been deleted.\n", accountDeletion);
	}

	/**
	 * Account creation function
	 * pre: none
	 * post: a new account is created
	 */
	private void createAccount() {
		// Prompt and read the fields for the account
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
		// Create an account based on the type of account requested
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
				// If account type is invalid, inform user and exit immediately
				System.out.println("Sorry, you have entered an invalid account type.");
				return;
		}
		// Tell user about creation
		System.out.printf("New account created with index %d.\n", accounts.size() - 1);
	}
}
