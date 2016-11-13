package jText;

public class AddBracketCloseComment {
	
	public String retStr;
	
	public AddBracketCloseComment(String str){
		String rep = "} //stuff to add";
		String target = "}";
		retStr = str.replace(target, rep);
		
	}
	
	public String getNewString(){
		return retStr;
	}

}
