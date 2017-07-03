package org.csv.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.csv.task.MyTaskThread;
import org.csv.ui.views.MyPanel;
import org.csv.util.CsvUtil;

public class ExecuteActionListener implements ActionListener{
	

    private MyPanel myPanel;
   
	
	public ExecuteActionListener(MyPanel myPanel) {
		this.myPanel = myPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		StringBuilder sb = new StringBuilder();
		JTextField jTextSource = myPanel.getJtextPath();
		JTextField jTextSaveName = myPanel.getJtextSavePath();
		String sourcePath = jTextSource.getText().trim();
		String targetSaveName = jTextSaveName.getText().trim();
		if(sourcePath==null||0==sourcePath.length()){
			JOptionPane.showMessageDialog(null, "请选择有效的CSV文件！","警告提示",JOptionPane.WARNING_MESSAGE);
			return;
		}
        if(targetSaveName==null||0==targetSaveName.length()){
        	targetSaveName = String.valueOf(new Date().getTime());
        }
		String temp[] = sourcePath.split("\\\\");
		if(temp.length>0){
			for (int i = 0; i < temp.length-1; i++) {
				sb.append(temp[i]);
				sb.append("\\");
			}
			sb.append(targetSaveName);
			sb.append(".csv");
		}
		String targetPath = sb.toString();
		CsvUtil.fixThreadPool.execute(new MyTaskThread(sourcePath, targetPath,myPanel.getJtextArea()));
	}
}