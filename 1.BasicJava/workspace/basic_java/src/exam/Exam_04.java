package exam;

import java.util.Scanner;

class Rect_04 {
	// [4-1] 다음의 문장들을 조건식으로 표현하라.
	// 1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
	public static void q_01() {
		int x = 0;
		if (x > 10 && x < 20) {
			System.out.println("1번 : true");
		}

		// 2. char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식
		char ch = 'A';
		if (!(ch == ' ' && ch == '\t')) {
			System.out.println("2번 : true");
		}
		// 3. char형 변수 ch가 ‘x' 또는 ’X'일 때 true인 조건식
		if (ch == 'x' && ch == 'X') {
			System.out.println("3번 : true");
		}
		// 4. char형 변수 ch가 숫자(‘0’~‘9’)일 때 true인 조건식
		if (ch >= '0' && ch <= '9') {
			System.out.println("4번 : true");
		}
		// 5. char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
			System.out.println("5번 : true");
		}
		// 6. int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지 않을 때 true인
		// 조건식
		int tmp_06 = 400;
		if (tmp_06 % 400 == 0 || (tmp_06 % 4 == 0 && tmp_06 % 100 != 0)) {
			System.out.println("6번 : true");
		}
		// 7. boolean형 변수 powerOn가 false일 때 true인 조건식
		boolean powerOn = false;
		if (!powerOn) {
			System.out.println("7번 : true");
		}
		// 8. 문자열 참조변수 str이 “yes”일 때 true인 조건식
		String str = "yes";
		if (str.equals("yes")) {
			System.out.println("8번 : true");
		}
	}

	// [4-2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
	public static void q_02() {
		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			if (i % 2 != 0 && i % 3 != 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	// [4-3] 의 결과를 계산하시오.
	// 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)를 출력하시오
	public static void q_03() {
		int temp = 0;
		System.out.print("몇 까지의 합을 구하려 합니까?");
		Scanner inputNum = new Scanner(System.in);
		int ipt = inputNum.nextInt();
		inputNum.close();
		for (int i = 1; i <= ipt; i++) {
			if (i != 1) {
				System.out.print("(");
			}
			for (int j = 1; j <= i; j++) {
				temp += j;
				System.out.print(j);
				if (j != i) {
					System.out.print("+");
				}// if
			}// for j
			if (i != 1) {
				System.out.print(")");
			}// if
			if (i != ipt) {
				System.out.print("+");
			}// if
		}// for i
		System.out.println("\n답 : " + temp);
	}

	// [4-4] 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이
	// 100이상이 되는지 구하시오.

	public static void q_04() {
		int sum = 0;
		int cnt = 0;
		for (int i = 1; sum < 100; i++) {
			cnt++;
			if (i % 2 == 0) {
				sum += i;
			} else {
				sum -= i;
			}
		}
		System.out.println(cnt);
	}

	// [4-5] 다음의 for문을 while문으로 변경하시오.

	// [연습문제]/ch4/Exercise4_5.java
	// public class Exercise4_5 {
	// public static void main(String[] args) {
	// for(int i=0; i<=10; i++) {
	// for(int j=0; j<=i; j++)
	// System.out.print("*");
	// System.out.println();
	// }
	// } // end of main
	// } // end of class

	public static void q_05() {
		int i = 0;
		int j;
		while (i <= 10) {
			j = 0;
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
	}

	// [4-6] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프
	// 로그램을 작성하시오.
	public static void q_06() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (i + j == 6) {
					System.out.println("i : " + i + ", j :" + j
							+ "의 경우 합이 6이 됩니다");
				}
			}
		}
	}

	// [4-7] Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는
	// 코드를 완성하라. (1)에 알맞은 코드를 넣으시오.

	public static void q_07() {
		int value = (int) (Math.random() * 6 + 1);
		System.out.println("value:" + value);
	}

	// [4-8] 방정식 2x+4y=10의 모든 해를 구하시오. 단, x와 y는 정수이고 각각의 범위는
	// 0<=x<=10, 0<=y<=10 이다.
	public static void q_08() {
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (2 * i + 4 * j == 10) {
					System.out.println("x는 " + i + " y는 " + j);
				}
			}
		}
	}

	// [4-9] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코
	// 드를 완성하라. 만일 문자열이 "12345"라면, ‘1+2+3+4+5’의 결과인 15를 출력이 출력되
	// 어야 한다. (1)에 알맞은 코드를 넣으시오.
	// [Hint] String클래스의 charAt(int i)을 사용

	public static void q_09() {
		String str = "12345";
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += (int) (str.charAt(i)) - 48;
		}
		System.out.println("sum=" + sum);
	}

	// [4-10] int타입의 변수 num 이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를
	// 완성하라. 만일 변수 num의 값이 12345라면, ‘1+2+3+4+5’의 결과인 15를 출력하라. (1)
	// 에 알맞은 코드를 넣으시오.

	public static void q_10() {
		int num = 12345;
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
			System.out.println(num);
		}
		System.out.println("sum=" + sum);
	}

	// [4-11] 피보나치(Fibonnaci) 수열(數列)은 앞을 두 수를 더해서 다음 수를 만들어 나가
	// 는 수열이다. 예를 들어 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는
	// 1과 2를 더해서 3이 되어서 1,1,2,3,5,8,13,21,... 과 같은 식으로 진행된다. 1과 1부터
	// 시작하는 피보나치수열의 10번째 수는 무엇인지 계산하는 프로그램을 완성하시오.

	public static void q_11() {
		// Fibonnaci 수열의 시작의 첫 두 숫자를 1, 1로 한다.
		int num1 = 1;
		int num2 = 1;
		int num3 = 0; // 세번째 값
		System.out.print(num1 + "," + num2);
		for (int i = 0; i < 8; i++) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			System.out.print("," + num3);
		}
	} // end of main

	// [4-12] 구구단의 일부분을 다음과 같이 출력하시오.\
	// 구구단 똑같이 출력하기

	public static void q_12() {
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j <= 3; j++) {
				for (int k = 1; k <= 3; k++) {
					if (i + k != 10) {
						System.out.print(i + k + "*" + (j + k) + "=" + (i + k)
								* (j + k) + "\t\t");
					}
				}
				System.out.println();
			}
			if (i < 8) {
				i += 2;
			}
			System.out.println();
		}
	}

	// [4-13] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다. (1)에 알맞
	// 은 코드를 넣어서 프로그램을 완성하시오.
	public static void q_13() {
		String value = "12034";
		char ch = ' ';
		boolean isNumber = true;
		// 반복문과 charAt(int i)를 이용해서 문자열의 문자를
		// 하나씩 읽어서 검사한다.
		for (int i = 0; i < value.length(); i++) {
			ch = value.charAt(i);
			if (!(ch >= '0' && ch <= '9')) {
				isNumber = false;
			}
		}
		if (isNumber) {
			System.out.println(value + "는 숫자입니다.");
		} else {
			System.out.println(value + "는 숫자가 아닙니다.");
		}
	} // end of main
		// [4-14] 다음은 숫자맞추기 게임을 작성한 것이다. 1과 100사이의 값을 반복적으로 입력
		// 해서 컴퓨터가 생각한 값을 맞추면 게임이 끝난다. 사용자가 값을 입력하면, 컴퓨터는 자
		// 신이 생각한 값과 비교해서 결과를 알려준다. 사용자가 컴퓨터가 생각한 숫자를 맞추면
		// 게임이 끝나고 몇 번 만에 숫자를 맞췄는지 알려준다. (1)~(2)에 알맞은 코드를 넣어 프
		// 로그램을 완성하시오.
		// [연습문제]/ch4/Exercise4_14.java

	public static void q_14() {
		// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int) (Math.random() * 100 + 1);
		int input = 0; // 사용자입력을 저장할 공간
		int count = 0; // 시도횟수를 세기위한 변수
		// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
		Scanner s = new Scanner(System.in);
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 :");
			input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.

			if (input > 100 || input < 1) {
				System.out.println("입력범위 초과, 종료합니다.");
				break;
			} else if (input == answer) {
				System.out.println("맞췄습니다.\n시도 횟수는 " + count + "번입니다.");
				break;
			} else if (input > answer) {
				System.out.println("더 작은 수를 입력하세요.");
			} else if (input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			}

		} while (true); // 무한반복문
		s.close();
	} // end of main

	// [4-15] 다음은 회문수를 구하는 프로그램이다. 회문수(palindrome)란, 숫자를 거꾸로 읽
	// 어도 앞으로 읽는 것과 같은 수를 말한다. 예를 들면 ‘12321’이나 ‘13531’같은 수를 말한
	// 다. (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.

	// 어떤 문자열을 받아도 펠린드롭인지 확인하는 문제 (문자열제어)
	public static void q_15() {
		int number = 123221;
		int tmp = number;
		int result = 0; // 변수 number를 거꾸로 변환해서 담을 변수
		while (tmp != 0) {
			result = result * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		if (number == result)
			System.out.println(number + "는 회문수 입니다.");
		else
			System.out.println(number + "는 회문수가 아닙니다.");
	} // main

	public static void q_16() {

		// 입력
		Scanner inputString = new Scanner(System.in);
		String s = inputString.next(); // 입력받은 스트링
		inputString.close();

		// 변수선언
		char a_tmp[] = new char[s.length()];// 배열로 변경
		char c_tmp[] = new char[s.length()];// 거꾸로 저장

		boolean chk = true; // 펠린드롭 체크

		// 캐릭터 배열로 받아서 캐릭터 배열에 집어넣은 다음 뒤집어서 새로 저장 한 후 비교
		for (int i = 0; i < s.length(); i++) {
			a_tmp[i] = s.charAt(i);
		}// 배열로 변경

		for (int i = s.length() - 1; i >= 0; i--) {
			c_tmp[i] = s.charAt(s.length() - i - 1);
		}// 거꾸로 배열

		for (int i = 0; i < s.length(); i++) {

			if (a_tmp[i] != c_tmp[i]) {
				chk = false;
				break;
			}
		}

		// 출력체크

		if (chk) {
			System.out.println(s + "는 회문입니다");
		} else if (!chk) {
			System.out.println(s + "는 회문이 아닙니다.");
		} else {
			System.out.println("에러!");
		}

	}

	public static void q_17() // 별찍기
	{
		Scanner s = new Scanner(System.in);
		int ipt = s.nextInt();
		s.close();
		for (int i = 1; i < ipt; i++) {
			for (int j = ipt; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void q_18() {

		// 입력받음
		Scanner s = new Scanner(System.in);
		String ipt = s.next();
		s.close();

		// 머리꼬리 자를 것 선언
		char head = 0;
		char tail = 0;

		// 입력받은 스트링 길이는 1부터 시작하므로 배열에 사용하기 위해 1을 뺀 값을 strlen에 카피
		int strlen = ipt.length() - 1;

		// 회문인지 체크하는 함수. false가 되면 회문이 아니다.
		boolean pd_chk = true;

		if (strlen % 2 == 0) {
			// 문이 홀수인 경우
			for (int i = 0; i < strlen / 2; i++) {
				head = ipt.charAt(i);
				tail = ipt.charAt(strlen - i);
				if (head != tail) {
					pd_chk = false;
					break;
				}
			}

		} else if (strlen % 2 != 0) {
			// 문이 짝수인 경우
			for (int i = 0; i < (strlen + 1) / 2; i++) {
				head = ipt.charAt(i);
				tail = ipt.charAt(strlen - i);
				if (head != tail) {
					pd_chk = false;
					break;
				}
			}
		}

		if (pd_chk) {
			System.out.println("회문입니다");
		} else if (!pd_chk) {
			System.out.println("회문이 아닙니다.");
		}
	}
}

public class Exam_04 {
	public static void main(String[] args) {
		// Rect_04.q_01();
		// Rect_04.q_02();
		// Rect_04.q_03();
		// Rect_04.q_04();
		// Rect_04.q_05();
		// Rect_04.q_06();
		// Rect_04.q_07();
		// Rect_04.q_08();
		// Rect_04.q_09();
		// Rect_04.q_10();
		// Rect_04.q_11();
		// Rect_04.q_12();
		// Rect_04.q_13();
		// Rect_04.q_14();
		// Rect_04.q_15();
		// Rect_04.q_16();
		// Rect_04.q_17();
		Rect_04.q_18();
	}
}
