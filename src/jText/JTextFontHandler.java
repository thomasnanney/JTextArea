package jText;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
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
		if(e.getActionCommand().equals("comboBoxChanged")){
			JComboBox cb = (JComboBox)e.getSource();
			String font = (String)cb.getSelectedItem();
			switch(font){ //Font, change so it changes font with current size
				case "Bold":
					area.setFont(new Font("System", Font.BOLD, 24));
					break;
				case "Italic":
					area.setFont(new Font("System", Font.ITALIC, 24));
					break;
			}
		}
		else{ //Size, change so it changes size with current font
			area.setFont(new Font("System", Font.PLAIN, Integer.parseInt(e.getActionCommand())));
		}
	}
}
