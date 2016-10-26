package jText;

import java.awt.Graphics;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.AbstractButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import test.Test2Controller;

/**
 * JMenu objects jText and file
 */

public class JTextView extends JFrame {
	
	private JMenu jText;
	private JMenu jText;

	private JMenu file;

	
	public JTextView() {
		super("JText: A simple text editor");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		jText = new JMenu("JText");
		file = new JMenu("File");
		menuBar.add(jText);
		menuBar.add(file);
		
		/**
		 * Add JText menu items to jtext menu
		 */
		JMenuItem exitButton = new JMenuItem("Exit");
		jText.add(exitButton);
		
		/**
		 * Add File menu items to file menu
		 */
		
		JMenuItem save = new JMenuItem("Save");
		file.add(save);
		JMenuItem open = new JMenuItem("Open");
		file.add(open);
		
		
	}
	
	/**
	 * register all the listeners
	 */

	public void registerListener(JTextController controller) {
		Component[] jTextComponents = jText.getMenuComponents();
		for(Component component : jTextComponents) {
			if ( component instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);		
			}
		
		Component[] fileComponents = file.getMenuComponents();
		for(Component component : fileComponents) {
			if ( component instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
			}
		}
	}
	
	
}