package basic_171127;


public class InnerEx02 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		//inner클래스 안의 메소드에 접근 하는 방법
		Outer.Inner inner = outer.new Inner();
		inner.method();
	}
}

class Outer {
	int value = 10;

	class Inner {
		int value = 20;

		void method() {
			int value = 30;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer.this.value);
		}
	}
}