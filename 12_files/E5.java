/*
 * E5.java
 * Exercise 5: Merge Files
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class E5 extends Problem {
	/**
	 * Constructor
	 * pre: none
	 * post: E5 problem created
	 */
	public E5() {
		super(5, "Merge Files", "Merges two files containing numbers into one");
	}

	/**
	 * Function to run for problem
	 * pre: none
	 * post: word count problem run
	 */
	public void run() {
		// Create file objects
		File file1 = new File("file1.txt");
		File file2 = new File("file2.txt");

		try {
			// Use Scanner to read files because of easier integer reading
			Scanner fileRead1 = new Scanner(file1);
			Scanner fileRead2 = new Scanner(file2);

			// Initialize counter variables
			int curRead1 = 0, curRead2 = 0;
			boolean pastFirstRun = false;

			// Read until both files are done reading
			while (fileRead1.hasNext() || fileRead2.hasNext()) {
				// Read first file if there is still more to read and the current value is less than second
				if (fileRead1.hasNext() && curRead1 <= curRead2) {
					// We do not want to output the inital variables
					if(pastFirstRun) {
						System.out.println(curRead1);
					}
					// Read next value
					curRead1 = fileRead1.nextInt();
				}

				// Read second file if there is still more to read and the current value is less than first
				if (fileRead2.hasNext() && curRead2 <= curRead1) {
					// We do not want to output the initial variables
					if(pastFirstRun) {
						System.out.println(curRead2);
					}
					// Read next value
					curRead2 = fileRead2.nextInt();
					// We want to output the file values, set flag
					pastFirstRun = true;
				}

				// Read the rest of the latter file if one file is finished
				if (!fileRead1.hasNext()) {
					while (fileRead2.hasNext()) {
						// Read the file value
						curRead2 = fileRead2.nextInt();
						// Insert the last variable of the completed file into the output if it is in range
						if (curRead1 < curRead2) {
							// Output the values
							System.out.println(curRead1);
							System.out.println(curRead2);
							// Do not use the value again 
							curRead1 = Integer.MAX_VALUE;
						} else {
							// Output the value on its own otherwise
							System.out.println(curRead2);
						}
					}

					// If the other file's read number is not Integer.MAX_VALUE, the value has not yet been used because it is too high
					if (curRead1 != Integer.MAX_VALUE) {
						// Output value
						System.out.println(curRead1);
					}
				}

				// Read the rest of the latter file if one file is finished
				if (!fileRead2.hasNext()) {
					while (fileRead1.hasNext()) {
						// Read the file value
						curRead1 = fileRead1.nextInt();
						// Insert the last variable of the completed file into the output if it is in range
						if (curRead2 < curRead1) {
							// Output the values
							System.out.println(curRead2);
							System.out.println(curRead1);
							// Do not use the value again 
							curRead2 = Integer.MAX_VALUE;
						} else {
							// Output the value on its own otherwise
							System.out.println(curRead1);
						}
					}

					// If the other file's read number is not Integer.MAX_VALUE, the value has not yet been used because it is too high
					if (curRead2 != Integer.MAX_VALUE) {
						// Output value
						System.out.println(curRead2);
					}
				}
			}
			
			// Close files
			fileRead1.close();
			fileRead2.close();
		} catch (IOException e) {
			// Tell user if the program errors
			System.out.printf("Error reading file.\nIOException: %s\n", e.getMessage());
		}
	}
}
