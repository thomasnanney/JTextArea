package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * This class will open a recentFile from 
 * 	the Open Recent JMenu
 * 
 * @author Jose Bocanegra
 */
public class JTextRecentController implements ActionListener{
	
	private JTextModel model;
	private JTextView view;
	private JTextControllerOpen open;
	private JTextRecent recent;
	
	public JTextRecentController(JTextModel model, JTextView view, JTextRecent recent){
		this.model = model;
		this.view = view;
		this.recent = recent;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(view.titleChange()){
			JTextCheckSave checkSave = new JTextCheckSave(view, model);
			checkSave.promptSave();
		}
		try {
			File file = new File(e.getActionCommand());
			if(!file.exists()){
				String message = "File • " + file.getName() + " • does not exist in \n" + file.getParent() + ":\n" + "Removed " + file.getName() + " from recent files.";
				String title = "Warning";
				JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
				recent.eRemove(file.getPath());
				return;
			}
			open = new JTextControllerOpen(file);
			String str = open.returnString();
			model.setName(open.getName());
			view.setArea(str);
		} catch (FileNotFoundException e1) {
			System.err.println(e1 + "\n");
		} finally{
			view.setTitle("JText: A simple text editor - " + model.getName());
		}
	}
}
