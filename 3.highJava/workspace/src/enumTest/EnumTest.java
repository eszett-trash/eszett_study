package enumTest;


//

enum City{서울,대전,대구,부산}
enum Season{
	봄("3월부터 5월까지"),
	여름("6월부터 8월까지"),
	가을("9월부터 11월까지"),
	겨울("12월부터 2월까지");
	
	private String span;
	
	//열거형의 생성자를 만든다
	//이 생성자는 묵시적으로 private로 접근이 제어 된다
	//생성자에서 하는 일은 열거값을 선언된 변수에 대입하는 일을 한다
	private Season(String months) {
		span = months;
	}
	//열거값이 저장된 변수값을 반환하는 메서드 정의
	public String getSpan() {
		return span;
	}
	
}
public class EnumTest {
/*
 열거형에서 사용하는 메서드들.
 name =>열거형 상수의 이름을 문자열로 반환한다.
 ordinal() --> 열거형 상수가 정의된 순서값을 반환한다(보통 0부터 시작)
 valueOf("열거형 상수명") --> 지정된 열거형에서 '열거형 상수명'과 일치하는 열거형 상수를 반환한다.
 열거형명.values()-->데이터들을 배열로 가져온다
 */
	public static void main(String[] args) {
		City city1 = City.valueOf("서울");
		System.out.println(city1.name());
		System.out.println(city1.ordinal());
		System.out.println();
		
		Season ss2 = Season.가을;
		System.out.println(ss2.name());
		System.out.println(ss2.ordinal());
		System.out.println(ss2.getSpan());
		System.out.println();
		
		Season[] ssArr = Season.values();
		for (Season season : ssArr) {
			System.out.println(season+ " -> "+season.getSpan());
		}
		System.out.println();
		
		for (City city : City.values()) {
			System.out.println(city+" -> "+city.ordinal());
		}
	}
}
