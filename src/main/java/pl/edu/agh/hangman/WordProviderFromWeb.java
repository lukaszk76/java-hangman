package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class WordProviderFromWeb implements IWordProvider {

    private String readFromWeb() throws Exception {

    	URL url = new URL("http://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5");
        BufferedReader pobierz = new BufferedReader(
                              new InputStreamReader(
                               url.openStream()   // zwraca InputStream związany z URLem
                               )
                               );
        String temp;
        String s = "";
        while ((temp = pobierz.readLine()) != null) {
              s +=(temp + "\n");
              }

        pobierz.close();

        return s;
    }
    
	@Override
	public String nextWord()  {
		String word = "";
		
		try {
			word = this.readFromWeb();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println(word);
		return word;
	}

	
}
