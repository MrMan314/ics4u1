public class PersonalAcct extends Account {
	private static final double limit = 100f;
	private static final double penalty = 2f;
	private static final String accountType = "personal";

	public PersonalAcct(String fName, String lName, String str, String city, String st, String zip) {
		super(limit, fName, lName, str, city, st, zip, accountType, limit, penalty);
	}
}
