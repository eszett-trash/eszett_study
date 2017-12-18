package hw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 Set을 이용하여 숫자야구 게임 프로그램 작성하기
 조건) 컴퓨터의 숫자는 난수를 이용하여 구한다.
 스트라이크는s볼은 b로 출력한다.

 실행예시 ) 컴퓨터 난수가 957일 경우
 숫자입력 ->3 5 6
 356 --->1S0B
 957 --> 3S0B

 2번만에 맞췃습니다.

 */
public class BaseBallTest {

	public static void main(String[] args) {
		BaseBallGame bs = new BaseBallGame();
		System.out.println("게임 시작!");
		bs.gameStart();
		
	}
}

class BaseBallGame {
	private ArrayList<Integer> ball;
	private int Strike;
	private int Ball;
	private int cnt = 0;

	private void createBall() {
		HashSet<Integer> baseball = new HashSet<Integer>();
		while (baseball.size() < 3) {
			baseball.add((int) (Math.random() * 9 + 1));
		}
		ArrayList<Integer> temp = new ArrayList<Integer>(baseball);
		ball = temp;
	}

	private void inputBall(int a, int b, int c) {
		Strike = 0;
		Ball = 0;
		if (ball.get(0).equals(a)) {Strike++;}
		if (ball.get(1).equals(b)) {Strike++;}
		if (ball.get(2).equals(c)) {Strike++;}
		if (ball.get(0).equals(b)||ball.get(0).equals(c)) {Ball++;}
		if (ball.get(1).equals(a)||ball.get(1).equals(c)) {Ball++;}
		if (ball.get(2).equals(a)||ball.get(2).equals(b)) {Ball++;}
	}

	public void gameStart(){
		createBall();
		Scanner s = new Scanner(System.in);
		while(true){
			cnt++;
			System.out.println("숫자를 입력 해 주세요 ( 3개) ");
			inputBall(s.nextInt(), s.nextInt(), s.nextInt());
			System.out.println("S : " + Strike +" B : " + Ball);
			if (Strike == 3) {
				System.out.println(cnt+"번 만에 맞췄습니다.");
				break;
			}
		}
	}
}