package beginnerPrj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoffeeMain {
	public static void main(String[] args) {
		//
		// PrintMain pm = new PrintMain();
		// pm.print();

		MenuControl mc = new MenuControl();
		mc.print();

	}
}

class Join {

	String name;
	String email;
	String pwd;

	void print() {
		// 널체크 해야함
		System.out.println("--------------------------------------");
		System.out.println("|                                    |");
		System.out.println("|              회원가입              |");
		System.out.println("|                                    |");
		System.out.println("--------------------------------------");

		Scanner s = new Scanner(System.in);
		System.out.println("사용 할 이름을 입력 해 주세요");
		name = s.next();
		System.out.println("사용 할 이메일을 입력 해 주세요");
		email = s.next();
		System.out.println("사용 할 비밀번호를 입력 해 주세요");
		pwd = s.next();

		System.out.println("--------------------------------------");
		System.out.println("|                                    |");
		System.out.println("|     환영합니다" + name + "님!       |");
		System.out.println("|가입하신 메일로 로그인 해 주세요.   |");
		System.out.println("|                                    |");
		System.out.println("--------------------------------------");

		LogIn li = new LogIn();
		li.print();
	}

	void save() {
		// 저장해야함
	}
}

class LogIn {

	void print() {
		// 장바구니가 비어있으면 주문메뉴가 뜨지 않음
		System.out.println("--------------------------------------");
		System.out.println("|                                    |");
		System.out.println("|  1.피자  2.사이드메뉴  3.세트메뉴  |");
		System.out.println("|                                    |");
		System.out.println("--------------------------------------");

		Scanner s = new Scanner(System.in);
		while (true) {
			switch (s.nextInt()) {
			case 1:
				System.out.println("1");
				break;
			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break;
			default:
				System.out.println("다시 입력 해 주세요.");
			}
		}

	}

}

/**
 * 
 * @author 조은솔 enum활용 예제 :
 *         http://woowabros.github.io/tools/2017/07/10/java-enum-uses.html
 */
class MenuControl {

	void print() {

	}
}

class MenuList {
	// 토핑 불러와서 토핑이 1속성인지 2속성인지 검사하고 ->
	// 1속성 M일경우 +200엔 L일경우 +300엔
	// 2속성 M일경우 +300엔 L일경우 +450엔

	// 도우의경우(M) 레귤러 빵 씬은 동일, 치즈롤->250엔+ 밀푀유->300엔 더블밀푀유->500엔
	// 도우의경우(L) 레귤러 빵 씬은 동일, 치즈롤->400엔+ 밀푀유->500엔 더블밀푀유->750엔

}


enum Pizza {
	quatroHappy("쿼트로 해피",1) ,
	DominoDeRux("도미노 디럭스",2), 
	American("아메리칸",3),
	Margerita("마르게리따",4), 
	Tropical("트로피칼",5), 
	Skiyaking("스키야킹",6);
	
    final private String name;
    final private int pizzaNum;
    
    private Pizza(String name, int pizzaNum) { //enum에서 생성자 같은 역할
        this.name = name;
        this.pizzaNum=pizzaNum;
    }
    
    public String getName() 	{return name;}
    public int getPizzaNum()	{return pizzaNum;}
}

enum Size {
	Ssize("스몰 사이즈"), 
	Msize("레귤러 사이즈"), 
	Lsize("라지 사이즈");
	
	final private String name;
	
	private Size(String name) {
		this.name = name;	
	}
	
	public String getName(){return name;}
}
class DefaultPizza {
	//enum공부

	enum Dough {
		Regular, Bread, Thin, CheeseRoll, MilleFeuille, DoubleMilleFeuille
	}

	String menuname;
	int price;

	int pick() {

		return 0;
	}
}

class PrintMain {

	PrintMain() {
		
	}

	void print() {
		System.out.println("--------------------------------------");
		System.out.println("|                                    |");
		System.out.println("|      초급 프로젝트 핏자 주문~!!!   |");
		System.out.println("|                                    |");
		System.out.println("--------------------------------------");
		System.out.println("|                                    |");
		System.out.println("|     1. 로그인      2. 회원가입     |");
		System.out.println("|                                    |");
		System.out.println("--------------------------------------");

		Scanner s = new Scanner(System.in);
		while (true) {
			switch (s.nextInt()) {
			case 1:
				LogIn li = new LogIn();
				li.print();
				System.out.println("1");
				break;
			case 2:
				System.out.println("2");

				Join join = new Join();
				join.print();
				break;
			default:
				System.out.println("다시 입력 해 주세요.");
			}
		}

	}
}