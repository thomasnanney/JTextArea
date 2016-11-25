package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;

public class JTextParagraphHandler implements ActionListener{
	private JTextPane textPane;
	
	public JTextParagraphHandler(JTextView view){
		this.textPane = view.getPane();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
