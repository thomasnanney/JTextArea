package jText;
import com.inet.jortho.SpellChecker;

import javax.swing.JMenu;
import javax.swing.text.JTextComponent;

import com.inet.jortho.FileUserDictionary;

public class SpellCheck {
	public SpellCheck(){
				//FILE LOCATION OF DICTIONARY
				String userDictionaryPath = "/dictionary/";

				//SET DICTIONARY PROVIDER FROM DICTIONARY PATH
				SpellChecker.setUserDictionaryProvider(new FileUserDictionary(null));

				//REGISTER DICTIONARY
				SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "en");

	}
	public JMenu addMenu(){
		return SpellChecker.createCheckerMenu();
	}
	
	public void initialiseSpellChecker(JTextComponent textPane) {
		SpellChecker.enableAutoSpell(textPane, true);
		SpellChecker.register(textPane, false, true, true, true);
		
	}
	
	public void getDialogBox(JTextComponent textPane){
		SpellChecker.showSpellCheckerDialog(textPane, null);
	}
	

	public JMenu getSpellCheckerMenu(){
		return SpellChecker.createCheckerMenu();
	}

}
