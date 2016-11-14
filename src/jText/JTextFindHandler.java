package jText;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class JTextFindHandler implements ActionListener{
	
	private JTextField field;
	private JTextView view;
	
	public JTextFindHandler(JTextField field, JTextView view){
		this.field = field;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent event) {
		String match = field.getText();
		if(match.equals("")){return;}
		JTextArea area = view.getArea();
		String str = view.getText();
		if(!str.contains(match)){return;}
		Highlighter highlighter = area.getHighlighter();
	    HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
	    int p0 = str.indexOf(match);
	    int p1 = p0 + match.length();
	    try {
			highlighter.addHighlight(p0, p1, painter);
		} catch (BadLocationException e1) {
			System.err.println(e1 + "\n");
		}
	}
}
