package exam;

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student() {
	}

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) (getTotal() / 3f * 10 + 0.5f) / 10f;
	}

	String info() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math
				+ "," + getTotal() + "," + getAverage();
	}
}

class MyPoint {
	int x;
	int y;

	MyPoint() {
	}

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	double getDistance(int a, int b) {
		return Math.sqrt((a - x) * (a - x) + (b - y) * (b - y));
	}

}

class Exercise6_20 {

	static int[] shuffle(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int a = (int) (Math.random() * arr.length);

			int temp = arr[a];
			arr[a] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

}

class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff() {
		isPowerOn = !isPowerOn;
	}

	void volumeUp() {
		// (2) volume의 값이 MAX_VOLUME보다 작을 때만 값을 1증가시킨다.
		if (volume < MAX_VOLUME) {
			volume++;
		}
	}

	void volumeDown() {
		// (3) volume의 값이 MIN_VOLUME보다 클 때만 값을 1감소시킨다.
		if (volume > MIN_VOLUME) {
			volume--;
		}
	}

	void channelUp() {
		// (4) channel의 값을 1증가시킨다.
		// 만일 channel이 MAX_CHANNEL이면, channel의 값을 MIN_CHANNEL로 바꾼다.
		channel++;
		if (channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		}
	}

	void channelDown() {
		// (5) channel의 값을 1감소시킨다.
		// 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL로 바꾼다.
		channel--;
		if (channel == MIN_CHANNEL) {
			channel = MAX_CHANNEL;
		}
	}
} // class MyTv

class Rect_06 {

	// boolean isNumber(String str)

	public static void q_01() {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();

		System.out.println(card1.toString());
		System.out.println(card2.toString());

	}

	public static void q_03() {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		System.out.println("이름:" + s.name);
		System.out.println("총점:" + s.getTotal());
		System.out.println("평균:" + s.getAverage());
	}

