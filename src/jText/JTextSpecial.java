package jText;

public class JTextSpecial {
	
	String ret;

	public JTextSpecial(String str) {
		int length = str.length();
		int indexOfOpenBracket = -1;;
		int numCloseBracket = 0;
		int indexOfStartLine = 0;
		for(int i = length-2; i >=0 ; i--){
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
				break;	
			}
		}
		 this.ret = str.substring(indexOfStartLine,indexOfOpenBracket);
		}
	
	public String getSubString(){
		return "//end of " + this.ret;
		
	}
	
	
	

}
