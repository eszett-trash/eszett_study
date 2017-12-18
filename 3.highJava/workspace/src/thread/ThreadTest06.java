package thread;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	//input thread에서 입력여부를 확인하기 위한 변수 선언
	//static 변수를 thread에서 공통으로 사용할 변수로
	public static boolean inputChk= false;
	public static void main(String[] args) {
		DataInput th1 = new DataInput();
		CntDn th2 = new CntDn();
		
		th1.start();
		th2.start();
		
	}
}

class DataInput extends Thread{
	@Override
	public void run() {
		String std = JOptionPane.showInputDialog("아무거나 입력하세요");
		ThreadTest06.inputChk = true;
		System.out.println("입력한 값 : " + std);
	}
}
class CntDn extends Thread{
	@Override
	public void run() {
		for (int i = 10; i >0; i--) {
			System.out.println(i);
			
			if (ThreadTest06.inputChk) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("10초가 지났습니다 프로그램을 종료합니다.");
		System.exit(0);
		super.run();
	}
}