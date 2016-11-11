package jText;

import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

public class JTextControllerCut {
	
	private JTextArea area;
	
	private String str;
	
	public JTextControllerCut(JTextArea area) {
		this.area = area;
		
	}

	public void mouseReleased(MouseEvent e){
		System.out.println("HERE");
		////if(area.getHighlights() != null){
			//str = area.getHightligths();
		//	System.out.print(str);
		//}
	}
}
