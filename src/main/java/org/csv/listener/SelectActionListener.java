package org.csv.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.csv.ui.views.MyPanel;

public class SelectActionListener implements ActionListener {
	
    private MyPanel myPanel;
	
	public SelectActionListener(MyPanel myPanel) {
		this.myPanel = myPanel;
	}
	
	private class CsvFileFilter extends FileFilter{

		@Override
		public boolean accept(File f) {
			// TODO Auto-generated method stub
			return f.getName().endsWith(".csv");
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return ".csv";
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jFileChooser = new JFileChooser(new File("C:\\Users\\FXL\\Desktop"));
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jFileChooser.showDialog(new JLabel(), "选择");
		jFileChooser.setFileFilter(new CsvFileFilter());
		JTextField jtextPath = myPanel.getJtextPath();
		File f = jFileChooser.getSelectedFile();
		if(null==f){
		   return;
		}
	    String sourceCsvPath = f.getAbsolutePath();
	    //判断选择文件路径TextField是否存在内容
	    //将路径String赋值到文本框中
	    jtextPath.setText(sourceCsvPath);
	}

}