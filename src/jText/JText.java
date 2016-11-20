/**
 * 
 */
package jText;

import java.awt.event.*;

import javax.swing.*;

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
		    	int confirm = JOptionPane.showOptionDialog(null, 
						"Are You Sure to Close Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
			             JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
		    }
		};
		view.addWindowListener(exitListener);	
		
		view.setSize(600, 500);
		view.setVisible(true);
		
	}

}
