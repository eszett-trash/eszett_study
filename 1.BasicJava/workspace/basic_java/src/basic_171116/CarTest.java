package basic_171116;

public class CarTest {
	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = new Car("White", "Auto", 2);

	}
}

class Car {
	//호출 순서는 지역변수가 가장 우선, 전역변수가 가장 마지막.
	
	String color;
	String gearType;
	int door;

	Car() {
		//생성자 내부에서 다른 생성자를 호출하기 위해 사용
		//오버로드 된 다른 생성자를 호출햇다./
		//생성자의 가장 위에 있어야한다.
		this("black","Stick",4);

	}

	Car(String color, String gearType, int door) {
		//매개변수와 객체 자신이 가지고 있는 변수의 이름이 같은 경우 이를 구분하기 위해 자신의 변수에 this를 사용한다. 
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

}