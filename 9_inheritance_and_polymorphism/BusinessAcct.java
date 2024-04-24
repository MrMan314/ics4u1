public class BusinessAcct extends Account {
	private static final double limit = 500f;
	private static final double penalty = 10f;
	private static final String accountType = "business";

	public BusinessAcct(String fName, String lName, String str, String city, String st, String zip) {
		super(limit, fName, lName, str, city, st, zip, accountType, limit, penalty);
	}
}
