/*
 * E1.java
 * Exercise 1: Word Count
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class E1 extends Problem {
	/**
	 * Constructor
	 * pre: none
	 * post: E1 problem created
	 */
	public E1() {
		super(1, "Word count", "Counts the words in a file");
	}

	/**
	 * Function to run for problem
	 * pre: none
	 * post: word count problem run
	 */
	public void run() {
		// Create a file object
		File file = new File("source.txt");
		try {
			// Create file stream and read from it using BufferedReader
			FileReader fileStream = new FileReader(file);
			BufferedReader fileRead = new BufferedReader(fileStream);

			// Initialize counter variables and character reads, "read" is past tense
			char readCharacter;
			int wordCount = 1, charCount = 0;
			boolean lastCharWasLetter = false;

			// Read new character until end of file
			while (fileRead.ready()) {
				readCharacter = (char) fileRead.read();
				// Increment the word count if a non letter is read, increment letter count otherwise
				if(isLetter(readCharacter)) {
					charCount++;
					lastCharWasLetter = true;
				} else {
					// Prevent bogus word count increments from sequential characters
					if(lastCharWasLetter) {
						wordCount++;
					}
					lastCharWasLetter = false;
				}
			}

			// Account for edge case where file is empty
			if (charCount == 0) {
				wordCount = 0;
			}

			// Account for edge case where file ends with characters
			if (!lastCharWasLetter) {
				wordCount--;
			}

			// Tell user the statistics of the file
			System.out.printf(
				"Characters: %d\n" +
				"Words: %d\n" +
				"Average word length: %.2f\n",
				charCount,
				wordCount,
				(wordCount == 0 ? 0f : (float) charCount / (float) wordCount) // Account for edge case to avoid division by zero
			);
			
			// Close file streams
			fileStream.close();
			fileRead.close();
		} catch (IOException e) {
			// Tell user if the program errors
			System.out.printf("Error reading file.\nIOException: %s\n", e.getMessage());
		}
	}

	/**
	 * Function to check if the given character is a letter
	 * pre: none
	 * post: returns a boolean telling whether the character is a letter
	 */
	public boolean isLetter(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}
}
