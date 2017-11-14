package basic_171103;

public class ArrayPrac {

	public static void main(String[] args) {
		/*
		 * 1. 배열 -arrayp -같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
		 * 
		 * 
		 * int score1 = 10; int score2 = 20; int score3 = 30; int score4 = 40;
		 * 
		 * 2. 배열의 선언 -원하는 타입의 변수를 선언하고 변수 또는 자료형에 배열임을 알려주는 대괄호 []를 붙이면 된다.
		 * 
		 * ex)int score[] = new int[4]; int[] score;
		 * 
		 * 3. 배열의 초기화 -배열을 선언하였다면 배열을 생성해야한다. -배열 생성을 위해서는 연산자 new와 함께 배열의 타입과
		 * 크기를 지정해주어야 한다. -배열도 객체임으로멤버변수와 매서드를 갖고 있으며 이중 멤버변수 length는 배열의 크기를
		 * 반환한다.
		 */
		// int[] score = new int[4];
		// int[] score2 = new int[] { 1234 };
		// int[] score3 = { 1, 2, 3, 4 };
		//
		// System.out.println(score[0]);
		// int sum = 0;
		// for (int i = 0; i < score3.length; i++) {
		// System.out.println(score3[i]);
		// sum += score3[i];
		// }
		//
		// System.out.println(sum);
		int score[] = new int[6];
		// for문
		for (int i = 0; i < score.length; i++) {
			score[i] = (int) (Math.random() * 101);

		}
		System.out.println("각방의 값을 출력");
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		System.out.println("\n\n합계");
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		System.out.println(sum);

		System.out.println("\n평균");
		float ave = (int) (((float) sum / score.length) * 100 + 0.5f) / 100f;
		System.out.println(ave);

		// 각방에 들어잇는 것들 중 최대값 최소값
		int max = score[0];

		for (int i = 1; i < score.length; i++) {
			if (max < score[i]) {
				max = score[i];
			}
		}

		System.out.println("\n최대 : " + max);

		int min = score[0];

		for (int i = 1; i < score.length; i++) {

			if (min > score[i]) {
				min = score[i];
			}
		}

		System.out.println("최소 : " + min);

	}

}
