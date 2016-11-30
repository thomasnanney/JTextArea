package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JTextParagraphHandler implements ActionListener{
	private JTextPane textPane;
	
	public JTextParagraphHandler(JTextView view){
		this.textPane = view.getPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<?> cb = (JComboBox<?>)e.getSource();
		String para = (String)cb.getSelectedItem();
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet newSet = new SimpleAttributeSet();
		switch(para){
			case "Left":
				StyleConstants.setAlignment(newSet, StyleConstants.ALIGN_LEFT);
				break;
			case "Center":
				StyleConstants.setAlignment(newSet, StyleConstants.ALIGN_CENTER);
				break;
			case "Right":
				StyleConstants.setAlignment(newSet, StyleConstants.ALIGN_RIGHT);
				break;
		}
		doc.setParagraphAttributes(0, doc.getLength(), newSet, false);
	}
	
	public void action(String e){
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet newSet = new SimpleAttributeSet();
		switch(e){
			case "Left":
				StyleConstants.setAlignment(newSet, StyleConstants.ALIGN_LEFT);
				break;
			case "Center":
				StyleConstants.setAlignment(newSet, StyleConstants.ALIGN_CENTER);
				break;
			case "Right":
				StyleConstants.setAlignment(newSet, StyleConstants.ALIGN_RIGHT);
				break;
		}
		doc.setParagraphAttributes(0, doc.getLength(), newSet, false);
	}
}
