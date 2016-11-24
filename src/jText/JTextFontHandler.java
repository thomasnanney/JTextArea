package jText;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.*;

public class JTextFontHandler implements ActionListener{
	private JTextPane textPane;
	
	public JTextFontHandler(JTextView view){
		this.textPane = view.getPane();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Font f = textPane.getFont();
		StyledDocument doc = textPane.getStyledDocument();
		if(e.getActionCommand().equals("comboBoxChanged")){
			JComboBox<?> cb = (JComboBox<?>)e.getSource();
			String font = (String)cb.getSelectedItem();
			/**
			 * For styles
			 */
			Element element = doc.getCharacterElement(0);
		    AttributeSet as = element.getAttributes();
		    StyleContext sc = new StyleContext();
		    Style style = sc.addStyle("", null);
			switch(font){ //Font and Style
				case "Bold":
					if(StyleConstants.isBold(as))
						sc.removeStyle("bold");
					else{
						style = sc.addStyle("bold", null);
						StyleConstants.setBold(style, true);
					}
					doc.setCharacterAttributes(0, doc.getLength(), style, true);
					break;
				case "Italic":
					if(StyleConstants.isItalic(as))
						sc.removeStyle("italic");
					else{
						style = sc.addStyle("italic", null);
						StyleConstants.setItalic(style, true);
					}
					doc.setCharacterAttributes(0, doc.getLength(), style, true);
					break;
				case "System":
					textPane.setFont(new Font("System", f.getStyle(), f.getSize()));
					break;
				case "Serif":
					textPane.setFont(new Font(Font.SERIF, f.getStyle(), f.getSize()));
					break;
				case "Monospaced":
					textPane.setFont(new Font(Font.MONOSPACED, f.getStyle(), f.getSize()));
					break;
			}
		}
		else{ //Size
			textPane.setFont(new Font(f.getFontName(), f.getStyle(), Integer.parseInt(e.getActionCommand())));
		}
	}
}
