/**
 * 
 */
package jText;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

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
				JTextControllerSaveAs saveAs;
				@SuppressWarnings("unused")
				JTextControllerSave save;
				int confirm = JOptionPane.showOptionDialog(null, 
						"Are You Sure to Close Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
			             JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == JOptionPane.YES_OPTION) {
					String message = "Do you want to save the file?";
		            String title = "Warning";
		            int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
		            if(reply == JOptionPane.YES_OPTION){
		            	if(model.getName().equals("")){ //Same as saveAs
		    				try {
		    					saveAs = new JTextControllerSaveAs();
		    					String str = view.getText();
		    					saveAs.saveText(str);
		    					model.setName(saveAs.getName());
		    				} catch (IOException e1) {
		    					if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
		    						System.exit(0);
		    					}
		    					System.err.println(e1 + "\n");
		    				}
		    			} else{ //Use current file name
		    				File file = new File(model.getName());
		    				String str = view.getText();
		    				save = new JTextControllerSave(file, str);
		    			}
		            }
					System.exit(0);
				}
		    }
		};
		view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		view.addWindowListener(exitListener);
		view.setSize(600, 500);
		view.setVisible(true);
	}
}
