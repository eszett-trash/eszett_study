package basic_171123;

public class SingletonTest {
	public static void main(String[] args) {
	
		Singleton st = Singleton.getInstance(); //객체생성 없이 가져옴
	}
}


final class Singleton
{
	private static Singleton s = null;
	
	private Singleton(){}
	
	public static Singleton getInstance() {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}
}