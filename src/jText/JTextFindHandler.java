package jText;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 * This class will activate when the user hits enter on Find
 * 	UserField or when user changes find specifications. Depending on
 * 	the Find specifications (ie. ignore case), this class will 
 * 	highlight the found matches.
 * 
 * @author Jose Bocanegra
 */
public class JTextFindHandler implements ActionListener{
	
	private JTextField field;
	private JTextView view;
	private JTextArea area;
	private int action = 0; //0 == find, 1 == find all
	private int iCase = 1; //1 == case sensitive, -1 == ignore case
	
	public JTextFindHandler(JTextField field, JTextView view){
		this.field = field;
		this.view = view;
		this.area = view.getArea();
	}
	
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
			case "Find":
				action = 0;
				break;
			case "Find All":
				action = 1;
				break;
			case "Ignore Case":
				iCase *= -1;
				break;
			default:
				int p0, p1, end;
				String match = field.getText();
				String str = view.getText();
				Highlighter highlighter = area.getHighlighter();
				highlighter.removeAllHighlights();
			    HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.gray);
			    if(iCase == -1){
	    			match = match.toLowerCase();
	    			str = str.toLowerCase();
	    		}
			    if(!str.contains(match) || match.equals("")){
			    	String message = "Word: " + match + " not found.";
		            String title = "Error";
		            JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
			    	return;
			    }
			    switch(action){
			    	case 0:
			    		p0 = str.indexOf(match);
			    		p1 = p0 + match.length();
			    		try {
							highlighter.addHighlight(p0, p1, painter);
						} catch (BadLocationException e1) {
							System.err.println(e1 + "\n");
						}
			    		break;
			    	case 1:
			    		end = str.lastIndexOf(match);
					    p0 = str.indexOf(match);
					    while(p0 < end){
						    p1 = p0 + match.length();
						    try {
								highlighter.addHighlight(p0, p1, painter);
							} catch (BadLocationException e1) {
								System.err.println(e1 + "\n");
							}
						    p0 = str.indexOf(match, p1);
					    }
					    p1 = end + match.length();
					    try {
							highlighter.addHighlight(end, p1, painter);
						} catch (BadLocationException e1) {
							System.err.println(e1 + "\n");
						}
			    }
	    }
	}
}
