package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
	
	public JTextRecentController(JTextModel model, JTextView view){
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(view.titleChange()){
			JTextCheckSave checkSave = new JTextCheckSave(view, model);
			checkSave.promptSave();
		}
		try {
			File file = new File(e.getActionCommand());
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
