package jText;

import javax.swing.JFrame;
import javax.swing.JTextPane;

/**
 * this class is passed to the fontcolor controller
 * 
 * @author ThomasNanney
 *
 */

public class JTextColor extends JFrame{
	JTextView view;
	JTextPane pane;

	
	public JTextColor(JTextView view){
		this.view = view;
		this.pane = view.getPane();
		
	}
	/**
	 * this method searches the string for the last non word char
	 * returns the index of last non word char
	 * @param txt
	 * @param ndx
	 * @return
	 */
	public int getLast (String txt, int ndx) {
        while (--ndx >= 0) {
        	if (String.valueOf(txt.charAt(ndx)).matches("\\W")) {
        		break;
            }
        }
        return ndx;
    }
	/**
	 * this method searches the string for the first non word char
	 * returns the index of first non word char
	 * @param txt
	 * @param ndx
	 * @return
	 */
	
	public int getFirst (String txt, int ndx ) {
        for(int i = ndx; i < txt.length(); i++){
            if (String.valueOf(txt.charAt(ndx)).matches("\\W")) {
                break;
            }
        }
        return ndx;
    }

}
