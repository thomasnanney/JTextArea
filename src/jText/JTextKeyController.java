package jText;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * This class will register keys typed in, specifically when
 * 	typed with Ctrl (ie. Ctrl+S).
 * 
 * @author Jose Bocanegra
 */
public class JTextKeyController {

	JTextView view;
	JTextPane textPane;
	String prev;
	int isComment;
	
	public JTextKeyController(JTextView view){
		this.view = view;
	}
	
	public void registerKeyListener(final JTextController controller) {
		textPane = view.getPane();
		System.out.println(" ");
		textPane.addKeyListener(new java.awt.event.KeyAdapter() {
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
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_Z){
	            	ActionEvent e = new ActionEvent(controller, 0, "Undo");
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
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_N){
	            	ActionEvent e = new ActionEvent(controller, 0, "New");
	            	controller.actionPerformed(e);
	            }
	            /**
	             * The following, Cut and Paste, are already defaulted in. We are
	             * 	just making sure our JFrame is updating it's title correctly.
	             */
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_X){
	            	if(!view.titleChange()){
	    				view.setTitle(view.getTitle() + "*");
	    			}
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_V){
	            	if(!view.titleChange()){
	    				view.setTitle(view.getTitle() + "*");
	    			}
	            }
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_P){
	            	ActionEvent e = new ActionEvent(controller, 0, "Print");
	            	controller.actionPerformed(e);
	            }
	        }
	    });
	}
}
