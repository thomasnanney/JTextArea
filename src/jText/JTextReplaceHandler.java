package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class will simply replace all instances
 * 	of the specific word given with the 
 * 	new word.
 * 
 * @author Jose Bocanegra
 */
public class JTextReplaceHandler implements ActionListener{

	private JTextField fieldWord;
	private JTextField fieldNewWord;
	private JTextView view;
	private JTextPane textPane;
	
	public JTextReplaceHandler(JTextField word, JTextField newWord, JTextView view){
		this.fieldWord = word;
		this.fieldNewWord = newWord;
		this.view = view;
		this.textPane = view.getPane();
	}
	
	/**
	 * As of now, the word being replaced are whole words, not
	 * 	substrings. (ie. catdog cat, when replacing cat with dog, 
	 * 	will result in catdog dog)
	 */
	public void actionPerformed(ActionEvent event) {
		String oldWord = fieldWord.getText();
		String newWord = fieldNewWord.getText();
		String str = view.getText();
		str = str.replaceAll("\\b" + oldWord + "\\b", newWord);
		textPane.setText(str);
		if(!view.titleChange()){
			view.setTitle(view.getTitle() + "*");
		}
	}
}
