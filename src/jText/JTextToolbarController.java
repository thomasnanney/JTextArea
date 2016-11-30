package jText;

public class JTextToolbarController{
	JTextToolbarModel model;
	JTextToolbarController(JTextToolbarView toolbar){
		this.model = new JTextToolbarModel();
		while(!model.isVisible()){
			toolbar.setVisible(false);
		}
		}
	}