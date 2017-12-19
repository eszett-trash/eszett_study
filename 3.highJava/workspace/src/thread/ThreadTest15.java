package thread;

public class ThreadTest15 {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject(); // 공통으로 사용할 객체
		
		WorkerThread wt = new WorkerThread("test1", sObj);
		WorkerThread wt2 = new WorkerThread("test2", sObj);
		
		wt.start();
		wt2.start();
		
		/*
		 동기화 : 한 스레드가 객체의 데이터를 사용하고 있을 때,
		  			다른 스레드가 접근 하지 못하게 객체에 락을 걸어
		  			데이터의 일관성을 유지하는 것

		 */
	}
}

class WorkerThread extends Thread {
	private ShareObject sObj;

	public WorkerThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sObj.add();
		}
	}
}

// 공유할 객체
class ShareObject {
	private int sum = 0;

	public int getSum() {
		return sum;
	}

	//동기화함
	public /*synchronized*/ void add() {
		synchronized (this) {
			int n = sum;

			n += 10;
			sum = n;

			// Thread.currentThread : 현재 작업중인 스레드
			System.out.println(Thread.currentThread().getName() + "합계 : "
					+ getSum());
		}
	}
}