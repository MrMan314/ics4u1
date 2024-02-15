import java.util.Scanner;

public class E6 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter the change in cents: ");
		int change = inputReader.nextInt();
		int quarters = 0, dimes = 0, nickels = 0, pennies = 0;
		while(change > 0) {
			if(change >= 25) {
				change -= 25;
				quarters++;
			} else if (change >= 10) {
				change -= 10;
				dimes++;
			} else if (change >= 5) {
				change -= 5;
				nickels++;
			} else {
				change--;
				pennies++;
			}
		}
		System.out.printf(
			"The minimum number of coins is:\n" + 
			"\tQuarters: %d\n" +
			"\tDimes: %d\n" +
			"\tNickels: %d\n" +
			"\tPennies: %d\n",
			quarters, dimes, nickels, pennies);
	}
}
