package jText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToolBar;

public class JTextToolbarController implements ActionListener{
	
	private JToolBar toolbar;
	
	JTextToolbarController(JToolBar toolbar){
		this.toolbar = toolbar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		toolbar.setVisible(!toolbar.isVisible());
	}
}