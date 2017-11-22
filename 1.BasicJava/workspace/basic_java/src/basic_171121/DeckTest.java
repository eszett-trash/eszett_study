package basic_171121;

import java.util.Arrays;

public class DeckTest {
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle2();
		System.out.println(deck.pick(0));
	}
}

class Card {
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;

	static final int SPADE = 1;
	static final int DIAMOND = 2;
	static final int HEART = 3;
	static final int CLOVER = 4;

	int kind;
	int number;

	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	Card() {
		this.kind = SPADE;
		this.number = 5;
	}
	
	@Override
	public String toString() {

		String kind = "";
		String number = "";

		switch (this.kind) {
		case 1:
			kind = "SPADE";
			break;
		case 2:
			kind = "DIAMOND";
			break;
		case 3:
			kind = "HEART";
			break;
		case 4:
			kind = "CLOVER";
			break;

		default:
			break;
		}

		switch (this.number) {
		case 1:
			number = "A";
			break;
		case 11:
			number = "J";
			break;
		case 12:
			number = "Q";
			break;
		case 13:
			number = "K";
			break;
		default:
			number += this.number;
			break;
		}

		return kind + number;
	}

}

class Deck {
	final int CARD_NUM = Card.KIND_MAX * Card.NUM_MAX;
	Card c[] = new Card[CARD_NUM];

	int select;

	public Deck() {
		// c의 카드를 1,1 ->4,13
		// 카드 52장을 만드세요
		int cnt = 0;
		for (int i = 1; i <= Card.KIND_MAX; i++) {
			for (int j = 1; j <= Card.NUM_MAX; j++) {
				c[cnt++] = new Card(i, j);
			}
		}
	}

	/* 매개변수 하나를 받아서 해당번째 카드를 한 장 반환하세요 */

	// pick 매개변수가 없고 랜덤한 번째에 있는 카드를 한 장 반환하세요/
	// 바로 위의 pick메서드를 활용
	Card pick(int select) {
		return c[select];
	}

	Card pick() {
		return pick((int) (Math.random() * CARD_NUM));
	}

	// shuffle(카드 섞기)(연수ㅡㅂ뮨재 5-5)
	void shuffle() {

		Card temp;

		for (int i = 0; i < c.length; i++) {
			int j = (int) (Math.random() * CARD_NUM);
			temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
	}

	void shuffle2() {
		Card temp;

		for (int i = 0; i < 1000; i++) {
			int temp1 = (int) (Math.random() * CARD_NUM);
			int temp2 = (int) (Math.random() * CARD_NUM);

			temp = c[temp1];
			c[temp1] = c[temp2];
			c[temp2] = temp;
		}
	}

	void pr() {
		System.out.println(Arrays.toString(c));
	}
}
