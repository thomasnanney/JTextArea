package jText;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;

/**
 * JMenu objects jText and file
 */

@SuppressWarnings("serial")
public class JTextView extends JFrame {
	
	private JMenu jText;
	private JMenu file;
	private JMenu edit;
	private JMenu viewMenu;
	private JMenu openRecentMenu;
	private JMenu stylesMenu;
	protected UndoManager undoManager = new UndoManager();
	private JPopupMenu menu = new JPopupMenu("Popup");
	private JTextPane textPane;
    private StyledDocument styledDocument;
	
	
	
	public JTextView(JTextModel model) {
		super("JText: A simple text editor");
		
		super.setSize(900, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		jText = new JMenu("JText");
		file = new JMenu("File");
		edit = new JMenu("Edit");
		viewMenu = new JMenu("View");
		menuBar.add(jText);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(viewMenu);
		/**
		 * Add area for text
		 */
		this.styledDocument = new DefaultStyledDocument();
		this.setLocation(630, 100);
        textPane = new JTextPane(styledDocument);
        textPane.setPreferredSize(new Dimension(250, 125));
        textPane.setFont(new Font("System", Font.PLAIN, 25));
        
        /**
         * Add JToolbar for Icon Actions
         */
        JToolBar toolbar = new JToolBar();
		Container contentPane = super.getContentPane();
		toolbar.setRollover(true);
		ImageIcon newImg = new ImageIcon("new.png");
		JButton newFile = new JButton(newImg);
		ImageIcon open = new ImageIcon("open.png");
		JButton openFile = new JButton(open);
		ImageIcon save = new ImageIcon("save.png");
		JButton saveFile = new JButton(save);
		ImageIcon redo = new ImageIcon("redo.png");
		JButton redoChg = new JButton(redo);
		ImageIcon undo = new ImageIcon("undo.png");
		JButton undoChg = new JButton(undo);
		ImageIcon copy = new ImageIcon("copy.png");
		JButton copyBtn = new JButton(copy);
		ImageIcon paste = new ImageIcon("paste.png");
		JButton pasteBtn = new JButton(paste);
		ImageIcon left = new ImageIcon("left.png");
		JButton leftBtn = new JButton(left);
		ImageIcon right = new ImageIcon("right.png");
		JButton rightBtn = new JButton(right);
		ImageIcon center = new ImageIcon("center.png");
		JButton centerBtn = new JButton(center);
		ImageIcon find = new ImageIcon("find.png");
		JButton findBtn = new JButton(find);
		ImageIcon findRep = new ImageIcon("find_replace.png");
		JButton findRepBtn = new JButton(findRep);
		ImageIcon cut = new ImageIcon ("cut.png");
		JButton cutBtn = new JButton (cut);
		toolbar.add(newFile);
		toolbar.add(openFile);
		toolbar.add(saveFile);
		toolbar.addSeparator();
		toolbar.add(redoChg);
		toolbar.add(undoChg);
		toolbar.addSeparator();
		toolbar.add(cutBtn);
		toolbar.add(copyBtn);
		toolbar.add(pasteBtn);
		toolbar.addSeparator();
		toolbar.add(leftBtn);
		toolbar.add(centerBtn);
		toolbar.add(rightBtn);
		toolbar.add(findBtn);
		toolbar.add(findRepBtn);
		contentPane.add(toolbar, BorderLayout.NORTH);
        
		/**
		 * JPopUpMenu on Right-Click
		 */
        textPane.addMouseListener(new RightClickListener());

		JScrollPane textScroller = new JScrollPane(textPane);
		//Container contentPane = super.getContentPane();
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
		 * add print to file
		 */
		JMenuItem printButton = new JMenuItem("Print");
		file.add(printButton);
		/**
		 * code to add open recent
		 */
		
		openRecentMenu = new JMenu("Open Recent");
		JTextRecent recent = new JTextRecent(model);
		
		JMenuItem recent1 = new JMenuItem("1");
		openRecentMenu.add(recent1);
		recent1.setVisible(false);
		JMenuItem recent2 = new JMenuItem("2");
		openRecentMenu.add(recent2);
		recent2.setVisible(false);
		JMenuItem recent3 = new JMenuItem("3");
		openRecentMenu.add(recent3);
		recent3.setVisible(false);
		JMenuItem recent4 = new JMenuItem("4");
		openRecentMenu.add(recent4);
		recent4.setVisible(false);
		JMenuItem recent5 = new JMenuItem("5");
		openRecentMenu.add(recent5);
		recent5.setVisible(false);
		file.add(openRecentMenu);
		JMenuItem items[] = {recent1, recent2, recent3, recent4, recent5};
		recent.setItems(items);
		recent.initialStart();
		
		JTextRecentController rControl = new JTextRecentController(model, this, recent);
		register(rControl);
		//end of add recent 
		
		/**
		 * Add Edit menu items to edit menu and some of the
		 * 	same to popUpMenu (On right-click)
		 */
		
		JMenuItem undoButton = new JMenuItem("Undo   CTRL+Z");
		edit.add(undoButton);
		JMenuItem redoButton = new JMenuItem("Redo");
		edit.add(redoButton);
		JMenuItem cutButton = new JMenuItem("Cut");
		edit.add(cutButton);
		menu.add(cutButton);
		JMenuItem copyButton = new JMenuItem("Copy");
		edit.add(copyButton);
		menu.add(copyButton);
		JMenuItem pasteButton = new JMenuItem("Paste");
		edit.add(pasteButton);
		menu.add(pasteButton);
		JMenuItem findButton = new JMenuItem("Find");
		edit.add(findButton);
		JMenuItem replaceButton = new JMenuItem("Replace");
		edit.add(replaceButton);
		JMenuItem selectAllButton = new JMenuItem("Select All");
		edit.add(selectAllButton);
		menu.add(selectAllButton);
		
		/**
		 * Add styles menu and items on popUpMenu (Right-click)
		 */
		stylesMenu = new JMenu("Font");
		
		JMenuItem bold = new JMenuItem("Bold");
		JMenuItem italic = new JMenuItem("Italic");
		JMenuItem underline = new JMenuItem("Underline");
		JMenuItem defaultS = new JMenuItem("Default");
		stylesMenu.add(bold);
		stylesMenu.add(italic);
		stylesMenu.add(underline);
		stylesMenu.add(defaultS);
		menu.add(stylesMenu);
		
		JTextFontSelectedHandler fontHandler = new JTextFontSelectedHandler(textPane);
		registerStyles(fontHandler);
		
		/**
		 * add viewMenu items
		 */
		JMenuItem font = new JMenuItem("Font");
		viewMenu.add(font);
		JMenuItem paragraph = new JMenuItem("Paragraph");
		viewMenu.add(paragraph);
		
		/**
		 * code to use undo and redo
		 */
		
		textPane.getDocument().addUndoableEditListener(
				new UndoableEditListener(){
					public void undoableEditHappened(UndoableEditEvent e){
						undoManager.addEdit(e.getEdit());
					}
				}
		);
		
		/**
		 * Code to delete highlights when key is typed
		 */
		JTextHighlightController highlight = new JTextHighlightController(this);
		textPane.addKeyListener(highlight);
	}
	
	/**
	 * register all the listeners
	 */
	public void register(JTextRecentController rControl){
  		Component[] jTextComponents = openRecentMenu.getMenuComponents();
		for(Component jTextComponent : jTextComponents) {
			if ( jTextComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) jTextComponent;
				button.addActionListener(rControl);		
			}
		}
  	}
	
