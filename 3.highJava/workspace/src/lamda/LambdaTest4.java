package lamda;

public class LambdaTest4 {
	// 메서드 안에서 람다식을 사용 할 때 변수
	public void method(int temp) {
		int localVar = 40; // 지역변수
		//lambda, 혹은 내부클래스에서 사용되는 지역변수는 전부 상수
		
		ILambdaTest lt = () -> {
			System.out.println(localVar);
			System.out.println(temp);
		};
		lt.test();
	}

	public static void main(String[] args) {
		new LambdaTest4().method(200);
	}
}
