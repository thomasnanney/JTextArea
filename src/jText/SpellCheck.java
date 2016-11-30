package jText;
import com.inet.jortho.SpellChecker;

import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

import com.inet.jortho.FileUserDictionary;

public class SpellCheck {
	public void initialiseSpellChecker(JTextComponent textPane) {
		//FILE LOCATION OF DICTIONARY
		String userDictionaryPath = "/dictionary/";

		//SET DICTIONARY PROVIDER FROM DICTIONARY PATH
		SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath));

		//REGISTER DICTIONARY
		SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "en");
		
		SpellChecker.register(textPane);
		
	}
}
