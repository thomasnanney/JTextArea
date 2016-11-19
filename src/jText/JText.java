/**
 * 
 */
package jText;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.Highlighter;

/**
 * @authors Daniel Larsen, Thomas Nanney, Jacob Lahav, Jose Bocanegra, Baraon Gallegos
 *
 */
public class JText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JTextModel model = new JTextModel();
		JTextView view = new JTextView(model);
		JTextController controller = new JTextController(model,view);
		JTextKeyController keyController = new JTextKeyController(view);
		keyController.registerKeyListener(controller);
		view.registerListener(controller);
		
		WindowListener exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "Are You Sure to Close Application?", 
		             "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == JOptionPane.YES_OPTION) {
		        	System.exit(0);
		        }
		    }
		};
		view.addWindowListener(exitListener);	
		
		view.setSize(600, 500);
		view.setVisible(true);	
		int i = 0;
		for (;;){
			if(view.length()>i){
				/**
				 * Checks to see if there are
				 * 	any words highlighted. If there are, 
				 * 	remove the highlight 
				 * This is for Find function that highlights
				 * 	words, we don't want the words to
				 * 	stay highlighted.
				 */
				Highlighter highlighter = view.getArea().getHighlighter();
				if(highlighter.getHighlights().length > 0){
					highlighter.removeAllHighlights();
				}
				/*
				 * End of highlight
				 */
				i++;
				
			}
			
		}
		
	}

}
