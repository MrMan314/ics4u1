public class PersonalAcct extends Account {
	private final double limit = 100f;
	private final double penalty 2f;
	public Account(String fName, String lName,
			String str, String city, String st, String zip) {
		super(limit, fName, lName, str, city, st, zip);
	}

	public void withdrawal(double amt) {
		if (super.balance < amt) {
			System.out.println("There is not enough balance to perform this operation");
			return;
		}
		super.balance -= amt;
		if (super.balance < limit) {
			System.out.printf("You have exceeded the withdraw limit of $%.2f on your account. An additional $%.2f has been charged\n", limit, penalty);
		}
	}
}
