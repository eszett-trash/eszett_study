package basic_171124;

import java.util.Scanner;
import java.util.Vector;

public class ProductTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		Buyer b = new Buyer(1000, name);
		Customer cus = new Customer();
		cus.addCustomer(b);
		
		System.out.println(cus.toString());
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
	String name;

	int fullPrice = 0;
	int nokorikane = 0;
	int nokoriPoint = 0;
	Vector<Product> item = new Vector<Product>();

	Buyer() {

	}

	Buyer(int money, String name) {
		this.money = money;
		this.name = name;
		Customer cs;
	}

	// 매개변수마다 다 다른 클래스를 넣어줘야 하지만 이렇게 하면 Product클래스만으로 전부 관리 할 수 있다.
	// 오버로드의 필요성도 줄어듦
	void buy(Product p) {

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

		System.out.println("계산 : 1 수정 : 2");
		Scanner s = new Scanner(System.in);

		while (true) {
			switch (s.nextInt()) {
			case 1:
				System.out.println("감사합니다~^^");
				System.exit(0);
				break;
			case 2:
				refund();
			default:
			}
		}

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
				summary();
			} else {
				System.out.println("다시 입력 해 주 세요");
			}
		}
		s.close();

	}
}

class Customer {
	private Vector<Buyer> b = new Vector<Buyer>();
	int customerNum;
	// 고객 추가

	void addCustomer(Buyer buyer) {
		boolean flag = false;
		customerNum = b.size();

		for (int i = 0; i < b.size(); i++) {
			if (buyer.name == b.get(i).name) {
				flag = true; // 기존고객이면 true반환
				customerNum = i;
			}
		}

		b.add(customerNum, buyer);
	}

	// 고객 삭제 (매개변수로 이름을 받아서 해당 이름을 가진 사람을 삭제)

	void removeCustomer(Buyer buyer) {
		boolean flag = false;
		customerNum = 0;

		for (int i = 0; i < b.size(); i++) {
			if (buyer.name == b.get(i).name) {
				flag = true; // 기존고객이면 true반환
				customerNum = i;
			}
		}

		if (flag) {
			b.remove(customerNum);
		} else {
			System.out.println("존재하지 않는 고객입니다.");
		}
	}

	// 고객수정 (이름과 돈을 받아서 기존금액에서 금액 추가)
	void upDate(Buyer buyer, int money) {
		boolean flag = false;
		customerNum = 0;

		for (int i = 0; i < b.size(); i++) {
			if (buyer.name == b.get(i).name) {
				flag = true; // 기존고객이면 true반환
				customerNum = i;
			}
		}

		if (flag) {
			b.get(customerNum).money = money;
		} else {
			System.out.println("존재하지 않는 고객입니다.");
		}
		
	}

	@Override
	public String toString() {
		b.get(customerNum).summary();
		return "";
	}
	

}
