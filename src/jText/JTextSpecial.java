package jText;

public class JTextSpecial {
	
	String ret;
	int length;

	public JTextSpecial(String str) {
		//System.out.println(str);
		this.length = str.length();
		int indexOfOpenBracket = -1;;
		int numCloseBracket = 0;
		int indexOfStartLine = 0;
		for(int i = length-1; i >=0 ; i--){
			char c = str.charAt(i);
			if(c == '}'){
				numCloseBracket++;
			} else if((c == '{') && numCloseBracket >0){
				numCloseBracket--;
			} else if((numCloseBracket == 0) && c == '{' ){
				indexOfOpenBracket = i;
				break;
			}
		}
		for(int i = indexOfOpenBracket; i>=0; i--){
			char c = str.charAt(i);
			if(c == '\n'){
				indexOfStartLine = i + 1;
				//System.out.println(indexOfStartLine);
				break;	
			}
		}
		 this.ret = str.substring(indexOfStartLine,indexOfOpenBracket);
		}
	
	public String getSubString(){
		return "//end of " + this.ret;
		
	}
	
	public int getIndexOfClosingBracket(){
		return this.length;
		}
	
	

}
