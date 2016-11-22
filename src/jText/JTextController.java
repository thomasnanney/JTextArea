package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.undo.*;

public class JTextController implements ActionListener{
	
	private JTextView view;
	private JTextControllerOpen open;
	private JTextControllerSaveAs saveAs;
	private JTextModel model;
	@SuppressWarnings("unused")
	private JTextControllerSave save;
	private UndoManager undoManager;
	private JTextCheckSave checkSave;
	
	public JTextController(JTextModel model,JTextView view) {
		this.view = view;
		this.model = model;
		this.undoManager = view.getUndoManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Exit")) {
			if(view.titleChange()){
				JTextCheckSave checkSave = new JTextCheckSave(view, model);
				checkSave.promptSaveExit();
			}
			System.exit(0);
		} else if (command.equals("Save")){
			if(model.getName().equals("")){ //Same as saveAs
				try {
					saveAs = new JTextControllerSaveAs();
					String str = view.getText();
					saveAs.saveText(str);
					model.setName(saveAs.getName());
				} catch (IOException e1) {
					if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
						return;
					}
					System.err.println(e1 + "\n");
				} finally{
					view.setTitle("JText: A simple text editor");
				}
			} else{ //Use current file name
				File file = new File(model.getName());
				String str = view.getText();
				save = new JTextControllerSave(file, str);
				view.setTitle("JText: A simple text editor");
			}
		} else if (command.equals("Open")){
			if(view.titleChange()){
				checkSave = new JTextCheckSave(view, model);
				checkSave.promptSave();
			}
			try {
				open = new JTextControllerOpen();
				String str = open.returnString();
				model.setName(open.getName());
				view.setArea(str);
			} catch (FileNotFoundException e1) {
				if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
					return;
				}
				System.err.println(e1 + "\n");
			} finally{
				view.setTitle("JText: A simple text editor");
			}
		} else if (command.equals("New")) {
			if(view.titleChange()){
				checkSave = new JTextCheckSave(view, model);
				checkSave.promptSave();
			}
			String n = "";
			view.setArea(n);
			model.eraseName();
			view.setTitle("JText: A simple text editor");
			
		} else if (command.equals("Save As")) {
			if(view.titleChange()){
				checkSave = new JTextCheckSave(view, model);
				checkSave.promptSave();
			}
			try {
				saveAs = new JTextControllerSaveAs();
				String str = view.getText();
				saveAs.saveText(str);
				model.setName(saveAs.getName());
			} catch (IOException e1) {
				if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
					return;
				}
				System.err.println(e1 + "\n");
			} finally{
				view.setTitle("JText: A simple text editor");
			}
			
		} else if (command.equals("Undo")) {
			try {
				undoManager.undo();
			} catch (CannotUndoException e1){
				if(e1.equals(null)){
					return;
				}
			}
			view.setTitle("JText: A simple text editor *");
		} else if (command.equals("Redo")) {
			try {
				undoManager.redo();
			} catch (CannotRedoException e1){
				if(e1.equals(null)){
					return;
				}
			}
			view.setTitle("JText: A simple text editor *");
		} else if (command.equals("Cut")) {
			view.cut();
			view.setTitle("JText: A simple text editor *");
		} else if (command.equals("Copy")) {
			view.copy();
		} else if (command.equals("Paste")) {
			view.paste();
			view.setTitle("JText: A simple text editor *");
		} else if (command.equals("Find")) {
			JTextFind findWindow = new JTextFind(view);
			findWindow.setBounds(600, 100, 350, 160);
			findWindow.setVisible(true);
		} else if (command.equals("Select All")) {
			view.selectAll();
		} else if (command.equals("Find Next")) {
			//TODO Find Next
		} else if (command.equals("Replace")) {
			JTextReplace replaceWindow = new JTextReplace(view);
			replaceWindow.setBounds(600, 100, 350, 210);
			replaceWindow.setVisible(true);
		} else if (command.equals("Go To...")) {
			//TODO Go To
		}
	}
}