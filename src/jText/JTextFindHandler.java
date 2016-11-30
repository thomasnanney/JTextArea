package jText;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
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
	private JTextPane textPane;
	private int action = 0; //0 == find, 1 == find all
	private int sCase = 1; //1 == case sensitive, -1 == ignore case
	private int wholeWord = 1; //1 == not whole word, -1 == whole word
	private int endIndex = 0;
	private String lastWord = "";
	private int iter = 0;
	
	public JTextFindHandler(JTextField field, JTextView view){
		this.field = field;
		this.view = view;
		this.textPane = view.getPane();
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
				sCase *= -1;
				break;
			case "Whole Word":
				wholeWord *= -1;
				break;
			default:
				int p0, p1, end;
				String match = field.getText();
				String str = view.getText();
				Highlighter highlighter = textPane.getHighlighter();
				highlighter.removeAllHighlights();
			    HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
			    if(sCase == -1){
	    			match = match.toLowerCase();
	    			str = str.toLowerCase();
	    		}
			    switch(action){
			    	case 0: //Find
			    		if(wholeWord == -1){
			    			Pattern p = Pattern.compile("\\b" + match + "\\b");
			    			Matcher m = p.matcher(str);
			    			if (m.find()) {
			    				int position = m.start();
			    				int original = position;
			    				if(lastWord.equals(match)){
			    					iter++;
					    			int i = iter;
			    					while(i > 0){
			    						if(m.find()){
						    				position = m.start();
						    			} else{
						    				iter = 0;
						    				position = original;
						    			}
			    						i--;
			    					}
					    		} else{
					    			lastWord = "";
					    			iter = 0;
					    		}
			    				try {
			    					highlighter.addHighlight(position, position + match.length(), painter);
			    				} catch (BadLocationException e1) {
			    					System.err.println(e1 + "\n");
			    					}
			    			} else{
			    				String message = "Word: " + match + " not found.";
					            String title = "Error";
					            JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
						    	return;
			    			}
			    			lastWord = match;
			    			break;
			    		}
			    		if(!str.contains(match)){
			    			String message = "Word: " + match + " not found.";
				            String title = "Error";
				            JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
					    	return;
			    		}
			    		p0 = str.indexOf(match);
			    		p1 = p0 + match.length();
			    		if(lastWord.equals(match)){
			    			if(str.indexOf(match, endIndex) > 0){
			    				p0 = str.indexOf(match, endIndex);
			    				p1 = p0 + match.length();
			    			}
			    		} else{
			    			lastWord = "";
			    		}
			    		endIndex = p1;
			    		try {
							highlighter.addHighlight(p0, p1, painter);
						} catch (BadLocationException e1) {
							System.err.println(e1 + "\n");
						}
			    		lastWord = match;
			    		break;
			    	case 1: //Find All
			    		if(wholeWord == -1){
			    			Pattern p = Pattern.compile("\\b" + match + "\\b");
			    			Matcher m = p.matcher(str);
			    			int count = 0;
			    			while(m.find()) {
			    				count ++;
			    				int position = m.start();
				    			try {
				    				highlighter.addHighlight(position, position + match.length(), painter);
								} catch (BadLocationException e1) {
									System.err.println(e1 + "\n");
								}
			    			}
			    			if(count == 0){
			    				String message = "Word: " + match + " not found.";
					            String title = "Error";
					            JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
						    	return;
			    			}
			    			break;
			    		}
			    		if(!str.contains(match)){
			    			String message = "Word: " + match + " not found.";
				            String title = "Error";
				            JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
					    	return;
			    		}
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
