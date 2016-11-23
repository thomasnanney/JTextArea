package jText;

import java.util.ArrayList;

public class JTextModel {
	
	private String name = "";
	private JTextRecent recent;
	private ArrayList<String> list = new ArrayList<String>();
	
	public void giveRecent(JTextRecent recent){
		this.recent = recent;
	}
	
  	public String getName(){
  		return name;
  	}
  	
  	public void setName(String name){
  		this.name = name;
  		recent.setName(name);
  	}
  	
  	public void eraseName(){
  		this.name = "";
  	}
  	
  	public ArrayList<String> getList(){
  		return list;
  	}
}