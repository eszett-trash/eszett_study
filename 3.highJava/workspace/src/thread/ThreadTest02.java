package thread;

public class ThreadTest02 {
	public static void main(String[] args) {
		// 멀티 스레드 프로그램 연습

		// thread를 사용하는 방법

		// 방법1. thread클래스를 상속한 class를 작성한 후 이 클래스의 인스턴스를 생성하고.
		// 이 인스턴스의 start()메서드를 호출한다.
		MyThread1 th1 = new MyThread1();
		
		//방법2.
		//runnable인터페이스를 구현한 class를 작성한 후 이 class의
		//인스턴스를 생성하고 이 인스턴스를 이 thread객체의 인스턴스를 생성할 때 생성자의
		//매개변수로 넘겨준다.
		MyThread2 th2 = new MyThread2();
		Thread thr2 = new Thread(th2);
		
		//상속을 한가지밖에 받지 못하기때문에 extends와 implement를 다르게 씀
		//Runnable 인터페이스는 run() 메소드밖에 존재하지 않으며
		//Thread는 Runnable 인터페이스를 상속받고 있음
		
		//방법3.
		//익명클래스를 이용하는 방법
		//Runnable 인터페이스를 구현한 익명클래스를 만든 후 이것을
		//Thread인스턴스를 생성 할 때 매개변수로 넘겨준다.
		Thread th3 = new Thread( 	//지금처럼 익명클래스를 만들때는 인터페이스 객체 생성이 가능함.
				new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < 200; i++) {
							System.out.print("@");
							try {
								//시간은 밀리세컨드단위를 사용한다.
								Thread.sleep(100);
							} catch (Exception e) {
							}
						}
					}
				});
		th1.start();
		thr2.start();
		th3.start();
	}
}

// extends thread class
class MyThread1 extends Thread {
	@Override
	public void run() {
		//이 영역에 스레드에서 처리할 내용을 기술한다
		
		for (int i = 0; i < 200; i++) {
			System.out.print("*");
			try {
				//시간은 밀리세컨드단위를 사용한다.
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		super.run();
	}
}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.print("$");
			try {
				//시간은 밀리세컨드단위를 사용한다.
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}