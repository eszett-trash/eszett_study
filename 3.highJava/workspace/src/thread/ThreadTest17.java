package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest17 {
	private int balence;
	// Lock객체는 private final 선언
	private final Lock lock = new ReentrantLock();

	public int getBalence() {
		return balence;
	}

	public void setBalence(int balence) {
		this.balence = balence;
	}

	// 입금
	private void deposit(int money) {
		// lock() 메서드로 락을 설정 한 곳에서는
		// 반드시 unlock()메서드로 락을 해제해주어야 한다.
		lock.lock();
		balence += money;
		lock.unlock();
	}

	// 출금하는 메서드(출금 성공여부 반환)
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야 안전하다.
	private boolean withDraw(int money) {
		// lock.lock();
		// boolean chk;
		// if (balence >= money) {
		// for (int i = 0; i < Integer.MAX_VALUE; i++);
		// balence -= money;
		// System.out.println("메서드 안에서 balence = " + balence);
		// chk = true;
		// } else {
		// chk = false;
		// }
		// lock.unlock();
		// return chk;

		
		// try~catch문을 사용하는 경우
		lock.lock();
		boolean chk = false;
		try {
			if (balence >= money) {
				for (int i = 0; i < Integer.MAX_VALUE; i++);
				balence -= money;
				System.out.println("메서드 안에서 balence = " + balence);
				chk = true;
			} else {
				chk = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
		return chk;
	}

	public static void main(String[] args) {
		ThreadTest17 acount = new ThreadTest17();
		acount.setBalence(10000);

		Runnable withdrawTest = new Runnable() {
			@Override
			public void run() {
				boolean result = acount.withDraw(6000);
				System.out.println("스레드에서 result : " + result + " , balence : "
						+ acount.getBalence());
			}
		};

		Thread th1 = new Thread(withdrawTest);
		Thread th2 = new Thread(withdrawTest);

		th1.start();
		th2.start();
	}
}
