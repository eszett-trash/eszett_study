package thread;

public class ThreadTest08 {
	public static void main(String[] args) {
		Thread tt = new ThreadTest();
		Thread tt2 = new ThreadTest2();

		// 우선순윈는 start method를 호출하기 전에 설정
		tt.setPriority(1);
		tt2.setPriority(9);
		
		System.out.println("tt의 우선순위 : " + tt.getPriority());
		System.out.println("tt2의 우선순위 : " + tt2.getPriority());
		
		tt.start();
		tt2.start();
	}
}

class ThreadTest extends Thread{
	@Override
	public void run() {
			for (char ch = 'A'; ch <= 'Z' ; ch++) {
				System.out.print(ch);
				for (long i = 1; i < 10000000L; i++) {
					
				}
				System.out.println();
			}
	}
}
class ThreadTest2 extends Thread{
	@Override
	public void run() {
			for (char ch = 'a'; ch <= 'z' ; ch++) {
				System.out.print(ch);
				for (long i = 1; i < 10000000L; i++) {
					
				}
			}
			System.out.println();
	}
}