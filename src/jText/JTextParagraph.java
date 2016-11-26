package jText;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JTextParagraph extends JFrame{

	public JTextParagraph(JTextView view) {
			super("Paragraph");
			JPanel panelNorth = new JPanel();
			add(panelNorth, BorderLayout.NORTH);
			
			panelNorth.setLayout(new GridLayout(1, 1));
			JLabel alignmentLabel = new JLabel("Alignment:");
			alignmentLabel.setFont(new Font("System", Font.PLAIN, 24));
			panelNorth.add(alignmentLabel);
			String[] alignments = { " ", "Left", "Center", "Right" };
			JComboBox<String> alignment = new JComboBox<String>(alignments);
			panelNorth.add(alignment);
			
			JTextParagraphHandler handler = new JTextParagraphHandler(view);
			alignment.addActionListener(handler);
			
		}

}
