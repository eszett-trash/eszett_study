package thread;

public class ThreadTest04 {
	/*
	 * 1~20억까지의 합계를 구하는데 걸린 시간 체크하기
	 * 
	 * 전체 합계를 구하는 작업을 단독으로 했을때와 여러쓰레드로 분할해서 작업할때의 시간을 확인 해 보자.
	 */

	public static void main(String[] args) {
		SumThread sm = new SumThread(1, 2_000_000_000L);
		SumThread[] smArr = new SumThread[] { new SumThread(1, 500_000_000L),
				new SumThread(500_000_001L, 1_000_000_000L),
				new SumThread(1_000_000_001L, 1_500_000_000L),
				new SumThread(1_500_000_001L, 2_000_000_000L) };

		// 단독처리
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();

		System.out.println("단독처리 경과시간 : " + (endTime - startTime));

		// 병렬처리
		startTime = System.currentTimeMillis();
		for (SumThread sumThread : smArr) {
			sumThread.start();
		}
		try {
			for (SumThread sumThread : smArr) {
				sumThread.join();
			}
		} catch (Exception e) {
		}
		endTime = System.currentTimeMillis();

		System.out.println("병렬처리 경과시간 : " + (endTime - startTime));
	}
}

class SumThread extends Thread {
	private long min, max;

	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		long sum = 0;

		for (long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
		super.run();
	}

}