package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextFontHandler implements ActionListener{

	private JTextField field;
	private JTextView view;
	private JTextArea area;
	
	public JTextFontHandler(JTextField field, JTextView view){
		this.field = field;
		this.view = view;
		this.area = view.getArea();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Font":
			System.out.println("HERE");
			
		}
		
	}

}
