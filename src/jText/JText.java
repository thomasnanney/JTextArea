/**
 * 
 */
package jText;

import javax.swing.JFrame;

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
		
		view.registerListener(controller);
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(600, 500);
		view.setVisible(true);

	}

}
