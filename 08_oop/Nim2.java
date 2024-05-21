/**
 * Nim2 class for E5
 */

import java.util.Random;

public class Nim2 {

	// Random number generator for the game
	private Random randomGenerator = new Random();

	// Stone count variable
	private int stoneCount;

	// Set stone count to a random value between 15 and 30 on initialization
	public Nim2() {
		stoneCount = randomGenerator.nextInt(16) + 15;
	}

	/**
	 * Player plays a round, returns 0 if the input is valid, 1 otherwise.
	 */
	public int playerPlay(int takeCount) {
		// Only allow the player to take 1 to 3 stones, and less if the stone count is 3 or less
		if (takeCount < 4 && takeCount < stoneCount && takeCount > 0) {
			// Decrement the stone count and return 0
			stoneCount -= takeCount;
			return 0;
		}
		// Return 1 if the input is invalid
		return 1;
	}

	/**
	 * Computer plays a round
	 * Returns 0 if the player wins
	 * Returns the number of stones taken, but negative if the computer wins
	 * Returns the number of stones taken otherwise
	 */
	public int computerPlay() {
		// Initialize variable 
		int playCount = 0;
		// If there is only one stone remaining, the player wins
		if (stoneCount < 2) {
			return 0;
		}
		// If the stone count is less than 4, the computer can only take stones from 1 to the number of stones minus one
		if (stoneCount < 4) {
			playCount = randomGenerator.nextInt(stoneCount - 1) + 1;
		} else {
			// Otherwise, the computer takes a random amount of stones between 1 and 3
			playCount = randomGenerator.nextInt(3) + 1;
		}
		// Decrement the stone count
		stoneCount -= playCount;
		// If there is only one stone remaining, the computer wins, return the negative play count
		if (stoneCount < 2) {
			return -playCount;
		} else {
			// Otherwise, just return the play count
			return playCount;
		}
	}

	public int getStoneCount() {
		return stoneCount;
	}
}
