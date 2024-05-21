import java.util.Scanner;

public class E11 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter the starting hour: ");
		int startingHour = inputReader.nextInt();
		inputReader.nextLine();
		System.out.print("Enter am or pm: ");
		String halfDay = inputReader.nextLine().toUpperCase();
		while(!halfDay.equals("AM") && !halfDay.equals("PM")) {
			System.out.print("Invalid option, please enter am or pm: ");
			halfDay = inputReader.nextLine().toUpperCase();
		}
		if (halfDay.equals("PM")) {
			if (startingHour != 12) {
				startingHour += 12;
			}
		} else if (startingHour == 12) {
			startingHour = 0;
		}
		System.out.print("Enter the number of elapsed hours: ");
		int elapsedHours = inputReader.nextInt();
		inputReader.nextLine();
		startingHour += elapsedHours;
		startingHour %= 24;
		System.out.print("The time is: ");
		if(startingHour == 0) {
			System.out.println("12:00 am");
		} else if (startingHour == 12) {
			System.out.println("12:00 pm");
		} else if (startingHour < 12) {
			System.out.printf("%d:00 am\n", startingHour);
		} else {
			System.out.printf("%d:00 pm\n", startingHour - 12);
		}
	}
}
