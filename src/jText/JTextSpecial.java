package jText;

import java.awt.Color;

import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class JTextSpecial {
	
	String returnClosingBracket;
	String finalReturn;

	final StyleContext styleContext = StyleContext.getDefaultStyleContext();
    final AttributeSet attributeSetGreen = styleContext.addAttribute(styleContext.getEmptySet(),
    		StyleConstants.Foreground, Color.GREEN);
    
	public JTextSpecial(String str, String arg) {
		if(arg == "}"){
			this.finalReturn = closingBracket(str);
		}
		if(arg == "//"){
			//System.out.println(str);
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
		return " //end of " + this.returnClosingBracket;
	}

	public String getSubString(){
		return this.finalReturn;
		//return " //end of " + this.returnClosingBracket;
		
	}
	
	
	

}
