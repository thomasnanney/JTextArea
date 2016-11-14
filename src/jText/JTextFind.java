package jText;
import java.awt.*;
import javax.swing.*;

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
		JButton button = new JButton("Find");
		button.setFont(new Font("System", Font.PLAIN, 30));
		panelCenter.add(button);
		
		JTextFindHandler handler = new JTextFindHandler(userField, view);
		button.addActionListener(handler);
	}
}
