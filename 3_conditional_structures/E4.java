import java.util.Scanner;

public class E4 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter the car's model number: ");
		int modelNumber = inputReader.nextInt();
		inputReader.nextLine();
		System.out.print("Your car is ");
		switch(modelNumber) {
			case 119:
			case 179:
			case 189:
			case 195:
			case 221:
			case 780:
				System.out.println("defective. It must be repaired.");
				break;
			default:
				System.out.println("not defective.");
		}
	}
}
