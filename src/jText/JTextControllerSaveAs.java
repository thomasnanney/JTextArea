package jText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * this class is called when the "save as" button is pressed
 * has getFile which returns file chose by filechooser
 * has savetext that takes in a string and saves it to file chosen
 * @author ThomasNanney
 *
 */

public class JTextControllerSaveAs {
	
	public File file;
	
	public JTextControllerSaveAs() {	
		
		
		
	}
	
	/**
	 * creates filechooser to choose file to save
	 * @return
	 * @throws FileNotFoundException
	 */
	
	public File getFile() throws FileNotFoundException{
		JFileChooser fileChooser = new JFileChooser(); 
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
		 
		fileChooser.setFileFilter(extensionFilter);
		
		fileChooser.setDialogTitle("Specify a file to save");
		
		int ret = fileChooser.showSaveDialog(null);
		
		if (ret == JFileChooser.CANCEL_OPTION)
			throw new FileNotFoundException("User selected cancel");
		
		File file = fileChooser.getSelectedFile();
		
		
		return file;
		}
	
	/**
	 * saveText takes in Strin str and saves it to file 
	 * @param str
	 * @throws IOException
	 */
	
	public void saveText(String str) throws IOException{
		try {
			file = getFile();
		} catch (FileNotFoundException e1) {
			if(e1.getMessage().equalsIgnoreCase("User selected cancel")){
				throw new FileNotFoundException("User selected cancel");
    		}
			System.err.println(e1 + "\n");
		}
		BufferedWriter outFile = null;
	      try {
	         outFile = new BufferedWriter(new FileWriter(file));
	         outFile.write(str);
	         outFile.close();
	      } catch (IOException ex) {
	    	  System.err.println(ex + "\n");
	      }
	}

	public String getName(){
		return file.getPath();
	}
}
