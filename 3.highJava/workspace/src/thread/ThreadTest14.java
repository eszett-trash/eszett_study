package thread;

/*
 스레드간 데이터공유 test
 -원주율 계산 스레드
 -계산된 원주율을 출력하는 스레드

 -이 때 원주율을 저장하는 객체가 필요하다.
 -이 객체는 두개의 쓰레드에 대응한다
 */
public class ThreadTest14 {
	public static void main(String[] args) {
		pi p = new pi();
		PrintThread print = new PrintThread();
		
		ShareData sd = new ShareData();
		
		print.setSd(sd);
		p.setSd(sd);
		
		print.start();
		p.start();
	}
}

// 스레드에서 공통으로 사용할 class -->원주율을 관리하는 클래스

class ShareData {
	public double pi; // 계산된 원주율 결과가 저장될 변수

	/*
	  volatile -> 선언된 변수를 컴파일러의 최적화 대상에서 제외시킨다.
	  			-> 즉 값이 변경되는 즉시 변수에 적용시킨다.
	  			-> 다중 스레드 환경에서 하나의 변수가 완벽하게
	  			-> 한번에 작동하도록 보장하는 키워드.
	 */
	public volatile boolean isOk = false; // 계산이 완료되었는지 여부를 나타내는 변수
}

// 원주율을 계산하는 스레드
class pi extends Thread {
	private ShareData sd = new ShareData();
	public void setSd(ShareData sd) {
		this.sd = sd;
	}
	@Override
	public void run() {
		double sum = 0.0;
		for (int i = 1; i < 1000000000L; i+=2) {
			if ((i / 2) % 2 == 0) {
				sum += 1 / i;
			} else
				sum -= 1 / i;
		}
		sd.pi = sum * 4;
		sd.isOk = true;
	}
}

class PrintThread extends Thread {
	private ShareData sd;

	public void setSd(ShareData sd) {
		this.sd = sd;
	}

	@Override
	public void run() {
		while (!sd.isOk) {
			continue;
		}
		System.out.println();
		System.out.println("계산결과 : " + sd.pi);
		System.out.println("PI :" + Math.PI);
	}
}