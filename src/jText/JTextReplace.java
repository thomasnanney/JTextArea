package jText;
import java.awt.*;

import javax.swing.*;

/**
 * This class will open a JPanel for the user to enter
 * 	two words, one for the word to be replace and one
 * 	for the new word. Once the user hits the replace button,
 * 	JTextReplaceHandler will replace the word.
 * 
 * @author Jose Bocanegra
 */
@SuppressWarnings("serial")
public class JTextReplace extends JFrame{

	public JTextReplace(JTextView view){
		super("Replace");
		JPanel panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		JPanel panelSouth = new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		
		/* NORTH:
		 */
		panelNorth.setLayout(new GridLayout(2, 2));
		JLabel userLabel1 = new JLabel("Replace:");
		JTextField userFieldWord = new JTextField("");
		JLabel userLabel2 = new JLabel("With:");
		JTextField userFieldNewWord = new JTextField("");
		
		userLabel1.setFont(new Font("System", Font.PLAIN, 36));
		userLabel2.setFont(new Font("System", Font.PLAIN, 36));
		userFieldWord.setFont(new Font("System", Font.PLAIN, 36));
		userFieldNewWord.setFont(new Font("System", Font.PLAIN, 36));
		
		panelNorth.add(userLabel1);
		panelNorth.add(userFieldWord);
		panelNorth.add(userLabel2);
		panelNorth.add(userFieldNewWord);

		/* CENTER:
		 */
		panelSouth.setLayout(new GridLayout(1, 1));
		JButton button = new JButton("Replace");
		button.setFont(new Font("System", Font.PLAIN, 25));
		panelSouth.add(button);
		JTextReplaceHandler handler = new JTextReplaceHandler(userFieldWord, userFieldNewWord, view);
		button.addActionListener(handler);
	}
}
