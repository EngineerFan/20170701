package org.csv.ui;

import javax.swing.JFrame;

import org.csv.ui.views.MyPanel;



public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
    
	private MyPanel myPanel;
	
	public MyFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		myPanel = new MyPanel();
		this.setContentPane(myPanel);
		this.setVisible(true);	
	}

	public MyPanel getMyPanel() {
		return myPanel;
	}

	public void setMyPanel(MyPanel myPanel) {
		this.myPanel = myPanel;
	}
	
}
