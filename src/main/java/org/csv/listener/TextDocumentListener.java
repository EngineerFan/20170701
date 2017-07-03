package org.csv.listener;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class TextDocumentListener implements DocumentListener {

	protected JTextField jTextField;
	
	public TextDocumentListener(JTextField jTextField) {
		this.setjTextField(jTextField);
	}
	
     @Override
    public void changedUpdate(DocumentEvent e) {
    	// TODO Auto-generated method stub
    	
    }
     
    @Override
    public void insertUpdate(DocumentEvent e) {
    	setJTextFieldBorderStatus();
    }
	
    @Override
    public void removeUpdate(DocumentEvent e) {
    	setJTextFieldBorderStatus();
    }
    
    private void setJTextFieldBorderStatus(){
    	String str = jTextField.getText().trim();
		if(null==str||0==str.length()){
			this.jTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
		}else{
			this.jTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
    }

	public JTextField getjTextField() {
		return jTextField;
	}

	public void setjTextField(JTextField jTextField) {
		this.jTextField = jTextField;
	}
}
