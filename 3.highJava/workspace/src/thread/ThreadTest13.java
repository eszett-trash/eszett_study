package thread;

/*
 Thread의 stop()메서드를 호출하면 스레드가 바로 멈춘다.
 이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어서
 나중에 실행되는 프로그램에 영향을 줄 수 있다.
 그래서 stop()메서드의 사용은 추천한지 않는다.
 */

public class ThreadTest13 {
	public static void main(String[] args) {
		// StopTestThread1 th1 = new StopTestThread1();
		// th1.start();
		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// // th1.stop(); // 정상종료 되지 않음
		// th1.setStop(true); // 종료
		// }

		// interrupt()메소드를 이용한 스레드 멈추기 연습
		InterruptTestThread th2 = new InterruptTestThread();
		th2.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.interrupt();
	}
}

class StopTestThread1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("쓰레드 실행중 ... ");
		}
		System.out.println("자원정리-------------------");
		System.out.println("실행 종료----------------------");
	}
}

class InterruptTestThread extends Thread {
	@Override
	public void run() {
		// 방법 1 0 -> interrupt()명령을 감지하기 위해 짧은 시간의 일시정지 상태를 이용한다.
		// try {
		// while (true) {
		// System.out.println("실행중....");
		// Thread.sleep(1);
		// }
		// } catch (InterruptedException e) {
		// System.out.println("자원정리");
		// }
		// 방법 2 --> 일시정지를 사용하지 않고 interrupt()명령을 감지하는 방법

		while (true) {
			System.out.println("inerrupt 실행중 ... ");
			// interrupt()가 호출되었는지 검사하는 방법 1
			// ->인스턴스 객체용 메서드인 isInerrupted()를 이용하기

			// if (this.isInterrupted()) {
			// System.out.println("인터럽트 종료..");
			// break;
			// }
			
			
			// interrupt()가 호출되었는지 검사하는 방법 2
			// ->thread의 static메서드 interrupted호출
			if (Thread.interrupted()) {
				break;
			}
		}
		System.out.println("자원정리...");
	}
}