package jText;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

/**
 * This class will register keys typed in, specifically when
 * 	typed with Ctrl (ie. Ctrl+S).
 * 
 * @author Jose Bocanegra
 */
public class JTextKeyController {

	JTextView view;
	JTextArea area;
	
	public JTextKeyController(JTextView view){
		this.view = view;
	}
	
	public void registerKeyListener(final JTextController controller) {
		area = view.getArea();
		area.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyPressed(java.awt.event.KeyEvent event) {
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_S) {
	                ActionEvent e = new ActionEvent(controller, 0, "Save");
	                controller.actionPerformed(e);
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_F) {
	                ActionEvent e = new ActionEvent(controller, 0, "Find");
	                controller.actionPerformed(e);
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_R) {
	                ActionEvent e = new ActionEvent(controller, 0, "Replace");
	                controller.actionPerformed(e);
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_X){
	            	ActionEvent e = new ActionEvent(controller, 0, "Cut");
	            	controller.actionPerformed(e);
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_C){
	            	ActionEvent e = new ActionEvent(controller, 0, "Copy");
	            	controller.actionPerformed(e);
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_V){
	            	ActionEvent e = new ActionEvent(controller, 0, "Paste");
	            	controller.actionPerformed(e);
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_Z){
	            	ActionEvent e = new ActionEvent(controller, 0, "Undo		CTRL+Z");
	            	controller.actionPerformed(e);
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_Y){
	            	ActionEvent e = new ActionEvent(controller, 0, "Redo");
	            	controller.actionPerformed(e);
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_O){
	            	ActionEvent e = new ActionEvent(controller, 0, "Open");
	            	controller.actionPerformed(e);
	            }
	        }
	    });
	}
}
