package basic_171113;

public class Ceasar {
	// public static void main(String[] args) {
	// System.out.println("card.width : " + Card.width);
	// System.out.println("card.width : " + Card.height);
	//
	// Card card = new Card();
	//
	// card.kind = "Heart";
	// card.number = 3;
	//
	// Card card2 = new Card();
	//
	// card2.kind = "Spade";
	// card2.number = 7;
	//
	// System.out.println();
	// System.out.println("card의 모양은"+card.kind+"이고 card의 숫자는"+card.number+"이다.");
	// System.out.println("card의 너비는"+card.width+"이고 card의 높이는"+card.height+"이다.");
	// System.out.println("car2d의 모양은"+card2.kind+"이고 card2의 숫자는"+card2.number+"이다.");
	// System.out.println("card2의 너비는"+card2.width+"이고 card2의 높이는"+card2.height+"이다.");
	//
	// card.width = 50;
	// card.height = 80;
	//
	// System.out.println();
	// System.out.println("card의 모양은"+card.kind+"이고 card의 숫자는"+card.number+"이다.");
	// System.out.println("card의 너비는"+card.width+"이고 card의 높이는"+card.height+"이다.");
	// System.out.println("car2d의 모양은"+card2.kind+"이고 card2의 숫자는"+card2.number+"이다.");
	// System.out.println("card2의 너비는"+card2.width+"이고 card2의 높이는"+card2.height+"이다.");
	// //width와 height는 static이기때문에 (클래스변수이기때문에) 바꾸면 바뀜
	// }

	String caesar(String s, int n) {
		String result = "";
		// 함수를 완성하세요.
		char temp = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				result = result + " ";
			} else {

				if (s.charAt(i) + (char)n >= 'z') {
					result += (char) (s.charAt(i) + n - 'a');
				} else {
					result += (char) (s.charAt(i) + n);

				}

			}
			System.out.println(result);
		}

		return result;
	}

	public static void main(String[] args) {
		Ceasar c = new Ceasar();
		System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 4));
	}

}

class Card {

	// 인스턴스변수
	String kind;
	int number;

	// 클래스변수
	static int width = 100;
	static int height = 250;

	// 인스턴스 메서드
	void method() {
		// 지역변수
		int v = 3;

	}

	// 클래스 메서드
	static void method2() {

	}

}