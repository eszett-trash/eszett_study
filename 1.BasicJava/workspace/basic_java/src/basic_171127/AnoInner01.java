package basic_171127;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnoInner01 {


	public static void main(String[] args) {
		Button b = new Button();
		ActionListener l = new EventHandler();
		b.addActionListener(l);
	}
}

class EventHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌림");
		
	}
	
}