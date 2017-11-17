package basic_171116;

public class PrintCall {

	int a1 = 3;
	int b1 = 5;

	long a2 = 6L;
	long b2 = 10L;

	int add(int c) {
		return a1 + b1 + c;
	}

	long add(long c) {
		return a1 + b1 + c;
	}

	long add(int c, int d) {
		return c + d;
	}

	float add(int c, float d) {
		return c + d;
	}

	public static void main(String[] args) {

		PrintCall pc = new PrintCall();

		int result1 = pc.add(1);
		long result2 = pc.add(1L);
		long result3 = pc.add(1, 2);
		float result4 = pc.add(1, 1.1f);

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}
}
