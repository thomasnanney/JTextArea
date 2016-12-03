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
	private ArrayList<String> list;
	
	public JTextRecent(JTextModel model){
		this.model = model;
		list = model.getList();
	}
	
	public void setItems(JMenuItem items[]){
		model.giveRecent(this);
		this.items = items;
	}
	
	public void setName(String name){
		if(list.contains(name)){
			dRemove(name);
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
  		for(JMenuItem item : items){
  			item.setVisible(false);
  		}
		for(int i = 0; i < 5; i++) {
			if(i >= list.size()){
  				break;
  			}
			JMenuItem item = items[4 - i]; //Most recent files will be on top
			String temp = list.get(i);
			item.setText(temp);
			item.setVisible(true);
		}
		file.close();
	}
	
	/**
	 * This class removes duplicates
	 * 
	 * @param n
	 */
	public void dRemove(String n){
  		for(int i = 0; i < list.size(); i++){
  			if(list.get(i).equals(n)){
  				list.remove(i);
  			}
  		}
  		list.add(n);
  		rewriteFile();
  	}
	
	/**
	 * This class removes any file that
	 * 	cannot be opened due to not existing
	 * 
	 * @param n
	 */
	public void eRemove(String n){
		String n2 = n.replace(File.separator, "/");
		for(int i = 0; i < list.size(); i++){
  			if(list.get(i).equals(n) || list.get(i).equals(n2)){
  				list.remove(i);
  				JMenuItem item = items[4 - i];
  				item.setVisible(false); //Essentially removes the item
  			}
  		}
  		rewriteFile(); //update recentFiles.txt without the non existing file
  		trackRecent(); //update the list without the non existing file
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
