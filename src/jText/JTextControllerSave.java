package jText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JTextControllerSave {
	
	public JTextControllerSave(File file, String s){
		BufferedWriter outFile = null;
	    try {
	    	outFile = new BufferedWriter(new FileWriter(file));
	        outFile.write(s);
	        outFile.close();
	    } catch (IOException ex) {
	    	System.err.println(ex + "\n");
	    }
	}
}