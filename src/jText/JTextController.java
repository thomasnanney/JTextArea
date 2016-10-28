package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextController implements ActionListener{
	
	private JTextView view;
	
	public JTextController(JTextView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Exit")) {
			System.exit(0);
		} else if (command.equals("Save")){
			//TODO Save class
		} else if (command.equals("Open")){
			//TODO Open class
		} else if (command.equals("New")) {
			//TODO New class
		} else if (command.equals("Save As")) {
			//TODO Save class
		} else if (command.equals("Undo")) {
			//TODO Undo
		} else if (command.equals("Cut")) {
			//TODO Cut
		} else if (command.equals("Copy")) {
			//TODO Copy
		} else if (command.equals("Paste")) {
			//TODO Paste
		} else if (command.equals("Find")) {
			//TODO Find
		} else if (command.equals("Find Next")) {
			//TODO Find Next
		} else if (command.equals("Replace")) {
			//TODO Replace
		} else if (command.equals("Find All")) {
			//TODO Find All
		} else if (command.equals("Go To...")) {
			//TODO Go To
		}
		
	}
}