	public static void q_05() {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
		System.out.println(s.info());
	}

	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
	}

	public static void q_06() {
		System.out.println(getDistance(1, 1, 2, 2));
	}

	public static void q_07() {
		MyPoint p = new MyPoint(1, 1);
		System.out.println(p.getDistance(2, 2));
	}

	public static void q_08() {

		/*
		 * class PlayingCard { int kind; int num; static int width; static int
		 * height; PlayingCard(int k, int n) { kind = k; num = n; } public
		 * static void main(String args[]) { PlayingCard card = new
		 * PlayingCard(1,1); } } - 클래스변수(static변수) : width height - 인스턴스변수 :
		 * king num - 지역변수 : card
		 */

	}

	public static void q_09() {
		// class Marine {
		// int x = 0, y = 0; // Marine의 위치좌표(x,y)
		// static int hp = 60; // 현재 체력 이기때문에 접근 가능해야함
		// int weapon = 6; // 공격력
		// int armor = 0; // 방어력
		//
		// void weaponUp() {
		// weapon++;
		// }
		//
		// void armorUp() {
		// armor++;
		// }
		//
		// void move(int x, int y) {
		// this.x = x;
		// this.y = y;
		// }
		// }
	}

	public static void q_10() {
		// [6-10] 다음 중 생성자에 대한 설명으로 옳지 않은 것은? (모두 고르시오)
		// a. 모든 생성자의 이름은 클래스의 이름과 동일해야한다.
		// b. 생성자는 객체를 생성하기 위한 것이다.
		// c. 클래스에는 생성자가 반드시 하나 이상 있어야 한다.
		// d. 생성자가 없는 클래스는 컴파일러가 기본 생성자를 추가한다.
		// e. 생성자는 오버로딩 할 수 없다.
	}

	public static void q_11() {
		// [6-11] 다음 중 this에 대한 설명으로 맞지 않은 것은? (모두 고르시오)
		// a. 객체 자신을 가리키는 참조변수이다.
		// b. 클래스 내에서라면 어디서든 사용할 수 있다.
		// c. 지역변수와 인스턴스변수를 구별할 때 사용한다.
		// d. 클래스 메서드 내에서는 사용할 수 없다.
	}

	public static void q_12() {
		// [6-12] 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오)
		// a. 메서드의 이름이 같아야 한다.
		// b. 매개변수의 개수나 타입이 달라야 한다.
		// c. 리턴타입이 달라야 한다.
		// d. 매개변수의 이름이 달라야 한다.
	}

	public static void q_13() {
		// [6-13] 다음 중 아래의 add메서드를 올바르게 오버로딩 한 것은? (모두 고르시오)
		// long add(int a, int b) { return a+b;}

		// a. long add(int x, int y) { return x+y;}
		// b. long add(long a, long b) { return a+b;}
		// c. int add(byte a, byte b) { return a+b;}
		// d. int add(long a, int b) { return (int)(a+b);}
	}

	public static void q_14() {
		// [6-14] 다음 중 초기화에 대한 설명으로 옳지 않은 것은? (모두 고르시오)
		// a.멤버변수는 자동 초기화되므로 초기화하지 않고도 값을 참조할 수 있다.
		// b.지역변수는 사용하기 전에 반드시 초기화해야 한다.
		// c.초기화 블럭보다 생성자가 먼저 수행된다.
		// d.명시적 초기화를 제일 우선적으로 고려해야 한다.
		// e.클래스변수보다 인스턴스변수가 먼저 초기화된다.
	}

	public static void q_15() {
		// [6-15] 다음중 인스턴스변수의 초기화 순서가 올바른 것은?
		// a. 기본값-명시적초기화-초기화블럭-생성자
		// b. 기본값-명시적초기화-생성자-초기화블럭
		// c. 기본값-초기화블럭-명시적초기화-생성자
		// d. 기본값-초기화블럭-생성자-명시적초기화
	}

	public static void q_16() {
		// [6-16] 다음 중 지역변수에 대한 설명으로 옳지 않은 것은? (모두 고르시오)
		// a. 자동 초기화되므로 별도의 초기화가 필요없다.
		// b. 지역변수가 선언된 메서드가 종료되면 지역변수도 함께 소멸된다.
		// c. 매서드의 매개변수로 선언된 변수도 지역변수이다.
		// d. 클래스변수나 인스턴스변수보다 메모리 부담이 적다.
		// e. 힙(heap)영역에 생성되며 가비지 컬렉터에 의해 소멸된다.
	}

	public static void q_17() {
		// [6-17] 호출스택이 다음과 같은 상황일 때 옳지 않은 설명은? (모두 고르시오)
		//
		// println
		// method1
		// method2
		// main
		//
		// a. 제일 먼저 호출스택에 저장된 것은 main메서드이다.
		// b. println메서드를 제외한 나머지 메서드들은 모두 종료된 상태이다.
		// c. method2메서드를 호출한 것은 main메서드이다.
		// d. println메서드가 종료되면 method1메서드가 수행을 재개한다.
		// e. main-method2-method1-println의 순서로 호출되었다.
		// f. 현재 실행중인 메서드는 println 뿐이다.
	}

	public static void q_18() {
		// [6-18] 다음의 코드를 컴파일하면 에러가 발생한다. 컴파일 에러가 발생하는 라인과 그
		// 이유를 설명하시오.
		// class MemberCall {
		// int iv = 10;
		// static int cv = 20;
		// int iv2 = cv;
		// static int cv2 = iv; // 라인 A
		// static void staticMethod1() {
		// System.out.println(cv);
		// System.out.println(iv); // 라인 B
		// }
		// void instanceMethod1() {
		// System.out.println(cv);
		// System.out.println(iv); // 라인 C
		// }
		// static void staticMethod2() {
		// staticMethod1();
		// instanceMethod1(); // 라인 D
		// }
		// void instanceMethod2() {
		// staticMethod1(); // 라인 E
		// instanceMethod1();
		// }
		// }
	}

	public static void q_19() {
		// [6-19] 다음 코드의 실행 결과를 예측하여 적으시오.
		// class Exercise6_19
		// {
		// public static void change(String str) {
		// str += "456";
		// }
		// public static void main(String[] args)
		// {
		// String str = "ABC123";
		// System.out.println(str);
		// change(str);
		// System.out.println("After change:"+str);
		// }
		// }

		// 답 :
		// ABC123
		// ABC123456
	}

	public static void q_20() {

		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		int[] result = Exercise6_20.shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

	public static void q_21() {
		MyTv t = new MyTv();
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
		t.channelDown();
		t.volumeDown();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
	}

	static boolean isNumber(String str) {
		boolean temp = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '9' || str.charAt(i) <= '0') {
				temp = false;
			}
		}
		return temp;
	}

	public static void q_22() {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}

	static int max(int[] arr) {

		if (arr.length == 0 || arr == null) {
			return -999999;
		}
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > temp) {
				temp = arr[i];
			}
		}
		return temp;

	}

	public static void q_23() {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
	}

	static int abs(int value) {
		return value >= 0 ? value : -value;
	}

	public static void q_24() {
		int value = 5;
		System.out.println(value + "의 절대값:" + abs(value));
		value = -10;
		System.out.println(value + "의 절대값:" + abs(value));
	}
}

public class Exam_06 {
	public static void main(String[] args) {
		Rect_06.q_01();
		Rect_06.q_03();
		Rect_06.q_05();
		Rect_06.q_06();
		Rect_06.q_07();
		Rect_06.q_20();
		Rect_06.q_21();
		Rect_06.q_22();
		Rect_06.q_23();
		Rect_06.q_24();
	}
}
