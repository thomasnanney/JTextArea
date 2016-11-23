package jText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * this class is called when the "save as" button is pressed
 * has getFile which returns file chose by filechooser
 * has savetext that takes in a string and saves it to file chosen
 * @author ThomasNanney
 *
 */

public class JTextControllerSaveAs {
	
	private File file;
	
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
		if(!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt")){
			file = new File(fileChooser.getSelectedFile() + ".txt");
		}
		
		return file;
	}
	
	/**
	 * saveText takes in String str and saves it to file 
	 * 	It will check if file already exists. If it does, prompt the user
	 * 	if they want to overwrite it.
	 * 	@param str
	 * 	@throws IOException
	 */
	
	public void saveText(String str) throws IOException{
		try{
			file = getFile();
			if(!file.exists()) {
				file.createNewFile();
				BufferedWriter outfile = new BufferedWriter(new FileWriter(file));
				outfile.write(str);
				outfile.close();  
			} else {
				String message = "File • " + file.getName() + " • already exist in \n" + file.getParent() + ":\n" + "Do you want to overwrite?";
	            String title = "Warning";
	            int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	            if(reply == JOptionPane.YES_OPTION){
	            	file.delete();
	            	file.createNewFile();
	            	BufferedWriter out = new BufferedWriter(new FileWriter(file));
	            	out.write(str);
	            	out.close();
	            	JOptionPane.showMessageDialog(null, "File • " + file.getName() + " • overwritten succesfully in \n" + file.getParent());
	            } else{
	            	throw new FileNotFoundException("User selected cancel");
	            }
			}
		} catch(IOException e) {
	    	   throw e;
		}
	}

	public String getName(){
		return file.getPath();
	}
}
