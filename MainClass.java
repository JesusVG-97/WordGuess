import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		WordGuess wordGuess1 = new WordGuess(5);
		WordGuess wordGuess2 = new WordGuess(5);
		WordGuess currentWordGuess;
		int countAttempts = 1;
		boolean gameOver = false;
		int playerNumber = 1;
		
		String word;
		while(!gameOver) {
			if (playerNumber == 1) {
				currentWordGuess = wordGuess1;
				} else {
				currentWordGuess = wordGuess2;
				}
			System.out.print("Player " + playerNumber + " Error one character or your guess word ");
			word = input.nextLine();
			currentWordGuess.checkword(word);
			System.out.println("Attempt " + countAttempts + ": " + currentWordGuess.toString() + " Errors " + currentWordGuess.getCountErrors());
			
			if (currentWordGuess.hasLost()) {
				System.out.println("You lost Player " + playerNumber);
				gameOver = true;
			}
			if (currentWordGuess.hasWon()) {
				System.out.println("You win Player " + playerNumber);
				gameOver = true;
			}
			if (playerNumber == 2) {
			countAttempts ++;
			}
			if (playerNumber == 1) {
				playerNumber = 2;
			} else {
				playerNumber = 1;
			}
		}
		input.close();
		
	}
	

}
