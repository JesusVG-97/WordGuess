
public class WordGuess {

	public static final String[] WORDS = {"raton", "habitacion", "mesa"};
	private String hiddenword;
	private boolean[] guessedLetters;
	private int maxErrors;
	private int countErrors;
	
	public WordGuess (int maxErrors) {
		this.maxErrors = maxErrors;
		countErrors = 0;
		hiddenword = generateHiddenWord();
		guessedLetters = generateGuessedLetters();
	}
	
	private String generateHiddenWord() {
		int randomWordIndex = (int) (Math.random()* WORDS.length);
		return WORDS[randomWordIndex];
	}

	private boolean[] generateGuessedLetters() {
		boolean[] b = new boolean [hiddenword.length()];
			for (int i = 0; i < b.length; i++) {
				b[i] = false;	
		}
		return b;
	}

	public void checkword (String word){
		word = word.toLowerCase();
		if (word.length() == 1) {
			boolean error = true;
			for (int i = 0; i < hiddenword.length(); i++) {
				if (word.charAt(0) == hiddenword.charAt(i)) {
					guessedLetters[i] = true;
					error = false;
				}
			}
			if (error ) {
				countErrors ++;
			}
			
		} else {
			if (word.equals(hiddenword)) {
				for (int i = 0; i < hiddenword.length(); i++) {
					guessedLetters[i] = true;
				}
			} else {
				countErrors ++;
			}
		}
	}
		@Override
	public String toString(){
			String s = "";
			for (int i = 0; i < guessedLetters.length; i++) {
				if (guessedLetters[i]) {
					s = s + hiddenword.charAt(i);
				} else {
					s = s + "-";
				}
			}
		return s;
	}
		public boolean hasLost() {
			if (countErrors == maxErrors) {
				return true;
				
			} else {
				return false;
			}
		}
		public boolean hasWon() {
			for (int i = 0;i < guessedLetters.length; i++) {
			if (!guessedLetters[i]) {
				
				return false;
				} 
			}
			return true;
		}

		public int getCountErrors() {
			return countErrors;
		}
		
}
