package basic_171113;

public class TvTest {
	public static void main(String[] args) {
//		Tv.color = "yellow";
//		System.out.println(Tv.color);
		
		Tv.changeColor();
		System.out.println(Tv.color);
		
		Tv t = new Tv();
		
		t.channel = 50;
		System.out.println(t.channel);
		System.out.println(t.power);
		

		System.out.println(t.channel);
	}
}

class Tv
{
///전역변수
	//앞에 static이 붙으면 class 변수
	static String color;
	//앞에 일반적인 자료형이 붙으면 instance 변수
	boolean power;
	int channel;
	
// class method
	static void changeColor()
	{
		color = "red";
	}
// instance method
	void power()
	{
		power =!power;
	}
	void channelUp()
	{
		channel++;
	}
	void channelDown()
	{
		channel--;
	}
}
