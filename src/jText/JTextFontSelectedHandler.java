package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;

/**
 * This class handles retrieving selected
 * 	text and replacing it with the same string
 * 	but with the selected style.
 * 
 * @author Jose Bocanegra
 */
public class JTextFontSelectedHandler implements ActionListener{

	private JTextPane pane;
	private StyledDocument doc;
	
	public JTextFontSelectedHandler(JTextPane pane){
		this.pane = pane;
		this.doc = pane.getStyledDocument();
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
	    int start = pane.getSelectionStart();
	    int end = pane.getSelectionEnd();
	    if (start == end) { //No text selected
	        return;
	    }
	    StyleContext sc = new StyleContext();
		Style style = sc.addStyle("", null);
		switch(evt.getActionCommand()){
			case "Bold":
				StyleConstants.setBold(style, true);
				break;
			case "Italic":
				StyleConstants.setItalic(style, true);
				break;
			case "Underline":
				StyleConstants.setUnderline(style, true);
		}
		
		try {
			String str = pane.getText(start, end - start);
			doc.remove(start, end - start);
			doc.insertString(start, str, style);
		} catch (BadLocationException e) {
			System.err.println(e + "\n");
		}
	}      
}
