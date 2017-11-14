package basic_171025;

public class Hello //메소드
{
	public static void main(String[] args) 
	{
		int var1 = 10;
		System.out.println(var1); // 10진수
		
		int var2 = 010;
		System.out.println(var2); // 8진수
		
		int var3 = 0x10;
		System.out.println(var3); // 16진수
		
		/**********************************/
		
		
		double var4 = 0.25;
		System.out.println(var4);
		
		double var5 = 2E5;
		System.out.println(var5);
		
			
		char var6 = 'A';
		System.out.println(var6);
	
		char var7 = '한';
		System.out.println(var7);
		
		
		//+는 산술연산이 아니라 문자열 결합
		
		System.out.println("\t"+"들여쓰기");
		System.out.println("대한"+"\n"+"민국");
		System.out.println("This"+"\""+"s Java");
		System.out.println("이것은"+"\""+"중요"+"\""+"합니다");
		
		char var8 = '\u0041';
		System.out.println(var8);
		
		String var9 = "이것은 변수가 아니라 클래스"; 
		System.out.println(var9);
		
	}
}
