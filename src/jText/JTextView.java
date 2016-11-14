package jText;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.KeyEvent;

/**
 * JMenu objects jText and file
 */

public class JTextView extends JFrame {
	
	private JTextModel model;
	
	private JMenu jText;

	private JMenu file;
	
	private JMenu edit;
	
	private JTextArea area;
	
	
	public JTextView(JTextModel model) {
		super("JText: A simple text editor");
		this.model = model;
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
		area = new JTextArea(1,1);
		area.setFont(new Font("System", Font.PLAIN, 24));

		JScrollPane textScroller = new JScrollPane(area);
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
		JMenuItem selectAllButton = new JMenuItem("Select All");
		edit.add(selectAllButton);
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
		
		Component[] editComponents = edit.getMenuComponents();
		for(Component editComponent : editComponents) {
			if ( editComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) editComponent;
				button.addActionListener(controller);
			}
		}
		
		Component[] areaComponents = area.getComponents();
		for(Component areaComponent : areaComponents) {
			if ( areaComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) areaComponent;
				button.addMouseListener((MouseListener) controller);
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
			
			String current = area.getText();
			int size = current.length();
			area.replaceRange(str,0,size);
			area.update(area.getGraphics());
	}
	
	public JTextArea getArea(){
		return area;
	}
	
	public void updateArea(JTextArea area){
		this.area = area;
	}

	public String getText(){
		String str = area.getText();
		//System.out.println(str);
		return str;
	}

	public String getSelectedText() {
		//area.cut();
		String str = area.getSelectedText();
		return str;
	}
	
	public void cut() {
		area.cut();
	}
	
	public void copy() {
		area.copy();
	}
	
	public void paste() {
		area.paste();
	}
	
	public void selectAll(){
		area.selectAll();
	}

	public int length() {
		if(area.isEnabled()){
			String str = area.getText();
			if(str != null){
				int i =  str.length();
				return i;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
	
	
	
}