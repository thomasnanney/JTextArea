package jText;
import java.awt.*;

import javax.swing.*;

/**
 * This class will open a JPanel for the user to enter
 * 	a word. Once the user hits enter in the userField,
 * 	JTextFindHandler will highlight the word.
 * 
 * @author Jose Bocanegra
 */
@SuppressWarnings("serial")
public class JTextFind extends JFrame{
	
	
	public JTextFind(JTextView view){
		super("Find");
		JPanel panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		
		/* NORTH:
		 */
		panelNorth.setLayout(new GridLayout(1, 1));
		JLabel userLabel = new JLabel("Find:");
		userLabel.setFont(new Font("System", Font.PLAIN, 36));
		panelNorth.add(userLabel);
		JTextField userField = new JTextField();
		userField.setFont(new Font("System", Font.PLAIN, 36));
		panelNorth.add(userField);

		/* CENTER:
		 */
		panelCenter.setLayout(new GridLayout(2, 2));
		JRadioButton rButton1 = new JRadioButton("Find");
		JRadioButton rButton2 = new JRadioButton("Find All");
		JCheckBox checkbox1 = new JCheckBox("Ignore Case");
		JCheckBox checkbox2 = new JCheckBox("Whole Word");
		rButton1.setFont(new Font("System", Font.PLAIN, 25));
		rButton2.setFont(new Font("System", Font.PLAIN, 25));
		checkbox1.setFont(new Font("System", Font.PLAIN, 25));
		checkbox2.setFont(new Font("System", Font.PLAIN, 25));
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rButton1);
		rButton1.setSelected(true);
		buttonGroup.add(rButton2);
		panelCenter.add(rButton1);
		panelCenter.add(rButton2);
		panelCenter.add(checkbox1);
		panelCenter.add(checkbox2);
		JTextFindHandler handler = new JTextFindHandler(userField, view);
		userField.addActionListener(handler);
		rButton1.addActionListener(handler);
		rButton2.addActionListener(handler);
		checkbox1.addActionListener(handler);
		checkbox2.addActionListener(handler);
	}
}
