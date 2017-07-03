package org.csv.client;

import javax.swing.JFrame;

import org.csv.ui.MyFrame;

public class Client {
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MyFrame("CSV解析");
	}
}
