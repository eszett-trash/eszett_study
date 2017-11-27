package basic_171127;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnoInner02 {
	public static void main(String[] args) {
		Button b = new Button();
		
		b.addActionListener(new ActionListener() {
			
			//클래스 명이 없는 클래스	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
