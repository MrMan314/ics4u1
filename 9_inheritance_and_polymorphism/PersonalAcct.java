/*
 * PersonalAcct.java
 * Personal Account class, child of Account
 */

public class PersonalAcct extends Account {
	// Global variables
	private static final double limit = 100f;
	private static final double penalty = 2f;
	private static final String accountType = "personal";

	/**
	 * Constructor for PersonalAcct
	 * pre: none
	 * post: personal account is created
	 */
	public PersonalAcct(String fName, String lName, String str, String city, String st, String zip) {
		super(limit, fName, lName, str, city, st, zip, accountType, limit, penalty);
	}
}
