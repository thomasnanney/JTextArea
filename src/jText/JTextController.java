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
	private SpellCheck check;
	
	public JTextController(JTextModel model,JTextView view) {
		this.view = view;
		this.model = model;
		this.undoManager = view.getUndoManager();
		this.check = view.getCheck();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Exit")) {
			if(view.titleChange()){
				JTextCheckSave checkSave = new JTextCheckSave(view, model);
				checkSave.promptSaveExit();
			} else{
				System.exit(0);
			}
		} else if (command.equals("Save")){
			if(model.getName().equals("")){ //Same as saveAs
				try {
					saveAs = new JTextControllerSaveAs();
					String str = view.getText();
					saveAs.saveText(str);
					model.setName(saveAs.getName());
					view.setTitle("JText: A simple text editor - " + model.getName());
				} catch (IOException e1) {
					if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
						return;
					}
					System.err.println(e1 + "\n");
				}
			} else{ //Use current file name
				File file = new File(model.getName());
				String str = view.getText();
				save = new JTextControllerSave(file, str);
				view.setTitle("JText: A simple text editor - " + model.getName());
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
				view.setTitle("JText: A simple text editor - " + model.getName());
			} catch (FileNotFoundException e1) {
				if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
					return;
				}
				System.err.println(e1 + "\n");
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
			try {
				saveAs = new JTextControllerSaveAs();
				String str = view.getText();
				saveAs.saveText(str);
				model.setName(saveAs.getName());
				view.setTitle("JText: A simple text editor - " + model.getName());
			} catch (IOException e1) {
				if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
					return;
				}
				System.err.println(e1 + "\n");
			}
		
		} else if (command.equals("Print")) {
			view.print();
		} else if (command.equals("Undo")) {
			try {
				undoManager.undo();
				undoManager.undo();
			} catch (CannotUndoException e1){
				if(e1.equals(null)){
					return;
				}
			}
			if(!view.titleChange()){
				view.setTitle(view.getTitle() + "*");
			}
		} else if (command.equals("Redo")) {
			try {
				undoManager.redo();
				undoManager.redo();
			} catch (CannotRedoException e1){
				if(e1.equals(null)){
					return;
				}
			}
			if(!view.titleChange()){
				view.setTitle(view.getTitle() + "*");
			}
		} else if (command.equals("Cut")) {
			view.cut();
			if(!view.titleChange()){
				view.setTitle(view.getTitle() + "*");
			}
		} else if (command.equals("Copy")) {
			view.copy();
		} else if (command.equals("Paste")) {
			view.paste();
			if(!view.titleChange()){
				view.setTitle(view.getTitle() + "*");
			}
		} else if (command.equals("Find")) {
			JTextFind findWindow = new JTextFind(view);
			findWindow.setSize(360, 160);
			findWindow.setVisible(true);
		} else if (command.equals("Select All")) {
			view.selectAll();
		} else if (command.equals("Replace")) {
			JTextReplace replaceWindow = new JTextReplace(view);
			replaceWindow.setSize(350, 200);
			replaceWindow.setVisible(true);
		} else if(command.equals("Font")){
			JTextFont fontWindow = new JTextFont(view);
			fontWindow.setBounds(1550, 120, 350, 125);
			fontWindow.setVisible(true);
		}else if(command.equals("Paragraph")){
			JTextParagraph paragraphWindow = new JTextParagraph(view);
			paragraphWindow.setBounds(1550, 120, 350, 60);
			paragraphWindow.setVisible(true);
		}else if(command.equals("Right") | command.equals("Left") | command.equals("Center")){
			JTextParagraphHandler pHandler = new JTextParagraphHandler(view);
			pHandler.action(command);
		}
		else if (command.equals("Spell Check")){
			check.getDialogBox(view.getPane());
		}
	}
}