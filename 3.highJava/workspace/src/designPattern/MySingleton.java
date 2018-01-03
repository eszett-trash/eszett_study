package designPattern;

public class MySingleton {
	// 객체를 한개만 만들어지게 하는 방법
	// 외부에서 new를 이용해 객체를 생성 할 수 없고
	// 내부에서 동일한 객체를 반환하는 클래스

	// singletomclass를 구성하는 방법
	// 1.생성자를 private으로 한다.
	// 2.자기자신 class의 참조변수를 갖는 멤버변수를 선언한다.
	// 3. 객체를 내부에서 생성

	static int temp = 0;
	private MySingleton() {}

//	private static MySingleton uniqueInstance;
//	public static MySingleton getInstance() {
//		if (uniqueInstance == null) {
//			uniqueInstance = new MySingleton();
//		}
//		return uniqueInstance;
//	}
	
	private static MySingleton uniqueInstance = new MySingleton();
	public static MySingleton getInstance(){
		return uniqueInstance;
	}
}
