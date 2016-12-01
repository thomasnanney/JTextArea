package jText;

public class JTextSpecial {
	
	String ret;

	public JTextSpecial(String str) {
		//System.out.println(str);
		int length = str.length();
		int indexOfOpenBracket = -1;;
		int numCloseBracket = 0;
		int indexOfStartLine = -1;
		for(int i = length-1; i >=0 ; i--){
			char c = str.charAt(i);
			if(c == '}'){
				numCloseBracket++;
			}
			if((c == '{') && numCloseBracket >0){
				numCloseBracket--;
			}
			if((numCloseBracket == 0) && c == '{' ){
				indexOfOpenBracket = i;
				break;
			}
		}
		for(int i = indexOfOpenBracket; i>=0; i--){
			char c = str.charAt(i);
			System.out.println(c);
			if(c == '\n'){
				indexOfStartLine = i + 1;
				System.out.println(indexOfStartLine);
				break;	
			}
		}
		 this.ret = str.substring(indexOfStartLine,indexOfOpenBracket-1);
		}
	
	public String getSubString(){
		return this.ret;
		
	}

}
