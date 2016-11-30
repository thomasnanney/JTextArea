package jText;

import javax.swing.*;
import java.awt.*;

public class JTextToolbarView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JTextToolbarModel model;
	private JToolBar toolbar;

	public JTextToolbarView(Container contentPane, JToolBar toolbar){
		//Create Model
		//this.model = new JTextToolbarModel();
		
		//Create toolbar
		this.toolbar = toolbar;
		toolbar.setRollover(true);
		
		//Create Buttons and Icons
		ImageIcon newImg = new ImageIcon("icons/new.png");
		JButton newFile = new JButton(newImg);
		newFile.setActionCommand("New");
		ImageIcon open = new ImageIcon("icons/open.png");
		JButton openFile = new JButton(open);
		openFile.setActionCommand("Open");
		ImageIcon save = new ImageIcon("icons/save.png");
		JButton saveFile = new JButton(save);
		saveFile.setActionCommand("Save");
		ImageIcon redo = new ImageIcon("icons/redo.png");
		JButton redoChg = new JButton(redo);
		redoChg.setActionCommand("Redo");
		ImageIcon undo = new ImageIcon("icons/undo.png");
		JButton undoChg = new JButton(undo);
		undoChg.setActionCommand("Undo");
		ImageIcon copy = new ImageIcon("icons/copy.png");
		JButton copyBtn = new JButton(copy);
		copyBtn.setActionCommand("Copy");
		ImageIcon paste = new ImageIcon("icons/paste.png");
		JButton pasteBtn = new JButton(paste);
		pasteBtn.setActionCommand("Paste");
		ImageIcon left = new ImageIcon("icons/left.png");
		JButton leftBtn = new JButton(left);
		leftBtn.setActionCommand("Left");
		ImageIcon right = new ImageIcon("icons/right.png");
		JButton rightBtn = new JButton(right);
		rightBtn.setActionCommand("Right");
		ImageIcon center = new ImageIcon("icons/center.png");
		JButton centerBtn = new JButton(center);
		centerBtn.setActionCommand("Center");
		ImageIcon find = new ImageIcon("icons/find.png");
		JButton findBtn = new JButton(find);
		findBtn.setActionCommand("Find");
		ImageIcon findRep = new ImageIcon("icons/find_replace.png");
		JButton findRepBtn = new JButton(findRep);
		findRepBtn.setActionCommand("Replace");
		ImageIcon cut = new ImageIcon ("icons/cut.png");
		JButton cutBtn = new JButton (cut);
		cutBtn.setActionCommand("Cut");
		
		//Add tooltips
		newFile.setToolTipText("New File");
		openFile.setToolTipText("Open");
		saveFile.setToolTipText("Save");
		redoChg.setToolTipText("Redo");
		undoChg.setToolTipText("Undo");
		cutBtn.setToolTipText("Cut");
		pasteBtn.setToolTipText("Paste");
		copyBtn.setToolTipText("Copy");
		leftBtn.setToolTipText("Align Left");
		centerBtn.setToolTipText("Align Center");
		rightBtn.setToolTipText("Align Right");
		findBtn.setToolTipText("Find");
		findRepBtn.setToolTipText("Find & Replace");
		
		//Add buttons to bar and bar to pane.
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
	}
	
	public Component[] getComponents(){
		return toolbar.getComponents();
	}
}
