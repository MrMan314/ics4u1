import java.text.NumberFormat;

public abstract class Account extends Customer {
	protected double balance;
	
	/**
	 * constructor
	 * pre: none
	 * post: An account created. Balance and
	 * customer data initialized with parameters.
	 */
	public Account(double bal, String fName, String lName,
			String str, String city, String st, String zip) {
		super(fName, lName, str, city, st, zip);
		balance = bal;
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
	abstract void withdrawal(double amt);

	/**
	 * Returns a String that represents the Account object.
	 * pre: none
	 * post: A string representing the Account object has
	 * been returned.
	 */
	public String balanceString() {
		String accountString;
		NumberFormat money = NumberFormat.getCurrencyInstance();
		accountString = super.toString();
		accountString += "Current balance is " + money.format(balance);
		return(accountString);
	}
}
