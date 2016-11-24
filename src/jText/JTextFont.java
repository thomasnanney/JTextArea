package jText;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JTextFont extends JFrame{

	public JTextFont(JTextView view) {
			super("Font");
			JPanel panelNorth = new JPanel();
			add(panelNorth, BorderLayout.NORTH);
			JPanel panelCenter = new JPanel();
			add(panelCenter, BorderLayout.CENTER);
			JPanel panelSouth = new JPanel();
			add(panelSouth, BorderLayout.SOUTH);
			
			panelNorth.setLayout(new GridLayout(1, 1));
			JLabel fontLabel = new JLabel("Font:");
			fontLabel.setFont(new Font("System", Font.PLAIN, 24));
			panelNorth.add(fontLabel);
			String[] fonts = { " ", "System", "Serif", "Monospaced" };
			JComboBox<String> font = new JComboBox<String>(fonts);
			panelNorth.add(font);
			
			panelCenter.setLayout(new GridLayout(1, 1));
			JLabel styleLabel = new JLabel("Style:");
			styleLabel.setFont(new Font("System", Font.PLAIN, 24));
			panelCenter.add(styleLabel);
			String[] styles = { " ", "Bold", "Italic" };
			JComboBox<String> style = new JComboBox<String>(styles);
			panelCenter.add(style);
			
			panelSouth.setLayout(new GridLayout(1, 1));
			JLabel sizeLabel = new JLabel("Size:");
			sizeLabel.setFont(new Font("System", Font.PLAIN, 24));
			panelSouth.add(sizeLabel);
			JTextField size = new JTextField();
			panelSouth.add(size);
			
			JTextFontHandler handler = new JTextFontHandler(view);
			font.addActionListener(handler);
			style.addActionListener(handler);
			size.addActionListener(handler);
		}
	

}
