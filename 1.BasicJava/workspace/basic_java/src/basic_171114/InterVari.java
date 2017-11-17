//package basic_171114;
//
//class Data {
//	int x;
//}
//
//public class InterVari {
//	public static void main(String[] args) {
//		Data d1 = new Data();
//		
//		d1.x = 10;
//		System.out.println("before 기본형 : "+ d1.x);
//		
//		InterVari.change(d1.x);
//		System.out.println("after 기본형 : "+ d1.x);
//		
//		
//		Data d2 = new Data();
//		
//		d2.x = 10;
//		System.out.println("before 참조형 : "+ d2.x);
//		
//		change(d2);
//		System.out.println("after 참조형 : "+ d2.x);
//	}
//
//	static void change(int x) {
//		x = 1000;
//		System.out.println("change 기본  " + x);
//	}
//
//	static void change(Data d1) {
//		d1.x = 1000; //d1에 직접 접근해서 x의 값을 바꿈
//		System.out.println("change 참조형 : " + d1.x);
//	}
//}


package basic_171114;

class Data {
	Data() {
		// TODO Auto-generated constructor stub
		
	}
	int x;
}

public class InterVari {
	public static void main(String[] args) {
		Data d1 = new Data();
		
		d1.x = 10;
		System.out.println("before 기본형 : "+ d1.x);
		change(d1.x);
		System.out.println("after 기본형 : "+ d1.x);
		
		
		Data d2 = new Data();
		
		d2.x = 10;
		System.out.println("before 참조형 : "+ d2.x);
		change(d2);
		System.out.println("after 참조형 : "+ d2.x);
	}

	static void change(int temp) {
		temp = 1000;
		System.out.println("change 기본  " + temp);
	}

	static void change(Data a) {
		a.x = 1000; //d1에 직접 접근해서 x의 값을 바꿈
		System.out.println("change 참조형 : " + a.x);
	}
}
