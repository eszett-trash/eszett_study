package thread;

public class ThreadTest19 {
	public static void main(String[] args) {
		WorkObject wobj = new WorkObject();
	
		new ThreadA(wobj).start();
		new ThreadB(wobj).start();
		
	}
}

// 공통으로 사용할 객체
class WorkObject {
	public void methodA() {
		System.out.println("methodA()작업중...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void methodB() {
		System.out.println("methodB() 작업중");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ThreadA extends Thread {
	private WorkObject wObj;

	public ThreadA(WorkObject wObj) {
		super();
		this.wObj = wObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			wObj.methodA();
		}
	}
}

class ThreadB extends Thread {
	private WorkObject wObj;

	public ThreadB(WorkObject wObj) {
		super();
		this.wObj = wObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			wObj.methodB();
		}
	}
}