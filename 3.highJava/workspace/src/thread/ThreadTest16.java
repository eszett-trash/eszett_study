package thread;

/*
 은행의 입출금을 스레드로 처리하는 예제

 synchronized룰 이용한 동기화 예제
 */
public class ThreadTest16 {
	private int balence;

	public int getBalence() {
		return balence;
	}

	public void setBalence(int balence) {
		this.balence = balence;
	}

	//입금
	private void deposit(int money) {
		balence += money;
	}

	// 출금하는 메서드(출금 성공여부 반환)
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야 안전하다.
	private boolean withDraw(int money) {
		synchronized (this) {
			if (balence >= money) {
				for (int i = 0; i < Integer.MAX_VALUE; i++);
				balence -= money;
				System.out.println("메서드 안에서 balence = " + balence);
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest16 acount = new ThreadTest16();
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
