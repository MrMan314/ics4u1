/*
 * BusinessAcct.java
 * Business Account class, child of Account
 */

public class BusinessAcct extends Account {
	// Global variables
	private static final double limit = 500f;
	private static final double penalty = 10f;
	private static final String accountType = "business";

	/**
	 * Constructor for BusinessAcct
	 * pre: none
	 * post: business account is created
	 */
	public BusinessAcct(String fName, String lName, String str, String city, String st, String zip) {
		super(limit, fName, lName, str, city, st, zip, accountType, limit, penalty);
	}
}
