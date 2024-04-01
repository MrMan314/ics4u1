import java.util.Scanner;
import java.util.ArrayList;

public class E16 {
	private static Scanner inputReader = new Scanner(System.in);
	private static ArrayList<String> itemName = new ArrayList<String>();
	private static ArrayList<Integer> itemQuantity = new ArrayList<Integer>();

	public static void main(String[] args) {
		if(itemName.size() > 0 || itemQuantity.size() > 0) {
			System.out.print(
				"It seems that there are items stored from a previous session, would you like to:\n" + 
				"\t1. resume, or\n" +
				"\t2. start a new one?\n" +
				" > ");
			int choice = inputReader.nextInt();
			inputReader.nextLine();
			if(choice == 2) {
				itemName = new ArrayList<String>();
				itemQuantity = new ArrayList<Integer>();
			}
		}
		boolean running = true;
		while (running) {
			System.out.print(
				"Please select the operation you want to perform on the inventory:\n" + 
				"\t1. LIST items\n" + 
				"\t2. ADD item\n" + 
				"\t3. DISCONTINUE item\n" + 
				"\t4. QUIT\n" +
				" > "
			);
			String choice = inputReader.nextLine().toUpperCase().strip();
			switch(choice) {
				case "1":
				case "ONE":
				case "LIST":
					listItems();
					break;
				case "2":
				case "TWO":
				case "ADD":
					addItem();
					break;
				case "3":
				case "THREE":
				case "DISCONTINUE":
					discontinueItem();
					break;
				case "4":
				case "FOUR":
				case "QUIT":
					running = false;
					break;
				default:
					System.out.println("Sorry, I don't know what you mean!");
			}
		}
	}
	
	private static void listItems() {
		System.out.printf("There are currently %d item(s) in your inventory:\n", itemName.size());
		System.out.println("S/N\tQTY\tNAME");
		for(int i = 0; i < itemName.size(); i++) {
			System.out.printf("%d\t%d\t%s\n", i + 1000, itemQuantity.get(i), itemName.get(i));
		}
		System.out.println();
	}

	private static void addItem() {
		System.out.printf("Please enter the item name:\n > ");
		String name = inputReader.nextLine();
		itemName.add(name);
		System.out.printf("Please enter its quantity:\n > ");
		int qty = inputReader.nextInt();
		inputReader.nextLine();
		itemQuantity.add(qty);
		System.out.printf("The new item's stock number is: %d.\n\n", itemName.size() + 999);
	}

	private static void discontinueItem() {
		listItems();
		System.out.print("Please enter the stock number of the item you want to discontinue:\n > ");
		int sn = inputReader.nextInt();
		inputReader.nextLine();
		if(sn - 999 > itemName.size()) {
			System.out.println("This item does not exist.");
		} else {
			itemName.set(sn - 1000, "DISCONTINUED");
			itemQuantity.set(sn - 1000, 0);
			System.out.println("The item has been discontinued.");
		}
		System.out.println();
	}
}