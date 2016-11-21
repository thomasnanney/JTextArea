package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.undo.*;

public class JTextController implements ActionListener{
	
	private JTextView view;
	private JTextControllerOpen open;
	private JTextControllerSaveAs saveAs;
	private JTextModel model;
	@SuppressWarnings("unused")
	private JTextControllerSave save;
	private UndoManager undoManager;
	
	public JTextController(JTextModel model,JTextView view) {
		this.view = view;
		this.model = model;
		this.undoManager = view.getUndoManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Exit")) {
			int confirm = JOptionPane.showOptionDialog(null, 
					"Are You Sure to Close Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == JOptionPane.YES_OPTION) {
				String message = "Do you want to save the file?";
	            String title = "Warning";
	            int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	            if(reply == JOptionPane.YES_OPTION){
	            	if(model.getName().equals("")){ //Same as saveAs
	    				try {
	    					saveAs = new JTextControllerSaveAs();
	    					String str = view.getText();
	    					saveAs.saveText(str);
	    					model.setName(saveAs.getName());
	    				} catch (IOException e1) {
	    					if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
	    						System.exit(0);
	    					}
	    					System.err.println(e1 + "\n");
	    				}
	    			} else{ //Use current file name
	    				File file = new File(model.getName());
	    				String str = view.getText();
	    				save = new JTextControllerSave(file, str);
	    			}
	            }
				System.exit(0);
			}
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
				}
			} else{ //Use current file name
				File file = new File(model.getName());
				String str = view.getText();
				save = new JTextControllerSave(file, str);
			}

		} else if (command.equals("Open")){
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
			}

		} else if (command.equals("New")) {
			
			String message = "Do you want to save the file?";
            String title = "Warning";
            int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
            	if(model.getName().equals("")){ //Same as saveAs
    				try {
    					saveAs = new JTextControllerSaveAs();
    					String str = view.getText();
    					saveAs.saveText(str);
    					model.setName(saveAs.getName());
    				} catch (IOException e1) {
    					if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
    						String n = "";
    						view.setArea(n);
    						model.eraseName();
    						return;
    					}
    					System.err.println(e1 + "\n");
    				}
    			} else{ //Use current file name
    				File file = new File(model.getName());
    				String str = view.getText();
    				save = new JTextControllerSave(file, str);
    			}
            }
			String n = "";
			view.setArea(n);
			model.eraseName();
			
			
		} else if (command.equals("Save As")) {
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
			}
			
		} else if (command.equals("Undo")) {
			try {
				undoManager.undo();
			} catch (CannotUndoException e1){
				if(e1.equals(null));
			}
		} else if (command.equals("Redo")) {
			try {
				undoManager.redo();
			} catch (CannotRedoException e1){
				if(e1.equals(null));
			}
		} else if (command.equals("Cut")) {
			view.cut();
		} else if (command.equals("Copy")) {
			view.copy();
		} else if (command.equals("Paste")) {
			view.paste();
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