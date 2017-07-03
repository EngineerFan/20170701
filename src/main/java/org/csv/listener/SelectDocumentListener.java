package org.csv.listener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

public class SelectDocumentListener extends TextDocumentListener{
	
	public SelectDocumentListener(JTextField jTextField) {
		super(jTextField);
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	    super.insertUpdate(e);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	   super.removeUpdate(e);
	}

}
