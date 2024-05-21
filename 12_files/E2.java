/*
 * E2.java
 * Exercise 2: Word Stats
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Comparator;

public class E2 extends Problem {
	/**
	 * Constructor
	 * pre: none
	 * post: E2 problem created
	 */
	public E2() {
		super(2, "Word Stats", "Counts the words' occurences in a file");
	}

	/**
	 * Function to run for problem
	 * pre: none
	 * post: word count problem run
	 */
	public void run() {
		// Create a file object
		File file = new File("E2.txt");
		try {
			// Create file stream and read from it using BufferedReader
			FileReader fileStream = new FileReader(file);
			BufferedReader fileRead = new BufferedReader(fileStream);
			ArrayList<String> wordList = new ArrayList<String>();

			// Initialize counter variables and character reads, "read" is past tense
			char readCharacter;
			boolean lastCharWasLetter = false;
			String currentWord = "";

			// Read new character until end of file
			while (fileRead.ready()) {
				readCharacter = (char) fileRead.read();
				// Increment the word count if a non letter is read, increment letter count otherwise
				if(isLetter(readCharacter)) {
					currentWord += Character.toLowerCase(readCharacter);
					lastCharWasLetter = true;
				} else {
					// Prevent bogus word count increments from sequential characters
					if(lastCharWasLetter) {
						wordList.add(currentWord);
						currentWord = "";
					}
					lastCharWasLetter = false;
				}
			}

			// Account for edge case where file ends with characters
			if (lastCharWasLetter) {
				wordList.add(currentWord);
			}

			// Sort the word list
			wordList.sort(Comparator.naturalOrder());

			// Initialize counters
			String lastWord = "";
			int count = 0;

			// Print header
			System.out.println("WORD\tOCCURENCES");
			
			for(String word: wordList) {
				if(lastWord.equals("")) {
					// Start case
					lastWord = word;
					System.out.printf("%s\t", word);
				} else if (!lastWord.equals(word)) {
					// Show count of last word when new word is reached
					System.out.printf("%d\n%s\t", count, word);
					// Reset counters
					lastWord = word;
					count = 0;
				}
				// Increment counters
				count++;
			}
			// Show count of last word
			System.out.println(count);

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
