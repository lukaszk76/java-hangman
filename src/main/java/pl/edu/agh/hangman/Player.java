package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private String word;
	private ArrayList<String> guessedLetters = new ArrayList();
	private IWordProvider wordProvider = new WordProviderFromWeb();
	private HangmanDisplay hangmanDisplayer = new HangmanDisplay();
	private Scanner scanner = new Scanner(System.in);
	
	public void play() {
		word = wordProvider.nextWord().toLowerCase();
		
		boolean won = false;
		
		for (int round = 0; round <7; round++ ){
				String letter = this.guess();
				if (checkResult(letter)) {
					System.out.println("you won!!!");
					won = true;
				}
				else {
					hangmanDisplayer.nextImage(round);
				}
			}
		if (!won) {
			System.out.println("You are a hangman!!!");
			System.out.println("The word is: " + word);
		}
		
	}
	
	
	private String  guess() {
		System.out.print("guess >>> ");
		String guess = scanner.next();
		if (guess.length() > 1) {
			guess = guess.substring(0, 1);
		}
		return guess;		
	}
	
	
	private boolean checkResult(String guess) {
		if (word.equals(this.displayMask(guess))){
			return true;
		} 
		return false;
	}
	
	private String displayMask(String guess) {
		
		for (int i = 0; i<word.length(); i++) {
			if (word.substring(i, i+1).equals(guess)) {
				guessedLetters.add(guess);
				break;
			}
		}
		
		String mask = "";
		
		for (int i = 0; i<word.length(); i++) {
			
			String letter = word.substring(i, i+1);
			boolean found = false;
			for (String guessedLetter: guessedLetters) {
				if (letter.equals(guessedLetter)) {
					mask = mask.concat(letter);
					found = true;
					break;
				} 		
			}
			
			if (!found) { 
				mask = mask.concat("_");
			}
		}
		System.out.println(mask);
		return mask;
	}
	
	
}
