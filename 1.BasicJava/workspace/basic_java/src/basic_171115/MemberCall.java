package basic_171115;

public class MemberCall {
	int iv = 10;
	
	static int cv = 20;
	static int cv2 = new MemberCall().iv; // 인스턴스 변수를 사용하기 위해서 이런식으로 호출
	
	static void staticMethod()
	{
		cv = 55;
		
		MemberCall mc = new MemberCall();
		
		mc.iv = 70;
	}
	
	void instanceMethod()
	{
		cv = 70; // 인스턴스 메소드가 만들어지는 시점에는 클래스 메소드가 이미 만들어져 있다.
		iv = 80;
	}
}
