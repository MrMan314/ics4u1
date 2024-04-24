import java.text.NumberFormat;

abstract class Account {
	private double balance;
	private String accountType = "";
	private Customer cust;
	private double limit;
	private double penalty;

	/**
	 * constructor
	 * pre: none
	 * post: An account created. Balance and
	 * customer data initialized with parameters.
	 */
	public Account(double balance, String fName, String lName, String str, String city, String st, String zip, String accountType, double limit, double penalty) {
		this.balance = balance;
		this.accountType = accountType;
		this.limit = limit;
		this.penalty = penalty;
		cust = new Customer(fName, lName, str, city, st, zip);
	}

	/**
	 * Returns the current balance.
	 * pre: none
	 * post: The account balance has been returned.
	 */
	public double getBalance() {
		return(balance);
	}

	/**
	 * A deposit is made to the account.
	 * pre: none
	 * post: The balance has been increased by the amount of the deposit.
	 */
	public void deposit(double amt) {
		balance += amt;
	}

	/**
	 * A withdrawal is made from the account if there is enough money.
	 * pre: none
	 * post: The balance has been decreased by the amount withdrawn.
	 */
	public void withdrawal(double amt) {
		if (balance < amt) {
			System.out.println("There is not enough balance to perform this operation");
			return;
		}
		balance -= amt;
		if (balance < limit) {
			balance -= penalty;
			System.out.printf("You have exceeded the withdraw limit of $%.2f on your account. An additional $%.2f has been charged\n", limit, penalty);
		}
	}
	
	public String getType() {
		return accountType;
	}

	/**
	 * Returns a String that represents the Account object.
	 * pre: none
	 * post: A string representing the Account object has
	 * been returned.
	 */
	public String toString() {
		String accountString;
		NumberFormat money = NumberFormat.getCurrencyInstance();
		accountString = cust.toString();
		accountString += "Current balance is " + money.format(balance);
		return(accountString);
	}

	public String toCustomerString() {
		return cust.toString();
	}
}
