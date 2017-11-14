package basic_171114;

public class JVMTest {
	
	static int a = 0;
	int b = 0;
	public static void main(String[] args) {
		System.out.println("main start");
		JVMTest temp = new JVMTest();
		
		temp.firstMethod();
		
		System.out.println("main end");
	}
	
	void firstMethod()
	{
		a = 0;
		this.b = 10;
		
		System.out.println("\tfirst start");
		secondMethod();
		System.out.println("\tfirst end");
	}
	
	void secondMethod()
	{
		System.out.println("\t\tsecond start");
		System.out.println("\t\tsecond end");
	}
}
