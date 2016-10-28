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
		} 
		
	}
}