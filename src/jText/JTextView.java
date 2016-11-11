package jText;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * JMenu objects jText and file
 */

public class JTextView extends JFrame {
	
	private JMenu jText;

	private JMenu file;
	
	private JMenu edit;
	
	private JTextArea text;
	
	public JTextView() {
		super("JText: A simple text editor");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		jText = new JMenu("JText");
		file = new JMenu("File");
		edit = new JMenu("Edit");
		menuBar.add(jText);
		menuBar.add(file);
		menuBar.add(edit);
		/**
		 * Add area for text
		 */
		text = new JTextArea(1,1);
		text.setFont(new Font("System", Font.PLAIN, 24));

		JScrollPane textScroller = new JScrollPane(text);
		Container contentPane = super.getContentPane();
		contentPane.add(textScroller, BorderLayout.CENTER);
		
		/**
		 * Add JText menu items to jtext menu
		 */
		JMenuItem exitButton = new JMenuItem("Exit");
		jText.add(exitButton);
		
		/**
		 * Add File menu items to file menu
		 */
		
		JMenuItem newButton =  new JMenuItem("New");
		file.add(newButton);
		JMenuItem openButton = new JMenuItem("Open");
		file.add(openButton);
		JMenuItem saveButton = new JMenuItem("Save");
		file.add(saveButton);
		JMenuItem saveasButton = new JMenuItem("Save As");
		file.add(saveasButton);
		
		/**
		 * Add Edit menu items to edit menu
		 */
		
		JMenuItem undoButton = new JMenuItem("Undo");
		edit.add(undoButton);
		JMenuItem cutButton = new JMenuItem("Cut");
		edit.add(cutButton);
		JMenuItem copyButton = new JMenuItem("Copy");
		edit.add(copyButton);
		JMenuItem pasteButton = new JMenuItem("Paste");
		edit.add(pasteButton);
		JMenuItem findButton = new JMenuItem("Find");
		edit.add(findButton);
		JMenuItem findnextButton = new JMenuItem("Find Next");
		edit.add(findnextButton);
		JMenuItem replaceButton = new JMenuItem("Replace");
		edit.add(replaceButton);
		JMenuItem gotoButton = new JMenuItem("Go To...");
		edit.add(gotoButton);
		JMenuItem findallButton = new JMenuItem("Find All");
		edit.add(findallButton);
		
	}
	
	/**
	 * register all the listeners
	 */

	public void registerListener(JTextController controller) {
		Component[] jTextComponents = jText.getMenuComponents();
		for(Component jTextComponent : jTextComponents) {
			if ( jTextComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) jTextComponent;
				button.addActionListener(controller);		
			}
		}
		
		Component[] fileComponents = file.getMenuComponents();
		for(Component fileComponent : fileComponents) {
			if ( fileComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) fileComponent;
				button.addActionListener(controller);
			}
		}
	}
	
	/**
	 * setArea takes in a string
	 * gets the size of what is currently being displayed in the JTextArea
	 * replaces what is currently being displayed with string param
	 * updates the area
	 * @param str
	 */
	
	public void setArea(String str){
		
		String current = text.getText();
		int size = current.length();
		text.replaceRange(str,0,size);
		text.update(text.getGraphics());
	}

	
	
}