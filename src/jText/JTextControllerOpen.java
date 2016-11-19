package jText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
 

/**
 * this class is called when the "open" is hit
 * generates a JFileChooser which returns a file
 * then converts that file into a string and returns the string when
 * returnString() is called
 * 
 */

public class JTextControllerOpen {
	
	public static String string;
	public File fileOpen;
	
	public JTextControllerOpen() throws FileNotFoundException{
		FileInputStream stream = null;
        String str = "";
        try {
        	fileOpen = getFile();
        	stream = new FileInputStream(fileOpen);
            int content;
            while ((content = stream.read()) != -1) {
                str += (char) content;
                
            }
        } catch (IOException e1) {
        	if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
        		throw new FileNotFoundException("User selected cancel");
    		}
        	System.err.println(e1 + "\n");
        }
        this.string = str;
	}
	
	public JTextControllerOpen(File file) throws FileNotFoundException{
		FileInputStream stream = null;
        String str = "";
        try {
        	fileOpen = file;
        	stream = new FileInputStream(fileOpen);
            int content;
            while ((content = stream.read()) != -1) {
                str += (char) content;
                
            }
        } catch (IOException e1) {
        	System.err.println(e1 + "\n");
        }
        this.string = str;
	}

	public static File getFile() throws FileNotFoundException{
		File file = new File("");
		while(true){ //Escapes by file existing or user selecting no/close option in message box/filechooser
			JFileChooser fileChooser = new JFileChooser("."); 
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			
			int ret = fileChooser.showOpenDialog(null);
			
			if (ret == JFileChooser.CANCEL_OPTION)
				throw new FileNotFoundException("User selected cancel");
			 file = fileChooser.getSelectedFile();
			 if(file.exists()){
				 break;
			 }
			 String message = "File • " + file.getName() + " • does not exist in \n" + file.getParent() + ":\n" + "Do you want to select a different file?";
	         String title = "Warning";
	         int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	         if(reply == JOptionPane.NO_OPTION || reply == JOptionPane.CLOSED_OPTION){
	        	 throw new FileNotFoundException("User selected cancel");
	         }
		}
		
		if((file == null) || (file.getName().equals(""))) {
			JOptionPane.showMessageDialog(null, "Invalid Name" , "Invalid Name",
					JOptionPane.ERROR_MESSAGE);
			throw new FileNotFoundException("Invalid Name: " + file);
		}
		
		return file;
	}
	
	public static String returnString() {
		return string;
	}
	
	public String getName(){
		return fileOpen.getPath();
	}
}