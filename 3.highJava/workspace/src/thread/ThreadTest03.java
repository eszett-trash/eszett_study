package thread;


public class ThreadTest03 {
	//thead의 수행시간 체크 해 보기
	
	public static void main(String[] args) {
		Thread th = new Thread(new MyRunner());
		
		long startTime = System.currentTimeMillis();
		
		th.start();
		try {
			th.join();		//현재 실행중인 쓰레드에서 호출한 해당 thread가
							//끝날때까지 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간 : "+(endTime-startTime));
	}
}

class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum = 0;
		for (int i = 0; i < 1000_000_000L; i++) { 		//이경우 언더바 무시
			sum+=i;
		}
		System.out.println(sum);
	}
}