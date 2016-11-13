package jText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	
	public JTextControllerOpen() throws FileNotFoundException{
		FileInputStream stream = null;
        String str = "";
        try {
        	File fileOpen = getFile();
        	stream = new FileInputStream(fileOpen);
            int content;
            while ((content = stream.read()) != -1) {
                str += (char) content;
                
            }
           // System.out.println(str);
        } catch (IOException e1) {
        	if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
    			return;
    		}
        	System.err.println(e1 + "\n");
        }
        
        this.string = str;
        
        
		
		
	}

	public static File getFile() throws FileNotFoundException{
		JFileChooser fileChooser = new JFileChooser("."); 
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int ret = fileChooser.showOpenDialog(null);
		
		if (ret == JFileChooser.CANCEL_OPTION)
			throw new FileNotFoundException("User selected cancel");
		
		File file = fileChooser.getSelectedFile();
		
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
		
	

}
