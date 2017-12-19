package thread;

public class ThreadTest09 {
	public static void main(String[] args) {
		AutoSaveThread ast = new AutoSaveThread();
		
		//daemon method 
		//선언은 start method에서 실행하기 전에 한다.
		ast.setDaemon(true);
		ast.start();
		
		//another Thread
		for (int i = 0; i <20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("주 스레드가 종료되었습니다.");
	}
}
//자동 저장하는 thread (3초에 한 번씩)
class AutoSaveThread extends Thread{
	private void save() {
		System.out.println("작업 내용을 저장합니다.");
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save();
		}
	}
}