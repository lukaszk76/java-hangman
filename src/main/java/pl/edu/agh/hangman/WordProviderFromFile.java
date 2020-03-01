package pl.edu.agh.hangman;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordProviderFromFile implements IWordProvider {

	ArrayList<String> words = new ArrayList<String>();
	String word = null;
	
	public ArrayList<String> loadWord() {
		//File file = new File("C:\\Users\\student12\\hangman\\java-hangman\\src\\main\\resources\\slowa.txt");
		File file = new File("C:\\Users\\student3\\downloads\\java-hangman\\src\\main\\resources\\slowa.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				words.add(sc.nextLine());
			}
			//System.out.println(words);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return words;
	}
	
	
	public String nextWord() {
	    Random randomGenerator = new Random();
	    words = loadWord();
        int index = randomGenerator.nextInt(words.size());
     //   word = words.get(index);
	//	System.out.println(word);
        return (words.get(index));
	}
}
