package basic_171127;

public class Exception01 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
//		for (int i = 0; i < 10; i++) {
//			result = number / (int)(Math.random()*5);
//			System.out.println(result);
//		}
		
		for (int i = 0; i < 10; i++) {
			try {
				result = number / (int)(Math.random()*5);
				System.out.println(result);
			} catch (ArithmeticException e) {
				System.out.println("0으로 나누지 마");
			}
			
		}
		System.out.println("END");
	}
}
