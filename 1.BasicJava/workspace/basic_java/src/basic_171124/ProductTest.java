package basic_171124;

import java.util.Scanner;
import java.util.Vector;

public class ProductTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
	}
}

class Product {
	int price;
	int bonusPoint;

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price * 0.03);
	}
}

class Tv extends Product {

	Tv() {
		super(200);
	}

	@Override
	public String toString() {
		return "Tv";
	}

}

class NoteBook extends Product {
	NoteBook() {
		super(150);
	}

	@Override
	public String toString() {
		return "NoteBook";
	}

}

class Styler extends Product {
	public Styler() {
		super(100);
	}

	@Override
	public String toString() {
		return "Styler";
	}

}

class Buyer {
	int money = 1000000;
	int bonusPoint;

	int fullPrice = 0;
	int nokorikane = 0;
	int nokoriPoint = 0;
	Vector<Product> item = new Vector<Product>();

	Buyer() {

	}

	Buyer(int money) {
		this.money = money;
	}

	// 매개변수마다 다 다른 클래스를 넣어줘야 하지만 이렇게 하면 Product클래스만으로 전부 관리 할 수 있다.
	// 오버로드의 필요성도 줄어듦
	void buy(Product p) {
		while(true)
		{
			Scanner s = new Scanner(System.in);
			int input = s.nextInt();
			
			if(input == 999)
			{
				break;
			}
			else
			{
				
			}
		}
		if (money < p.price) {
			System.out.println("나가");
		} else {
			item.add(p);
			System.out.println(p + "를 구입하셨습니다.");
		}

		
	}

	void summary() {

		// 1. 구매 물품 내역을 보여주어야함
		// 2. 구매 총 금액을 보여주어야 함
		// 3. 나의 남은 돈 보여주기
		// 4. 나의 보너스 포인트
		System.out.println("===============================");
		for (int i = 0; i < item.size(); i++) {
			System.out.println(i + " | " + item.get(i) + " "
					+ item.get(i).price);
			fullPrice += item.get(i).price;
		}
		nokorikane = (money - fullPrice);
		nokoriPoint = (int) (fullPrice * 0.03);
		System.out.println(". . . .  . . . . . . . . . . . .");
		System.out.println("총 금액 : " + fullPrice);
		System.out.println("남은 돈 : " + nokorikane);
		System.out.println("보너스 포인트 : " + nokoriPoint);
		System.out.println("===============================");
		


	}

	// 5. 반품 : refund()
	// 내가 산 물건만 할 것
	// 가격 포인트 물건 빼기
	void refund() {

		Scanner s = new Scanner(System.in);
		int input;
		while (true) {
			System.out.println("환불 할 물건의 번호를 입력 해 주세요.\n없으면 999입력");
			input = s.nextInt();
			if (input == 999) {
				summary();
				break;
			} else if (input < item.size()) {
				item.remove(input);
			} else {
				System.out.println("다시 입력 해 주 세요");
			}
		}
		s.close();

	}
}
