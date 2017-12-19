package thread;

/*
 3명의 스레드가 각각 알파벳을 A~Z까지 출력하는데
 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
 */

public class ThreadTest10 {
	public static String strRank = "\0";

	public static void main(String[] args) {
		DisplayCharactor[] temp = new DisplayCharactor[] {
				new DisplayCharactor("가나다"), new DisplayCharactor("라마바"),
				new DisplayCharactor("사아자") };

		for (int i = 0; i < temp.length; i++) {
			temp[i].start();
		}
		for (DisplayCharactor displayCharactor : temp) {
			try {
				displayCharactor.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("경기결과");
		System.out.println("순위 : "+strRank);
	}
}

class DisplayCharactor extends Thread {
	private String name;

	public DisplayCharactor(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.println(name + "의 출력문자 : " + i);
			try {
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "씨 출력 끝 ... ");
		ThreadTest10.strRank += name+"  ";
	}
}