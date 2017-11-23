package basic_171123;

public class CastingTest {
	public static void main(String[] args) {
		FireCar fc = new FireCar();
		
		Car c = new FireCar(); // up-casting
		
		//FireCar fc2 = (FireCar)new Car(); //down-castion
		
		Car[] c2 = new Car[2];
		c2[0] = new FireCar();
		c2[1] = new FireCar();
		
		FireCar fc3 = (FireCar) c2[0];
		
		fc3.drive();
	}
}

class Car
{
	String color;
	int door;
	
	void drive()
	{
		System.out.println("달려~!");
	}

}

class FireCar extends Car{
	void water()
	{
		System.out.println("물뿌려~@");
	}
	
	@Override
	void drive() {
		System.out.println("소방차 달려");
	}
}
class Ambulance extends Car{
	void AED(){
		System.out.println("살아나라~@");
	}
}