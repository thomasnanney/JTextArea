package jText;

import java.io.*;
import java.util.*;
import javax.swing.JMenuItem;

/**
 * This class keeps track of the 5 most
 * 	recent files opened/saved using
 * 	a queue and recentFiles.txt where the
 * 	file paths are stored.
 * 
 * @author Jose Bocanegra
 */
public class JTextRecent {
	
	private JTextModel model;
	private JMenuItem items[];
	private ArrayList<String> list = new ArrayList<String>();
	
	public JTextRecent(JTextModel model){
		this.model = model;
	}
	
	public void setItems(JMenuItem items[]){
		model.giveRecent(this);
		this.items = items;
	}
	
	public void setName(String name){
		if(list.contains(name)){
			remove(name);
		}
		else{
			list.add(name);
			BufferedWriter bw = null;
	        try {
	        	bw = new BufferedWriter(new FileWriter("recentFiles.txt", true));
			  	bw.write(name);
			  	bw.newLine();
			  	bw.flush();
			} catch (IOException ioe) {
	        	System.err.println(ioe + "\n");
			} finally {
			  	if (bw != null) try {
			  		bw.close();
			  	} catch (IOException ioe2) {
			  		
			  	}
			}
		}
        trackRecent();
	}
	
	public void initialStart(){
  		trackRecent();
  	}
	
	public void trackRecent(){
  		list.clear();
  		String path;
  		Scanner file = openFile();
  		while(file.hasNextLine()){
  			path = file.nextLine();
  			list.add(path);
  			if(list.size() > 5){
  				list.remove(0);
  				rewriteFile();
  			}
  		}
		for(int i = 0; i < 5; i++) {
			if(list.size() <= i){
  				break;
  			}
			JMenuItem item = items[i];
			String temp = list.get(i);
			item.setText(temp);
			item.setVisible(true);
		}
		file.close();
	}
	
	public void remove(String n){
  		for(int i = 0; i < list.size(); i++){
  			if(list.get(i).equals(n)){
  				list.remove(i);
  			}
  		}
  		list.add(n);
  		rewriteFile();
  	}
	
	public void rewriteFile(){
  		BufferedWriter bw = null;
        try {
        	bw = new BufferedWriter(new FileWriter("recentFiles.txt"));
		  	for(int i = 0; i < list.size(); i++){
		  		String temp = list.get(i);
		  		bw.write(temp);
		  		bw.newLine();
		  	}
		  	bw.flush();
		} catch (IOException ioe) {
        	System.err.println(ioe + "\n");
		} finally {
		  	if (bw != null) try {
		  		bw.close();
		  	} catch (IOException ioe2) {
		  		//Ignore error
		  	}
		}
  	}
  	
  	public Scanner openFile(){
  		Scanner file = null;
        try {
        	file = new Scanner(new File("recentFiles.txt"));
        } catch (IOException e1) {
        	System.err.println(e1 + "\n");
        }
        return file;
  	}
}
