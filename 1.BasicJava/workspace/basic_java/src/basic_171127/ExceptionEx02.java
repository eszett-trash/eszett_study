package basic_171127;

public class ExceptionEx02 {
	public static void main(String[] args) {
		int a = 3;
		int b = 0;

		try {
			
			//1. 문장을 실행한다.
				System.out.println(a);
			//2. 예외가 발생한다
				System.out.println(a/b);
			//3. 예외가 발생하면 실행되지 않는다.
				System.out.println(b);
		
		
		//4. 일치하는 예외를 찾고 실행한다
		} catch (ArithmeticException e) {
			//예외 발생 당시의 호출스택에 있던 메서드의 정보와 예외 메세지를 화면에 출력한다.
			
		//	e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		System.out.println(6);
	}
}
