package jText;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


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
			JComboBox font = new JComboBox();
			panelNorth.add(font);
			
			panelCenter.setLayout(new GridLayout(1, 1));
			JLabel styleLabel = new JLabel("Style:");
			styleLabel.setFont(new Font("System", Font.PLAIN, 24));
			panelCenter.add(styleLabel);
			JComboBox style = new JComboBox();
			panelCenter.add(style);
			
			panelSouth.setLayout(new GridLayout(1, 1));
			JLabel sizeLabel = new JLabel("Size:");
			sizeLabel.setFont(new Font("System", Font.PLAIN, 24));
			panelSouth.add(sizeLabel);
			JTextField size = new JTextField();
			panelSouth.add(size);
			
			JTextFontHandler handler = new JTextFontHandler(size, view);
			font.addActionListener(handler);
			style.addActionListener(handler);
			size.addActionListener(handler);
			
			
		}
	

}
