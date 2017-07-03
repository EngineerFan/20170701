package org.csv.ui.views;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Document;
import org.csv.listener.ClearTextFieldListener;
import org.csv.listener.ExecuteActionListener;
import org.csv.listener.SaveDocumentListener;
import org.csv.listener.SelectActionListener;
import org.csv.listener.SelectDocumentListener;

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JButton jBtnSelect,jBtnBegin,jBtnClear;//选择文件按钮，开始解析csv文件按钮,清楚文本框；
	private JTextField jtextPath,jtextSavePath;//文件路径文本框，解析文件保存文件名；
	private JTextArea jtextArea;//解析日志文本
	private JLabel jLabel;//解析时间
	private JScrollPane jScrollPane;//日志滚动面板
	public MyPanel() {
		this.setLayout(null);
		initComponent();
	}
	
	//初始化组件
	private void initComponent(){
		jBtnSelect = new JButton("选择文件");
		jBtnBegin = new JButton("执行操作");
		jBtnClear = new JButton("清除");
		jLabel = new JLabel("CSV",JLabel.CENTER);
		jScrollPane = new JScrollPane();
		jBtnSelect.setBounds(10, 20, 100, 30);
		jBtnBegin.setBounds(200, 400, 100, 30);
		jBtnClear.setBounds(10, 80, 70, 30);
		jtextPath = new JTextField();
		jtextPath.setBounds(150, 20, 300, 30);
		jtextPath.setBorder(BorderFactory.createLineBorder(Color.RED));
		jtextPath.setEditable(false);
		jtextSavePath = new JTextField();
		jtextSavePath.setBounds(150, 80, 300, 30);
		jtextSavePath.setBorder(BorderFactory.createLineBorder(Color.RED));
		jtextArea = new JTextArea();
		jtextArea.setBounds(0,0,400,200);
		jtextArea.setLineWrap(true);
		jtextArea.setWrapStyleWord(true);
		jScrollPane.setBounds(50, 180, 400, 200);
		jLabel.setBounds(100, 150, 300, 30);
		jLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setViewportView(jtextArea);
		initEventListener();
		
		this.add(jBtnSelect);
		this.add(jBtnBegin);
		this.add(jtextPath);
		this.add(jBtnClear);
		this.add(jtextSavePath);
		this.add(jScrollPane);
		this.add(jLabel);
	}
	
	//初始化监听事件
	private void initEventListener(){
		jBtnSelect.addActionListener(new SelectActionListener(this));
		jBtnBegin.addActionListener(new ExecuteActionListener(this));
		jBtnClear.addActionListener(new ClearTextFieldListener(this));
		Document saveDoc = jtextSavePath.getDocument();
		saveDoc.addDocumentListener(new SaveDocumentListener(jtextSavePath));
		Document selectDoc = jtextPath.getDocument();
		selectDoc.addDocumentListener(new SelectDocumentListener(jtextPath));
	}

	
	/*********set&get**************/
	public JTextField getJtextPath() {
		return jtextPath;
	}

	public void setJtextPath(JTextField jtextPath) {
		this.jtextPath = jtextPath;
	}

	public JTextField getJtextSavePath() {
		return jtextSavePath;
	}

	public void setJtextSavePath(JTextField jtextSavePath) {
		this.jtextSavePath = jtextSavePath;
	}
	
	public JTextArea getJtextArea() {
		return jtextArea;
	}

	public void setJtextArea(JTextArea jtextArea) {
		this.jtextArea = jtextArea;
	}
	
	
	
	
}