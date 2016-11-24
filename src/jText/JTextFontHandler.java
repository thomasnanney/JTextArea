package jText;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JTextFontHandler implements ActionListener{
	private JTextPane textPane;
	
	public JTextFontHandler(JTextView view){
		this.textPane = view.getPane();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Font f = textPane.getFont();
		if(e.getActionCommand().equals("comboBoxChanged")){
			JComboBox<?> cb = (JComboBox<?>)e.getSource();
			String font = (String)cb.getSelectedItem();
			switch(font){ //Font and Style
				case "Bold":
					textPane.setFont(new Font(f.getFontName(), Font.BOLD, f.getSize()));
					break;
				case "Italic":
					textPane.setFont(new Font(f.getFontName(), Font.ITALIC, f.getSize()));
					break;
				case "System":
					textPane.setFont(new Font("System", f.getStyle(), f.getSize()));
					break;
				case "Serif":
					textPane.setFont(new Font(Font.SERIF, f.getStyle(), f.getSize()));
					break;
				case "Monospaced":
					textPane.setFont(new Font(Font.MONOSPACED, f.getStyle(), f.getSize()));
					break;
			}
		}
		else{ //Size
			textPane.setFont(new Font(f.getFontName(), f.getStyle(), Integer.parseInt(e.getActionCommand())));
		}
	}
}
