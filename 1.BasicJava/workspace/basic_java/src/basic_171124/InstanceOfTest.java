package basic_171124;

public class InstanceOfTest {

	public static void main(String[] args) {
		FireCar fc = new FireCar();
		Car c = new Car();
		if(fc instanceof FireCar)
		{
			System.out.println("소방차의 인스턴스이다.");
			FireCar fc2 = fc;
		}
		if(fc instanceof Car)
		{
			System.out.println("차의 인스턴스이다.");
			Car c2 = fc;
		}
		if(fc instanceof Object);
		{
			System.out.println("Object의 인스턴스이다.");
			Object obj = fc;
		}
		if(c instanceof FireCar)
		{
			System.out.println("Car는 FireCar의 인스터스이다");
			FireCar fc3 =(FireCar)c;
		}
	}
}

class Car
{
	
}
class FireCar extends Car
{
	
}