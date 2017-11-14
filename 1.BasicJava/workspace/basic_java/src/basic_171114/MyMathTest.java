package basic_171114;

public class MyMathTest {
	public static void main(String[] args) {

		
		MyMath m = new MyMath();
		
		long result1 = MyMath.add(1L, 4L);
		long result2 = m.multiply(3000, 3000, 3000);
		float result3 = m.divide(10, 6);
		int result4 = MyMath.substract('2');
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);

	}
}

class MyMath {

	static int num = 50;

	static long add(long a, long b) {
		return a + b;
	}

	static int substract(char a) {
		return num - (a - '0');
	}
	
	long multiply(int a, int b, int c) {
		return (long) a * b * c;
	}

	float divide(int a, int b) {
		return (int) ((float) a / b * 100 + 0.5) / 100f;
	}

	
}

