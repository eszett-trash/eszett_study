package args;

public class ArgsTest {
	/*
	 * 가변형 인수 -> 메서드의 매개변수의 개수가 실행될 때 마다 다를 때 사용한다. -> 이 가변형 인수는 메서드 내에서는 배열로
	 * 처리된다. -> 가변형 인수는 한가지 자료형만 사용 할 수 있다.
	 */
	
	// 배열을 이용한 메서드(여러개의 정수형 데이터를 매개변수로 받아서 이들의 함게를 구하는 메서드
	public int sumArr(int[] data) {
		int sum = 0;

		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	//가변형 인수를 이용한 메서드
	public int sumArg(int... data) {
		int sum = 0;

		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	//가변형 인수를 다른 매개변수와 같이 사용할때는 제일 뒤에 배치해야한다.
	public void testArg(String name, int...data)
	{
		
	}

	public static void main(String[] args) {
		ArgsTest ag = new ArgsTest();

		int[] nums = { 100, 200, 300 };
		System.out.println(ag.sumArr(nums));
		System.out.println(ag.sumArr(new int[] { 10, 20, 30, 40, 50 }));
	}
}
