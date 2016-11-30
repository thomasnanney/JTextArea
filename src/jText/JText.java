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
		
		final JTextModel model = new JTextModel();
		final JTextView view = new JTextView(model);
		JTextController controller = new JTextController(model,view);
		JTextKeyController keyController = new JTextKeyController(view);
		keyController.registerKeyListener(controller);
		view.registerListener(controller);
		
		
		WindowListener exitListener = new WindowAdapter() {
		    
			@Override
		    public void windowClosing(WindowEvent e) {
				if(view.titleChange()){
					JTextCheckSave checkSave = new JTextCheckSave(view, model);
					checkSave.promptSaveExit();
				} else{
					System.exit(0);
				}
		    }
		};
		view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		view.addWindowListener(exitListener);
		view.setVisible(true);
	}
}
