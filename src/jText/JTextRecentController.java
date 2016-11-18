package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class JTextRecentController implements ActionListener{
	
	private JTextModel model;
	private JTextView view;
	private JTextControllerOpen open;
	
	public JTextRecentController(JTextModel model){
		this.model = model;
	}
	public JTextRecentController(JTextView view){
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			File file = new File(e.getActionCommand());
			open = new JTextControllerOpen(file);
			String str = open.returnString();
			model.setName(open.getName());
			//view.setArea(str);
		} catch (FileNotFoundException e1) {
			if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
				return;
			}
			System.err.println(e1 + "\n");
		}
	}
}
