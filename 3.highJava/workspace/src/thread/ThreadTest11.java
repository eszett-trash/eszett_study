package thread;

public class ThreadTest11 {
	public static void main(String[] args) {
		StateProntThread spt = new StateProntThread(new TargetTherad());
		
		spt.start();
	}
}

// 대산 스레드의 상태를 출력하는 스레드

class StateProntThread extends Thread {
	private Thread targetThread;

	public StateProntThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	@Override
	public void run() {
		while (true) {
			// 대상 스레드의 상태 구하기
			Thread.State state = targetThread.getState();
			System.out.println("대상 스레드의 상태값 : " + state);
			if (state == Thread.State.NEW) { // new상태인지 검사
				targetThread.start();
			}
			if (state == Thread.State.TERMINATED) { // 종료되었는지 검사
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class TargetTherad extends Thread{
	@Override
	public void run() {
		
		//상태지연용
		for (long i = 0; i < 2_000_000_000L; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (long j = 0; j < 2_000_000_000L; j++) {}
	}
}