	public void registerStyles(JTextFontSelectedHandler fControl){
		Component[] styleComponents = stylesMenu.getMenuComponents();
		for(Component styleComponent : styleComponents) {
			if ( styleComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) styleComponent;
				button.addActionListener(fControl);
			}
		}
	}
	
	class RightClickListener extends MouseAdapter {
	      public void mousePressed(MouseEvent ev) {
	        if (ev.isPopupTrigger()) {
	          menu.show(ev.getComponent(), ev.getX(), ev.getY());
	        }
	      }

	      public void mouseReleased(MouseEvent ev) {
	        if (ev.isPopupTrigger()) {
	          menu.show(ev.getComponent(), ev.getX(), ev.getY());
	        }
	      }

	      public void mouseClicked(MouseEvent ev) {
	      }
	    }

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
		
		Component[] popupComponents = menu.getComponents();
		for(Component popupComponent : popupComponents) {
			if ( popupComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) popupComponent;
				button.addActionListener(controller);
			}
		}
		
		
		Component[] areaComponents = textPane.getComponents();
		for(Component areaComponent : areaComponents) {
			if ( areaComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) areaComponent;
				button.addMouseListener((MouseListener) controller);
			}
		}

		Component[] viewComponents = viewMenu.getMenuComponents();
		for(Component viewComponent : viewComponents) {
			if ( viewComponent instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) viewComponent;
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
		textPane.setText(str);
		textPane.update(textPane.getGraphics());
	}
	
	public JTextPane getPane(){
		return textPane;
	}

	public String getText(){
		String str = textPane.getText();
		return str;
	}
	
	public boolean titleChange() { //Returns true if title has changed from default
		String s = super.getTitle();
		if(s.endsWith("*")){
			return true;
		}
		return false;
	}
	
	public void setTitle(String s){
		super.setTitle(s);
	}
	
	public UndoManager getUndoManager(){
		return undoManager;
	}

	public String getSelectedText() {
		String str = textPane.getSelectedText();
		return str;
	}
	
	public void cut() {
		textPane.cut();
	}
	
	public void copy() {
		textPane.copy();
	}
	
	public void paste() {
		textPane.paste();
	}
	
	public void selectAll(){
		textPane.selectAll();
	}

	public int length() {
		if(textPane.isEnabled()){
			String str = textPane.getText();
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

	public void print() {
		try {
			textPane.print();
		} catch (PrinterException e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	
}