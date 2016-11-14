package jText;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

public class JTextKeyController {

	JTextView view;
	JTextArea area;
	
	public JTextKeyController(JTextView view){
		this.view = view;
	}
	
	public void registerKeyListener(JTextController controller) {
		area = view.getArea();
		area.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyPressed(java.awt.event.KeyEvent event) {
	            if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_S) {
	                ActionEvent e = new ActionEvent(controller, 0, "Save");
	                controller.actionPerformed(e);
	            }
	        }
	    });
		view.updateArea(area);
	}
}
