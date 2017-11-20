package basic_17120;

public class ChildTest {
	public static void main(String[] args) {
		
		Child cd = new Child();
		
		cd.volume = 15;
		cd.volumeUp();
		System.out.println(cd.volume);

		
		cd.channel = 20;
		cd.channelUp();
		System.out.println(cd.channel);
	}
}

class Parent {
	int channel;
	int volume;
	void channelUp() {
		channel++;
	}
}

class Child extends Parent {
	
	Child()
	{
		super();//이것이 생략되어잇다. 때문에 Parent가 불러와진다.
				//기본값이 super();이며 this()를 불러오면 super()은되지않는다.
	}
	
	int volume;

	
	void volumeUp() {
		volume++;
		this.volume = 0; //전역변수인 볼륨
		super.volume = 0; //상속받은 볼륨
	}
}