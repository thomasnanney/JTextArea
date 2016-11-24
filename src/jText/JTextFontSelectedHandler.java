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
	    
	    Element element = doc.getCharacterElement(start);
	    AttributeSet as = element.getAttributes();
	    
	    StyleContext sc = new StyleContext();
		Style style = sc.addStyle("", null);
		switch(evt.getActionCommand()){
			case "Bold":
				if(StyleConstants.isBold(as))
					sc.removeStyle("bold");
				else{
					style = sc.addStyle("bold", null);
					StyleConstants.setBold(style, true);
				}
				break;
			case "Italic":
				if(StyleConstants.isItalic(as))
					sc.removeStyle("italic");
				else{
					style = sc.addStyle("italic", null);
					StyleConstants.setItalic(style, true);
				}
				break;
			case "Underline":
				if(StyleConstants.isUnderline(as))
					sc.removeStyle("underline");
				else{
					style = sc.addStyle("underline", null);
					StyleConstants.setUnderline(style, true);
				}
				break;
			case "Default":
				style = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
				break;
		}
		doc.setCharacterAttributes(start, end - start, style, true);
	}      
}
