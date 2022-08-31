package com.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBar {
	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar();
	JLabel label;
	
	public ProgressBar() {
		bar.setValue(0);
		bar.setBounds(0, 0, 420, 50);
		bar.setString("와이파이 정보를 가져오는 중입니다. 잠시만 기다려주세요.");
		bar.setStringPainted(true);
		
		frame.add(bar);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void fill(int n, int max) {
		bar.setValue(n / max);
	}
	
	public void quit() {
		frame.setVisible(false);
	}
}
