package jText;

public class JTextSpecial {
	
	String returnClosingBracket;
	String finalReturn;

	public JTextSpecial(String str, String arg) {
		if(arg == "}"){
			this.finalReturn = closingBracket(str);
		}
		
	}
	
	private String closingBracket(String str) {
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
		this.returnClosingBracket = str.substring(indexOfStartLine,indexOfOpenBracket);
		return "//end of " + this.returnClosingBracket;
	}

	public String getSubString(){
		return this.finalReturn;
		//return "//end of " + this.returnClosingBracket;
		
	}
	
	
	

}
