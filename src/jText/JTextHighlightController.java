package jText;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.text.Highlighter;

/**
 * This class will check area when a key is pressed
 * 	and identify whether or not their are highlighted
 * 	words. If there are, remove the highlights.
 * This class also doubles in changed JFrame's title
 * 	to end in * if the file has changed to notify the
 * 	user and use it as a flag that user has changes
 * 	to be saved
 * 
 * @author Jose Bocanegra
 */
public class JTextHighlightController implements KeyListener{
	
	private JTextArea area;
	private JTextView view;
	
	public JTextHighlightController(JTextView view){
		this.view = view;
		this.area = view.getArea();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(view.titleChange() == false && (!e.isActionKey()) && (!e.isControlDown()))
			view.setTitle("JText: A simple text editor *");
		if(!e.isControlDown()){
			Highlighter highlighter = area.getHighlighter();
			if(highlighter.getHighlights().length > 0){
				highlighter.removeAllHighlights();
			}
		}
	}
}
