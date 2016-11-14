package jText;

import javax.swing.JMenu;
import javax.swing.JTextArea;

public class JTextModel {
	
	private JMenu jText;
	
	private JTextArea area;
	
	private String name = "";
	
	public JTextModel() {
		
	}
	
  	public String getName(){
  		return name;
  	}
  	
  	public void setName(String name){
  		this.name = name;
  	}
}