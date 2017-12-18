package hw;

import java.util.HashSet;
import java.util.Scanner;

/*
 * 로또 판매점 프로그램
 * 
 * 사용자로부터 금액과 게임수를 입력받아서 게임수에 맞는 로또번호를 생성하는 프로그램을 작성하시오
 * (단, 1게임의 가격은 1000원이다.)
 * 이 때 입력한 금액보다 게임수가 많으면 게임수를 다시 입력받고, 게임 후 거스름돈을 출력하도록 처리한다,.
 * */

public class LottoTest {

	private static HashSet<Integer> ltt() {
		HashSet<Integer> lt = new HashSet<Integer>();
		while (lt.size() < 6) {
			lt.add((int) (Math.random() * 45 + 1));
		}
		return lt;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("금액을 입력 해 주세요");
			int money = s.nextInt() / 1000;
			System.out.println("게임 수를 입력 해 주세요");
			int game = s.nextInt();
			if (money > game) {
				for (int i = 0; i < game; i++) {
					System.out.println(ltt());
				}
				System.out.println("거스름돈은 " + (money - game) * 1000);
				break;
			} else if (money < game) {
				System.out.println("금액이 부족합니다. 다시 입력 해 주세요.");
			} else {
				for (int i = 0; i < game; i++) {
					System.out.println(ltt());
				}
				break;
			}
		}
	}
}
