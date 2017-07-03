package org.csv.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.csv.ui.views.MyPanel;

public class ClearTextFieldListener implements ActionListener {

	private MyPanel myPanel;
	
	public ClearTextFieldListener(MyPanel myPanel) {
		this.myPanel = myPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField jTextSourcePath = myPanel.getJtextPath();
		JTextField jTextSavePath = myPanel.getJtextSavePath();
		if(null!=jTextSourcePath.getText().trim()||!"".equals(jTextSourcePath.getText().trim())){
			jTextSourcePath.setText(null);
		}
		if(null!=jTextSavePath.getText().trim()||!"".equals(jTextSavePath.getText().trim())){
			jTextSavePath.setText(null);
		}
	}

}
