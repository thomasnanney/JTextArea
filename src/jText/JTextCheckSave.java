package jText;

import java.io.*;

import javax.swing.*;

/**
 * This class will be used to prompt save of the file
 * 	with two different methods that end in different
 * 	ways, one returning normally if the user hits 
 * 	cancel on save and the other exiting.
 * 
 * @author Jose Bocanegra
 */
public class JTextCheckSave {

	private JTextView view;
	private JTextControllerSaveAs saveAs;
	@SuppressWarnings("unused")
	private JTextControllerSave save;
	private JTextModel model;
	
	public JTextCheckSave(JTextView view, JTextModel model){
		this.view = view;
		this.model = model;
	}
	
	public void promptSave(){
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
					view.setTitle("JText: A simple text editor - " + model.getName());
				} catch (IOException e1) {
					if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
						return;
					}
					System.err.println(e1 + "\n");
				}
			} else{ //Use current file name
				File file = new File(model.getName());
				String str = view.getText();
				save = new JTextControllerSave(file, str);
				view.setTitle("JText: A simple text editor - " + model.getName());
			}
        }
	}
	
	public void promptSaveExit(){
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
					message = "File successfully saved!";
			        title = "Saved";
					JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
				} catch (IOException e1) {
					if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
						return;
					}
					System.err.println(e1 + "\n");
				}
			} else{ //Use current file name
				File file = new File(model.getName());
				String str = view.getText();
				save = new JTextControllerSave(file, str);
				message = "File successfully saved!";
		        title = "Saved";
				JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
			}
        } else if(reply == JOptionPane.CLOSED_OPTION){
        	return;
        }
        System.exit(0);
	}
}
