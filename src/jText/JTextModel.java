package jText;

import java.awt.Component;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class JTextModel {
	
	private String name = "";
	private JMenu menu;
	private JMenu openRecentMenu;
	private Scanner file;
	private ArrayList<String> list = new ArrayList<String>();
	private JTextControllerOpen open;
	
	public JTextModel() {
		
	}
	
  	public String getName(){
  		return name;
  	}
  	
  	public void setName(String name){
  		this.name = name;
  		list.add(name);
  		BufferedWriter bw = null;
        try {
        	bw = new BufferedWriter(new FileWriter("recentFiles.txt", true));
		  	bw.write(this.name);
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
        checkForDup();
        trackRecent();
  	}
  	
  	public void checkForDup(){
  		String cur;
  		for(int i = 0; i < list.size(); i++){
  			cur = list.get(i);
  			for(int j = i+1; j < list.size(); j++){
  				if(cur.equals(list.get(j))){
  					list.remove(i);
  				}
  			}
  		}
  		System.out.println(list);
  		rewriteFile();
  	}
  	
  	public void setFile(JMenu file){
  		menu = file;
  		openRecentMenu = new JMenu("Open Recent");
  		trackRecent();
  	}
  	
  	public void trackRecent(){
  		openFile();
  		openRecentMenu.removeAll();
  		list.clear();
  		String path;
  		while(file.hasNextLine()){
  			path = file.nextLine();
  			list.add(path);
  			if(list.size() > 5){
  				list.remove(0);
  				rewriteFile();
  			}
  		}
  		for(int i = 0; i < 5; i++){
  			if(list.size() <= i){
  				break;
  			}
  			String temp = list.get(i);
  			switch(i){
  				case 0:
  					JMenuItem recent1 = new JMenuItem(temp);
  					openRecentMenu.add(recent1);
  					break;
  				case 1:
  					JMenuItem recent2 = new JMenuItem(temp);
  					openRecentMenu.add(recent2);
  					break;
  				case 2:
  					JMenuItem recent3 = new JMenuItem(temp);
  					openRecentMenu.add(recent3);
  					break;
  				case 3:
  					JMenuItem recent4 = new JMenuItem(temp);
  					openRecentMenu.add(recent4);
  					break;
  				case 4:
  					JMenuItem recent5 = new JMenuItem(temp);
  					openRecentMenu.add(recent5);
  			}
  		}
  		JTextRecentController rControl = new JTextRecentController(this);
  		register(rControl);
  		menu.add(openRecentMenu);
	}
  	
  	public void register(JTextRecentController rControl){
  		Component[] jTextComponents = openRecentMenu.getMenuComponents();
		for(Component jTextComponent : jTextComponents) {
			if ( jTextComponent instanceof AbstractButton) { 
				AbstractButton button = (AbstractButton) jTextComponent;
				button.addActionListener(rControl);		
			}
		}
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
  	
  	public void openFile(){
  		file = null;
        try {
        	file = new Scanner(new File("recentFiles.txt"));
        } catch (IOException e1) {
        	System.err.println(e1 + "\n");
        }
  	}
}