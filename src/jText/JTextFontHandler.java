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
		Font f = area.getFont();
		if(e.getActionCommand().equals("comboBoxChanged")){
			JComboBox cb = (JComboBox)e.getSource();
			String font = (String)cb.getSelectedItem();
			switch(font){ //Font and Style
				case "Bold":
					area.setFont(new Font(f.getFontName(), Font.BOLD, f.getSize()));
					break;
				case "Italic":
					area.setFont(new Font(f.getFontName(), Font.ITALIC, f.getSize()));
					break;
				case "System":
					area.setFont(new Font("System", f.getStyle(), f.getSize()));
					break;
				case "Serif":
					area.setFont(new Font(Font.SERIF, f.getStyle(), f.getSize()));
					break;
				case "Monospaced":
					area.setFont(new Font(Font.MONOSPACED, f.getStyle(), f.getSize()));
					break;
			}
		}
		else{ //Size
			area.setFont(new Font(f.getFontName(), f.getStyle(), Integer.parseInt(e.getActionCommand())));
		}
	}
}
