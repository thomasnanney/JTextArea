package jText;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.text.Highlighter;

/**
 * This class will check area when a key is pressed
 * 	and identify whether or not their are highlighted
 * 	words. If there are, remove the highlights.
 * 
 * @author Jose Bocanegra
 */
public class JTextHighlightController implements KeyListener{
	
	JTextArea area;
	
	public JTextHighlightController(JTextArea area){
		this.area = area;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(!e.isControlDown()){
			Highlighter highlighter = area.getHighlighter();
			if(highlighter.getHighlights().length > 0){
				highlighter.removeAllHighlights();
			}
		}
	}
}
