package night_171025;

public class VariableBasic { // 클래스
	public static void main(String[] args) { // 메서드
/*		
		
		1. 변수란?
				-단 하나의 값을 저장 할 수 있는 공간이다.
				
		2. 변수의 선언
			[변수타입] [변수명]
		int num;
		3. 변수의 초기화
		num = 10;
		
		4. 명명규칙
			1. 대소문자가 구분되며 길이의 제한이 없다.
			2. 예약어는 사용 할 수 없다. 
			3. 숫자로 시작해서는 안된다.
			4. 특수문자 _ $만 사용 가능하다.
		
		*/
				
		
		int num = 10;
		
		int num2 = 100;
		
		int num3 = 0;
		int nUm3 = 10;
		
		int $harp = 100;
		
		//필수는 아니지만 자바 프로그래머들으 ㅣ암묵적인 약속들
		//1.클래스 명의 첫 글자는 항상 대문자이어야 한다.
		//	-변수와 메서드의 명은 첫글자가 소문자이어야 한다.
		//2.여러단어로 이루어진 경우에는 두번째 이상의 첫번째 단어는 대문자로 쓴다.
		//	-lastIndexOf
		//3. 상수의 명칭은 대문자로 써야한다.
		//	-MAX_VALUE = 100;
		
		/*
			변수의 타입
			1. 기본형 타입 primitive type
				-boolean char short int long float double
				
						-논리형 : true, false중 하나의 값을 갖으며, 조건식과 논리적 계산에 사용된다. (boolean)
						-문자형 : 문자를 저장하는데 사용한다. 단 한문자를 저장한다. 단 한 문자를 저장한다 (char)
						-정수형 : 정수값을 저장하는데 사용한다. (byte short int long)
						-실수형 : 실수값을 저장하는데 사용한다. (float double)
						
				-기본형 변수의 크기 (1byte = 8bit)
						-1byte : boolean byte
						-2byte : char short
						-4byte : int float
						-8byte : long double
						
						
							1byte	2byte	4byte	8byte
					논리형	boolean
					문자형			char
					정수형	byte	short 	int 	long
					실수형					float	double
					
					- 논리형 : boolean (기본값 false)
						-논리형에는 boolean 하나밖에 없음
						-boolean형 변수에는 true,false 중 하나의 값을 저장한다.
						-yes no, ON/OFF 논리 구현에 주로 사용된다.
						-데이터의 최소단위가 1byte임으로 1byte를 가지게 된다.
						
					- 문자형 : char
						-문자형에는 'char'한가지 밖에 없다.
						-자바는 유니코드 문자체계를 가지고있다. 2바이트
							'\u0041' = 65 = A
						
					- 정수형 : byte short int long
						-기본 자료형은 int
						-변수에 저장하려는 정수값의 범위에 따라 4가지 정수형중에 하나를 선택하면 된다
						-byte short의 경우 크기가 작아서 잘못된 결과를 얻기가 쉽워 int를 사용하는 것이 좋다.
						-JVM의 피연산자 스택이 피연산자를 4바이트 단위로 저장을 하기 때문에 4바이트보다
						 작은 자료형의 값을 게산시 4바이트로 변형하여 수향되기 때문에
						 int형을 사용하는 것이 좋다.
						-오버플로우(overflow)
						 변수 자신이 저장 할 수 있는 범위를 초과하였을 때 가장 작은 범위부터 다시 시작하는 현상
						 
					-실수형
						-실수형에는 float, double 두가지가 있다.
						-기본형은 double이다
						-float : 1+8+23
						-double : 1+11+52
						-실수형이 사용될자료형을 선택시 값의 범위뿐만이 아니라 정밀도도 중요한 요소가 된다
							f가 붙으면float로 인식 l이 붙으면 롱형으로 인식
							
							
							
					
											
			
			2. 참조형 타입 reference type
		 		-주소를 저장한다.
		 		-기본형 타입 8가지를 제외한 모든 타입 
		 		
		 		-String
						-문자열을 다루기 위한 클래스
						-""->문자열에 문자가 존재하지 않아도 된다.
						-참조형 변수는 기본값 NULL임;
						-
		 		
		 		
		 				 
		 	3. 형변환 (type casting)
		 		-변수 혹은 리터럴의 자료형을 다른 자료형으로 변환한다.
		 		- byte - > short -> int -> long ->float -> double 
		 		-			char ->										처럼 범위가 큰 자료형으로 바뀌는 경우에는 필요하지 않다.
		 */
			byte b3 = 127;
			short s3 = 200;
			byte b4 = (byte)s3;
			
			int i3 = 3245;
			
			
			String s = "abc";
			int i6 = 145;
			String result = s + i6;
			
			int result2 = 'A'+15;
			
			System.out.println(result);
			System.out.println(result2);
			
			
			
//		
//		int a = 65;
//		char b = (char)a; // 형변환
//		
//		char txt = 65;
//		
//		
//		System.out.println(b); // syso
//		System.out.println(' ');
//		System.out.println(txt);
//		
//		float f2 = 0.1f;
//		System.out.println(f2);
//		double d2 = 0.1;
//		System.out.println(d2);
//		
//		
//		String s = "";
//		s = "이것은 스트링입니다.";
//		
//		System.out.println(s);
//		
//		
		
		
	}
}

























