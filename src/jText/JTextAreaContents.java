package jText;

public class JTextAreaContents {
	
	public JTextAreaContents(JTextView view, String str) {
		
		int endCharIndex = str.length();
		
		if(endCharIndex > 1){
		 if (str.charAt(endCharIndex -1) == '\n'){
			 System.out.println(str.charAt(endCharIndex-2));
			 System.out.println(str.charAt(endCharIndex-1));
			 if (str.charAt(endCharIndex -2 ) == '}'){
				 AddBracketCloseComment addBracketCloseComment = new 
				 		 AddBracketCloseComment(str);
				 view.setArea(addBracketCloseComment.getNewString());
			 }
		 } 
		}
	}

}
