package lamda;

public class LambdaTest implements ILambdaTest {

	@Override
	public void test() {
		System.out.println("ㅎㅇ");
	}

	public static void main(String[] args) {
		ILambdaTest lt1 = new ILambdaTest() {
			@Override
			public void test() {
				System.out.println("ㅎㅇ");
			}
		};
		lt1.test();

		ILambdaTest lt2 = () -> System.err.println("ㅎㅇ");
		lt2.test();

		// --------------------------------------------------------------//

		ILambdaTest2 lt2_1 = a -> {
			int result = a + 100;
			System.out.println(result);
		};
		ILambdaTest2 lt2_2 = a -> {
			int result = a + 200;
			System.out.println(result);
		};
		ILambdaTest2 lt2_3 = a ->System.err.println(a+300);
		lt2_1.test(10);
		lt2_2.test(10);
		lt2_3.test(100);
		
		// --------------------------------------------------------------//
		
		ILambdaTest3 lt3 = (a,b)->{return a+b;};
		System.out.println(lt3.test(1, 2));
		ILambdaTest3 lt3_2 = (a,b)->a+b;
		System.out.println(lt3_2.test(10, 20));
	}
}
