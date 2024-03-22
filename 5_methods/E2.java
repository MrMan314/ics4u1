import java.util.Scanner;

public class E2 extends Problem {
	private static int problemNumber = 2;
	private static String problemName = "Metric Conversion";
	private static String problemDescription = "Converts metric units to imperial units and vice-versa.";

	private static Scanner inputReader = new Scanner(System.in);

	public E2() {
		super.problemNumber = this.problemNumber;
		super.problemName = this.problemName;
		super.problemDescription = this.problemDescription;
	}

	private static double inchesToCentimeters(double inches) {
		return inches * 2.54;
	}

	private static double feetToCentimeters(double feet) {
		return feet * 30f;
	}

	private static double yardsToMeters(double yards) {
		return yards * 0.91;
	}

	private static double milesToKilometers(double miles) {
		return miles * 1.6;
	}

	private static double centimetersToInches(double centimeters) {
		return centimeters / 2.54;
	}

	private static double centimetersToFeet(double centimeters) {
		return centimeters / 30f;
	}

	private static double metersToYards(double meters) {
		return meters / 0.91;
	}

	private static double kilometersToMiles(double kilometers) {
		return kilometers / 1.6;
	}

	@Override
	public void main(String[] args) {
		System.out.print("Enter a number: ");
		double length = inputReader.nextDouble();
		inputReader.nextLine();
		System.out.print(
			"\nConvert:\n" +
			"1. Inches to Centimeters\t\t5. Centimeters to Inches\n" +
			"2. Feet to Meters\t\t\t6. Centimeters to Feet\n" +
			"3. Yards to Meters\t\t\t7. Meters to Yards\n" +
			"4. Miles to Kilometers\t\t\t8. Kilometers to Miles\n\n" +
			"Enter your choice: "
		);
		int conversion = inputReader.nextInt();
		inputReader.nextLine();
		switch (conversion) {
			case 1:
				System.out.printf("%f inches equals %f centimeters\n", length, inchesToCentimeters(length));
				break;
			case 2:
				System.out.printf("%f feet equals %f centimeters\n", length, feetToCentimeters(length));
				break;
			case 3:
				System.out.printf("%f yards equals %f meters\n", length, yardsToMeters(length));
				break;
			case 4:
				System.out.printf("%f miles equals %f kilometers\n", length, milesToKilometers(length));
				break;
			case 5:
				System.out.printf("%f centimeters equals %f inches\n", length, centimetersToInches(length));
				break;
			case 6:
				System.out.printf("%f centimeters equals %f feet\n", length, centimetersToFeet(length));
				break;
			case 7:
				System.out.printf("%f meters equals %f yards\n", length, metersToYards(length));
				break;
			case 8:
				System.out.printf("%f kilometers equals %f miles\n", length, kilometersToMiles(length));
				break;
			default:
				System.out.println("Sorry, I don't know what you mean.");
		}
	}	
}
