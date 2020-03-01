package pl.edu.agh.hangman;

import java.util.Scanner;

public class WordProviderFromKeyboard implements IWordProvider{

	@Override
	public String nextWord() {
		String word = null;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a word:");
		word = keyboard.next();
		keyboard.close();
		return word;
	}

}
