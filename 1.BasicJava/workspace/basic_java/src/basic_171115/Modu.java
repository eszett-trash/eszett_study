package basic_171115;

public class Modu {
	public static void main(String[] args) {
		DblDice ce = new DblDice();
		System.out.println(ce.trwdiec());
	}
}

class DblDice {
	// 실제 내가 이동 할 칸을 반환
	int trwdiec() {

		int dice1 = (int) (Math.random() * 6 + 1);
		int dice2 = (int) (Math.random() * 6 + 1);
		int move;

		System.out.println(dice1 + " " + dice2);

		if (dice1 == dice2) {
			move = dice1 + dice2 + trwdiec();
		} else {
			move = dice1 + dice2;
		}

		return move;
	}
}