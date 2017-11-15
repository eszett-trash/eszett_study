package basic_171115;

public class RecursiveCall {
	public static void main(String[] args) {
		
		RecursiveCall rc = new RecursiveCall();
		
		System.out.println(rc.factorial(67));
		
	}
	
	
	long factorial(int n)
	{
		return n==1?1L:n*factorial(n-1);
	}
}
