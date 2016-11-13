package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JTextArea;

public class JTextController implements ActionListener{
	
	private JTextView view;
	
	private JTextControllerOpen open;
	
	private JTextArea area;
	
	private JTextControllerSaveAs saveAs;
	
	private JTextControllerCut cut;
	
	private JTextModel model;
	
	public JTextController(JTextModel model,JTextView view) {
		this.view = view;
		this.model = model;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Exit")) {
			System.exit(0);
		} else if (command.equals("Save")){
			//TODO Save class
		} else if (command.equals("Open")){
			try {
				open = new JTextControllerOpen();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			String str = open.returnString();
			view.setArea(str);

		} else if (command.equals("New")) {
			
			String n = "";
			view.setArea(n);
			
			
		} else if (command.equals("Save As")) {
			
			saveAs = new JTextControllerSaveAs();
			String str = view.getText();
			try {
				saveAs.saveText(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
						
		} else if (command.equals("Undo")) {
		} else if (command.equals("Cut")) {
			view.cut();
		} else if (command.equals("Copy")) {
			view.copy();
		} else if (command.equals("Paste")) {
			view.paste();
		} else if (command.equals("Find")) {
			//TODO Find
		} else if (command.equals("Select All")) {
			view.selectAll();
		} else if (command.equals("Find Next")) {
			//TODO Find Next
		} else if (command.equals("Replace")) {
			//TODO Replace
		} else if (command.equals("Find All")) {
			//TODO Find All
		} else if (command.equals("Go To...")) {
			//TODO Go To
		}
		
	}
	
	
}