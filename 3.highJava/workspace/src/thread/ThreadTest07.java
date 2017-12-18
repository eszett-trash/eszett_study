package thread;

import javax.swing.JOptionPane;

public class ThreadTest07 extends Thread {

	public static boolean state = false;

	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			if (ThreadTest07.state) {
				System.exit(0);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		System.out.println("5초가 지났습니다 프로그램을 종료합니다.");
		System.exit(0);
		super.run();
	}

	public static void main(String[] args) {
		inptChk th1 = new inptChk();
		ThreadTest07 th2 = new ThreadTest07();
		th1.start();
		th2.start();
	}
}

enum rocksp {
	가위("가위"), 바위("바위"), 보("보");
	private String span;
	private rocksp(String span) {
		this.span = span;
	}
	public String getSpan() {
		return span;
	}
}
class inptChk extends Thread {
	@Override
	public void run() {
		rocksp[] rs = rocksp.values();
		int rsp = (int) (Math.random() * 3);
		String str = JOptionPane.showInputDialog("가위 바위 보중 하나를 입력하세요");
		if (rs[rsp].toString().equals(str)) {
			System.out.println("컴 : " + rs[rsp] + "나 : " + str);
			System.out.println("비겼습니다.");
		} else {
			switch (str) {
			case "가위":
				System.out.println("컴 : " + rs[rsp] + "나 : " + str);
				if (rs[rsp].toString().equals("보")) {
					System.out.println("이겼습니다.");	
				} else {
					System.out.println("졌습니다.");
				}
				break;
			case "바위":
				System.out.println("컴 : " + rs[rsp] + "나 : " + str);
				if (rs[rsp].toString().equals("가위")) {
					System.out.println("이겼습니다.");
				} else {
					System.out.println("졌습니다.");
				}
				break;
			case "보":
				System.out.println("컴 : " + rs[rsp] + "나 : " + str);
				if (rs[rsp].toString().equals("바위")) {
					System.out.println("이겼습니다.");
				} else {
					System.out.println("졌습니다.");
				}
				break;
			default:
				System.out.println("머가문젤까?");
				break;
			}
		}
		ThreadTest07.state = true;
		super.run();
	}
}	