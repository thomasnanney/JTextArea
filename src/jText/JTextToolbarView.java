package jText;

import javax.swing.*;
import java.awt.*;

public class JTextToolbarView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextToolbarView(Container contentPane){
		JToolBar toolbar = new JToolBar();
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
	
}
