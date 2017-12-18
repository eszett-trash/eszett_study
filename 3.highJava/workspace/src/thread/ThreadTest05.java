package thread;


public class ThreadTest05 {
	public static void main(String[] args) {
		//js prompt랑 비슷함
//		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
//		System.out.println("입력한 값 : " + str);
		
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
