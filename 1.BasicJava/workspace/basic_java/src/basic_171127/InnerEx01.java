package basic_171127;

public class InnerEx01 {
	public static void main(String[] args) {

	}

	//인스턴스 클래스
	class InstanceInner {
		int iv = 100;
//		static int cb = 200; //인스턴스 클래스에서는 안됨
		final static int CONST = 200;
	}
	//스태틱 클래스
	static class staticInner{
		int iv = 200;
		static int cb = 200;
	}
	
	void method()
	{
		@SuppressWarnings("unused")
		class LocalClass{
			int iv = 300;
//			static int cv = 800; //안됨
			final static int CONST = 200; // 상수는 됨
		}
	}
}
