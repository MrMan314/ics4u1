/*
 * Main.java
 * Lesson 10 - Arrays
 * Exercises 3, 13, and 16
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

	// Global declarations
	private static Random randomGenerator = new Random();
	private static Scanner inputReader = new Scanner(System.in);
	private static int board[] = new int[25];
	private static int prizes[] = new int[6];
	// Make each string six characters long by padding it with spaces, can be stripped of the spaces when needed.
	private static String idToPrize[] = {"      ", "puzzle", " game ", " ball ", "poster", " doll "};
	private static ArrayList<String> itemName = new ArrayList<String>();
	private static ArrayList<Integer> itemQuantity = new ArrayList<Integer>();

	/**
	 * Main function to choose each question
	 */
	public static void main(String[] args) {	
		// Loop until user decides to stop running
		boolean running = true;
		while (running) {
			System.out.print(
				"Please select the question you want to run from the following list:\n" +
				"\t3. Random Stats\n" +
				"\t\tGenerates 500 random numbers between 0 and 9, then puts it into a frequeny table\n" +
				"\t13. Penny Pitch\n" +
				"\t\tSimulates a penny pitch game and informs user about the prizes\n" +
				"\t16. Inventory\n" +
				"\t\tSimulates an inventory where the user is able to add, delete, and list items\n" +
				"Please enter the question number or name, or 'q' to quit > ");
			String option = inputReader.nextLine().toUpperCase().strip();
			// Add padding for output
			System.out.println();
			// Check for every option
			switch(option) {
				case "3":
				case "THREE":
				case "RANDOM STATS":
					randomStats();
					break;
				case "13":
				case "THIRTEEN":
				case "PENNY PITCH":
					pennyPitch();
					break;
				case "16":
				case "SIXTEEN":
				case "INVENTORY":
					inventory();
					break;
				case "Q":
				case "QUIT":
					running = false;
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Sorry, I don't know what you mean!");
			}
			// Add padding for output
			System.out.println();
		}
	}

	/**
	 * Generates random numbers from 0 to 9 inclusive and puts it into a frequency table
	 */ 
	private static void randomStats() {
		// Create a new array for occurences
		int occurences[] = new int[10];
		// Generate a five hundred random numbers, then increment the occurence at the number's index
		for(int i = 0; i < 500; i++) {
			occurences[randomGenerator.nextInt(10)]++;
		}
		// Display the occurences
		System.out.println("Number\tOccurences");
		for(int i = 0; i < 10; i++) {
			System.out.printf("%d\t%d\n", i, occurences[i]);
		}
	}

	/**
	 * Simulates a penny pitch game and then informs the user about the prizes won
	 */
	private static void pennyPitch() {
		// Reset the board
		fillBoard();
		displayBoard();
		// Simulate ten rounds
		for(int i = 0; i < 10; i++) {
			playRound();
		}
		// Loop for every prize, if the coin lands on more than two spots of the same prize, the user has won the prize.
		// Check if the user has won something with a running boolean flag.
		boolean wonSomething = false;
		for(int i = 1; i < 6; i++) {
			if(prizes[i] > 2) {
				System.out.printf("Player wins a %s!\n", idToPrize[i].strip());
				wonSomething = true;
			}
		}
		// If the user has not won anything, inform the user.
		if(!wonSomething) {
			System.out.println("Player did not win anything :(((");
		}
	}

	/**
	 * Displays the board for the penny pitch game
	 */
	private static void displayBoard() {
		// Print each square, surrounded by square brackets to avoid confusion
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("[%s]", idToPrize[board[i * 5 + j]]);
			}
			System.out.println();
		}
	}

	/**
	 * Fill the board with three spaces of each prize
	 */
	private static void fillBoard() {
		for(int i = 1; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				int tile = 0;
				// Run until the tile is empty, the place the prize on the board.
				do {
					tile = randomGenerator.nextInt(25);
				} while(board[tile] != 0);
				board[tile] = i;
			}
		}
	}

	/**
	 * Simulates a round of the game
	 */
	private static void playRound() {
		// Pick a random spot to land the coin on
		int spot = randomGenerator.nextInt(25);
		int prize = board[spot];
		// If the coin lands on a spot with a prize, remove the prize from the spot to avoid double counting
		board[spot] = 0;
		// Increment the running counter for the spaces that the coin has landed on.
		prizes[prize]++;
	}

	/**
	 * Simulates an inventory system with the ability to list, add, and discontinue items
	 */
	private static void inventory() {
		// Check if there are already items in the inventory, ask user if they want to clear the inventory, or resume from the previous state
		if(itemName.size() > 0 || itemQuantity.size() > 0) {
			System.out.print(
				"It seems that there are items stored from a previous session, would you like to:\n" + 
				"\t1. resume, or\n" +
				"\t2. start a new one?\n" +
				" > ");
			int choice = inputReader.nextInt();
			inputReader.nextLine();
			if(choice == 2) {
				// If the user has decided to start a new inventory, clear the inventory lists by creating a new one
				itemName = new ArrayList<String>();
				itemQuantity = new ArrayList<Integer>();
			}
		}
		// Set a flag for the while loop
		boolean running = true;
		while (running) {
			// Ask user for choice, run based on choice
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
	
	/**
	 * Lists the items in the inventory
	 */
	private static void listItems() {
		// Tell user the number of items in the inventory, along with the details of each individual item
		System.out.printf("There are currently %d item(s) in your inventory:\n", itemName.size());
		System.out.println("S/N\tQTY\tNAME");
		for(int i = 0; i < itemName.size(); i++) {
			System.out.printf("%d\t%d\t%s\n", i + 1000, itemQuantity.get(i), itemName.get(i));
		}
		System.out.println();
	}

	/**
	 * Adds an item to the inventory
	 */
	private static void addItem() {
		// Prompt user for the item name and quantity, then add them to their corresponding lists
		System.out.printf("Please enter the item name:\n > ");
		String name = inputReader.nextLine();
		itemName.add(name);
		System.out.printf("Please enter its quantity:\n > ");
		int qty = inputReader.nextInt();
		inputReader.nextLine();
		itemQuantity.add(qty);
		// Tell user the new stock number
		System.out.printf("The new item's stock number is: %d.\n\n", itemName.size() + 999);
	}

	private static void discontinueItem() {
		// Display a list for ease of use
		listItems();
		// Prompt user for the stock number
		System.out.print("Please enter the stock number of the item you want to discontinue:\n > ");
		int sn = inputReader.nextInt();
		inputReader.nextLine();
		// If the item is outside of the range of the list, the item does not exist.
		if(sn - 999 > itemName.size()) {
			System.out.println("This item does not exist.");
		} else {
			// Make necessary changes to discontinue the item
			itemName.set(sn - 1000, "DISCONTINUED");
			itemQuantity.set(sn - 1000, 0);
			System.out.println("The item has been discontinued.");
		}
		// Print a new line for spacing
		System.out.println();
	}

}