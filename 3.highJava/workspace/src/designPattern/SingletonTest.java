package designPattern;

public class SingletonTest {
	public static void main(String[] args) {
		Thread t = new temp();
		t.start();
		Thread t2 = new temp();
		t2.start();
		Thread t3 = new temp();
		t3.start();
		
	}
}

class temp extends Thread {
	@Override
	public void run() {
		MySingleton m = MySingleton.getInstance();
		System.out.println("주소값 : " + m);
	}
}
