package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextReplaceHandler implements ActionListener{

	private JTextField fieldWord;
	private JTextField fieldNewWord;
	private JTextView view;
	private JTextArea area;
	
	public JTextReplaceHandler(JTextField word, JTextField newWord, JTextView view){
		this.fieldWord = word;
		this.fieldNewWord = newWord;
		this.view = view;
		this.area = view.getArea();
	}
	
	public void actionPerformed(ActionEvent event) {
		String oldWord = fieldWord.getText();
		String newWord = fieldNewWord.getText();
		String str = view.getText();
		str = str.replaceAll("\\b" + oldWord + "\\b", newWord);
		area.setText(str);
	}
}
