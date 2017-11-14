package basic_171031;

import java.util.Scanner;

class exCdn {
	public static void exIf() {
		/*
		 * 1. 조건문 (if, switch) -조건식과 실행될 문장을 포함하는 블럭으로 이루어져있다. -조건식의 연산 결과에 따라
		 * 프로그램의 실행 흐름을 변경 할 수 있다.
		 */

		int a = 40;

		if (a < 100) {
			System.out.println("100보다 작다");
		} else if (a == 0) {
			System.out.println("0");
		} else {
			System.out.println("100보다 크다");
		}

		int sj = (int) (Math.random() * 101);
		System.out.print(sj + "점 : ");

		if (90 <= sj) {
			System.out.print("A");
			if (95 <= sj) {
				System.out.println("+");
			}
			if (95 > sj) {
				System.out.println("-");
			}
		} else if (80 <= sj) {
			System.out.print("B");
			if (85 <= sj) {
				System.out.println("+");
			}
			if (85 > sj) {
				System.out.println("-");
			}
		} else if (70 <= sj) {
			System.out.print("C");
			if (75 <= sj) {
				System.out.println("+");
			}
			if (75 > sj) {
				System.out.println("-");
			}
		} else if (60 <= sj) {
			System.out.print("D");
			if (65 <= sj) {
				System.out.println("+");
			}
			if (65 > sj) {
				System.out.println("-");
			}
		} else {
			System.out.println("나가");
		}

	}

	public static void exSwitch() {
		/*
		 * switch - case -조건의 경우가 많을때는 if문 보다는 switch문을 사용하는 것이 더 간결하고 알아보기 쉽다.
		 * -조건의 결과값으로 int형 범위의 정수값을 허용한다. -구조 switch(조건식) { case 값 1: 조건식과 값1이
		 * 동일할 때 수향될 문장 break; default: 조건식을 만족하는 case값이 존재하지 않을 때 수행될 문장 }
		 */

		int a2 = (int) (Math.random() * 6);

		switch (a2) {
		case 0:
			System.out.println("35평 아파트 내놔");
			break;
		case 1:
			System.out.println("24평 아파트에 당첨되었습니다");
			break;
		case 2:
			System.out.println("싼타페에 당첨되었습니다");
			break;
		case 3:
			System.out.println("노트북에 당첨되었습니다");
			break;
		case 4:
			System.out.println("기계식 키보드에 당첨되었습니다.");
			break;
		case 5:
			System.out.println("문상 5천원 당첨되엇습니다");
			break;

		default:
			System.out.println("a2가 123이 아닙니다");
			break;
		}
	}

	public static void hw() {
		int score = (int) (Math.random() * 100001);
		System.out.println(score);
		switch (score / 10000) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("나가");
			break;
		}
	}
	
	public static void exInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int intInput = sc.nextInt();
		System.out.println(intInput);
	}
}

public class ConditionalSentence_01 {
	public static void main(String[] args) {

		exCdn.hw();

	}

}
