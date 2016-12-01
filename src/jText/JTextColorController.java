package jText;

import java.awt.Color;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 * this class creates and returns a default styled doc
 * if the txt in the string matches one of the words we want colored,
 * the txt is removed, then replaced with a colored version of the txt
 * this class also creates the attributesets for red black blue and green from a stylecontext
 * @author ThomasNanney
 *
 */

public class JTextColorController {
	
	private JTextColor fontColor;
	private static DefaultStyledDocument defaultDoc;
	
	final StyleContext styleContext = StyleContext.getDefaultStyleContext();
    final AttributeSet attributeSetRed = styleContext.addAttribute(styleContext.getEmptySet(),
    		StyleConstants.Foreground, Color.RED);
    final AttributeSet attributeSetBlack = styleContext.addAttribute(styleContext.getEmptySet(),
    		StyleConstants.Foreground, Color.BLACK);
    final AttributeSet attributeSetBlue = styleContext.addAttribute(styleContext.getEmptySet(),
    		StyleConstants.Foreground, Color.BLUE);
    final AttributeSet attributeSetGreen = styleContext.addAttribute(styleContext.getEmptySet(),
    		StyleConstants.Foreground, Color.GREEN.darker());
    final AttributeSet attributeSetOrange = styleContext.addAttribute(styleContext.getEmptySet(),
    		StyleConstants.Foreground, Color.ORANGE);
    final AttributeSet attributeSetMagenta = styleContext.addAttribute(styleContext.getEmptySet(),
    		StyleConstants.Foreground, Color.MAGENTA.darker());

	@SuppressWarnings("serial")
	public JTextColorController(final JTextColor fontColor) {
		this.fontColor = fontColor;
		defaultDoc = new DefaultStyledDocument() {
            public void insertString (int offs, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offs, str, a);

                String txt = getText(0, getLength());
                int start = fontColor.getLast(txt, offs);
                if (start < 0) start = 0;
                int end = fontColor.getFirst(txt, offs + str.length());
                int indexLeft = start;
                int indexRight = start;

                while (indexRight <= end) {
                    if (indexRight == end || String.valueOf(txt.charAt(indexRight)).matches("\\W")) {
                        if (txt.substring(indexLeft, indexRight).matches("(\\W)*(if|for|while|else|switch|case|\\{|\\}|\\(|\\)|\\[|\\])")){
                            setCharacterAttributes(indexLeft, indexRight - indexLeft, attributeSetGreen, false);
                        } else if (txt.substring(indexLeft, indexRight).matches("(\\W)*(int|String|char|boolean|long|float|double)")){
                            setCharacterAttributes(indexLeft, indexRight - indexLeft, attributeSetBlue, false);
                        } else if (txt.substring(indexLeft, indexRight).matches("(\\W)*(void|null|NULL)")){
                            setCharacterAttributes(indexLeft, indexRight - indexLeft, attributeSetMagenta, false);
                        } else if (txt.substring(indexLeft, indexRight).matches("(\\W)*(private|static|public|protected|final|package|import|define|include|return)")){
                            setCharacterAttributes(indexLeft, indexRight - indexLeft, attributeSetRed, false);
                        } else {
                            setCharacterAttributes(indexLeft, indexRight - indexLeft, attributeSetBlack, false);
                        }
                        indexLeft = indexRight;
                    }
                    indexRight++;
                }
            }

            public void remove (int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String txt = getText(0, getLength());
                int start = fontColor.getLast(txt, offs);
                if (start < 0) start = 0;
                int end = fontColor.getFirst(txt, offs);

                if (txt.substring(start, end).matches("(\\W)*(if|for|while|else|switch|case|\\{|\\}|\\(|\\)|\\[|\\])")) {
                    setCharacterAttributes(start, end - start, attributeSetGreen, false);
                } else if (txt.substring(start, end).matches("(\\W)*(int|String|char|boolean|long|float)")){
                    setCharacterAttributes(start, end - start, attributeSetBlue, false);
                } else if (txt.substring(start, end).matches("(\\W)*(void|null|NULL)")){
                    setCharacterAttributes(start, end - start, attributeSetMagenta, false);
                } else if (txt.substring(start, end).matches("(\\W)*(private|static|public|protected|final|package|import|define|include|return)")){
                    setCharacterAttributes(start, end - start, attributeSetRed, false);
                }else {
                    setCharacterAttributes(start, end - start, attributeSetBlack, false);
                }
            }
        };
        
    }
	
	public DefaultStyledDocument getDefaultDoc(){
		return defaultDoc;
	}
	

}
