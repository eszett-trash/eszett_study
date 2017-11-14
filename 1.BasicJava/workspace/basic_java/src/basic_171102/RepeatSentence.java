package basic_171102;

import java.util.Scanner;

class rptSntnce {
	public static void rptFor() {
		/*
		 * 1. 반복문 (for while do_while) -어떤 작업이 반복적으로 수행되도록 할 떄 사용된다. -반복문은 주어진
		 * 조건을 만족하는 동안 반복적으로 수행함으로 조건식을 포함한다. -for문의 경우는 반복횐수 와까루 -while의 경우에는
		 * 반복회수 와까랑
		 * 
		 * 2. for문 초기화 -> 조건식->실행->증감식 -> 조건식->실행->증감식
		 */

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);

		Scanner s = new Scanner(System.in);
		int temp = s.nextInt();

		sum = 0;

		for (int i = 1; i <= temp; i++) {
			sum += i;
		}

		System.out.println(sum);

		sum = 0;
		int sum2 = 0;

		for (int i = 1; i <= 20; i++) {
			if (i % 2 != 0) {
				sum += i;
			} else if (i % 2 == 0) {
				sum2 += i;
			} else {
				continue;
			}
		}
		System.out.println(sum);
		System.out.println(sum2);

	}

	public static void rptWhile() {
		/*
		 * while문 -수행횟수를 모를 때 사용한다. 조건식과 수행해야 할 블럭만으로 구성되어있지만 사용할 변수와 증감식을 함꼐
		 * 사용하여 for문처럼 구성 할 수 있다.
		 */
		int sum = 0;
		int i = 0;
		while (i <= 10) {
			// 3의 배수이면서 5의 배수가 아닌것
			if (i % 3 == 0 && i % 5 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
	}

	public static void rptDoWhile() {
		/*
		 * do while문 while문의 변형으로 기본구조는 while문과 같으나 블럭{}을 먼저 수행하고 조건식을 판단한다
		 * 
		 * 즉,최소 1회는 블럭{}이 수행된다. 기본구조 do{ }while();
		 */
		int i = 1;
		do {
			System.out.println(i);
			i++;
		} while (i <= 10);
	}

	public static void rptTemp() {
		// 짝수단의 홀수곱

		// for (int i = 2; i <= 9; i+=2) {
		// for (int j = 1; j <= 9 ; j+=2) {
		// System.out.println(i+"*"+j+"="+i*j);
		// }
		// System.out.println();
		// }
		int i = 2;

		while (i <= 9) {
			int j = 1;

			if (i % 2 == 0) {
				while (j <= 9) {
					if (j % 2 == 1) {
						System.out.println(i + "*" + j + "=" + i * j);
					}
					j++;
				}
			}
			System.out.println();
			i++;
		}

		int tempSum = 0;
		int temp = 0;

		while (tempSum < 200) {
			++temp;
			tempSum+=temp;
			
		}
		System.out.println(temp);
		System.out.println(tempSum);

	}
}

public class RepeatSentence {
	public static void main(String[] args) {
		rptSntnce.rptTemp();
	}
}
