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
	
	public JTextController(JTextView view) {
		this.view = view;
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
			//System.out.println("\nHEREUNDO\n");
		} else if (command.equals("Cut")) {
			String cutString = view.getSelectedText();
			//System.out.println("\nHERECUT\n");
			System.out.println(cutString);
			cut = new JTextControllerCut( area);
		} else if (command.equals("Copy")) {
			//System.out.println("\nHERECOPY\n");
		} else if (command.equals("Paste")) {
			//System.out.println("\nHEREPASTE\n");
		} else if (command.equals("Find")) {
			//TODO Find
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
	
	public void mouseReleased(MouseEvent e){
		System.out.println("HERE");
		if(area.getSelectedText() != null){
			String str = area.getSelectedText();
			System.out.print(str);
		}
	}
}