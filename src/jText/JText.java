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
		JTextColor fontColor = new JTextColor(view);
		JTextColorController colorController = 
				new JTextColorController(fontColor);
		JTextPane pane = view.getPane();
		pane.setDocument(colorController.getDefaultDoc());
		
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
