package basic_171116;

public class ProductTest {
	public static void main(String[] args) {
		
		Init init = new Init();
		
		System.out.println(init.action2);

	}
}

class Init {
	static int action;
	int action2 = 10;

	Init() {
		action2 = 3;
		System.out.println("생성자를 middle");
	}

	Init(int action2) {
		this.action2 = action2;
		System.out.println("매개변수 생성자");
	}
	
	{//인스턴스 초기화 블럭
		action2= 44;
		System.out.println("인스턴스 초기화 블럭");
	}
	static { //클래스 초기화 불럭
		action = 2;
		System.out.println("클래스 초기화 블럭");
	}
}