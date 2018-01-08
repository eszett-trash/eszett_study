package lamda;

//내부클래스의 메서드에서 만들어지는 람다식에서
public class LambdaTest3 {
	public int outterField = 10;
	int temp = 100;

	class LambdaInner {
		int innerField = 20;
		int temp = 200;
		void method() {
			ILambdaTest lt = () -> {
				System.out.println("ㅎㅇㅇ");
				System.out.println(outterField);
				System.out.println(LambdaTest3.this.outterField);
				System.out.println(temp);
				System.out.println(LambdaTest3.this.temp);
				System.out.println(this.innerField);
			};
			lt.test();
		}
	}
	public static void main(String[] args) {
		LambdaTest3 lb = new LambdaTest3();
		LambdaTest3.LambdaInner li = lb.new LambdaInner();
		
		li.method();
		
		System.out.println(lb.outterField);
		
		
	}
}
