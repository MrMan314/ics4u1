/*
 * E4.java
 * Exercise 4: Mad-Lib
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;
import java.util.ArrayList;

public class E4 extends Problem {
	/**
	 * Constructor
	 * pre: none
	 * post: E4 problem created
	 */
	public E4() {
		super(4, "Mad-Lib", "Generates a random story using random verbs and nouns");
	}

	/**
	 * Function to run for problem
	 * pre: none
	 * post: word count problem run
	 */
	public void run() {
		Random randomGenerator = new Random();
		
		// Create file objects
		File story = new File("story.txt");
		File verbs = new File("verbs.txt");
		File nouns = new File("nouns.txt");

		// Create lists for verbs and nouns
		ArrayList<String> verbList = new ArrayList<String>();
		ArrayList<String> nounList = new ArrayList<String>();

		try {
			// Read nouns into an ArrayList
			BufferedReader nounsReader = new BufferedReader(new FileReader(nouns));
			while(nounsReader.ready()) {
				nounList.add(nounsReader.readLine());
			}
			nounsReader.close();

			// Read verbs into an ArrayList
			BufferedReader verbsReader = new BufferedReader(new FileReader(verbs));
			while(verbsReader.ready()) {
				verbList.add(verbsReader.readLine());
			}
			verbsReader.close();
			
			// Read story
			BufferedReader storyReader = new BufferedReader(new FileReader(story));
			char readCharacter;
			while(storyReader.ready()) {
				// Read character by character
				readCharacter = (char) storyReader.read();
				if (readCharacter == '#') {
					System.out.print(nounList.get(randomGenerator.nextInt(nounList.size())));
				} else if (readCharacter == '%') {
					System.out.print(verbList.get(randomGenerator.nextInt(verbList.size())));
				} else {
					System.out.print(readCharacter);
				}
			}

			// Close story file
			storyReader.close();
		} catch (IOException e) {
			// Tell user if the program errors
			System.out.printf("Error reading file.\nIOException: %s\n", e.getMessage());
		}
	}
}
