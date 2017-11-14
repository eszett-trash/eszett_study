package basic_171026;

import java.util.Scanner;

/**
 * 
 * 
 * @author PC07
 * @since 2017.10.27
 */
public class OperationBasic {
	public static void main(String[] args) {
		/*
			 1. 연산자 기본
			 	-단항연산자: ++, --, +, -, ~, !, (casting)
			 	-이항연산자: 
			 				산술연산자 : + - * / % << >> >>> 
			 				비교연산자 : < > <= >= instaceof == !=
			 				논리연산자 : & | ^ && || 
			 							xor : 두 입력중 하나만이 배타적으로 참인 경우에 0, 아닌경우로는 1
			 	-삼항연산자:
			 				a ? true : false
			 				
 				-대입연산자:
 							= , op=
 							
 							
 							
			2. 연산자 우선순위
				- 산술 > 비교 > 논리 > 대입
				- 단항 > 이항 > 삼항
				- 단항연산자와 대입 연산자를 제외한 모든 연산의 진행방향은 왼쪽에서 오른쪽입니다.
			
			3. 증감연산자(++,--)
				-증가연산자(++) : 피연산자의 값을 1 증가시킨다.
				-감소연산자(--) : 피연산자의 값을 1 감소시킨다.
			*/
		
			//변수타입은 int형이고 변수명은i이고 초기값은 3입니다.
		
			int i =3;
			
			System.out.println(i);
			
			++i;
			System.out.println(i);
			
			i++;
			System.out.println(i);
			
			int j1 = 5;
			int j2 = 0;
			
			j2 = ++j1;
			// 타 연산 전에 먼저 값을 증가시킨다
			
			System.out.println("j1 : "+j1);
			System.out.println("j2 : "+j2);
			
			int k1 = 5;
			int k2 = 0;
			
			k2 = k1++;
			// 타 연산 후에 값을 증가시킨다.
			
			System.out.println("k1 :"+k1); // 6 
			System.out.println("k2 :"+k2); // 5
			
			int a = 10;
			int b = 7;
			int result = 7 + ++a + b++;
			System.out.println(result);
			
			
			int c = 15;
			int result2 = c++ + ++c; 
			System.out.println(result2); //32
			
			
		/*
			4. 비트 전환 연산자 (~)
			-정수형과 char형에만 사용 할 수 있다.
			-피연산자를 2진수로 표현했을 때 0을 1로 1을 영으로 바꾼다.
			
			5. 논리 부정 연산자 (!)
				-boolean형에만 사용 가능하다.
				-true인 경우에는 false, false->true
		 */
			
			boolean power = false;
			System.out.println(!power);
			
			
			/*
			6. 산술연산자
				-사칙연산자 (+ - * /)  나머지 연산자 (%), 쉬프트연산자 (<< >> >>>)
				 두개의 피연산자를 취하는 이항 연산자이다.
				-이항연산자는 피 연산자의 크기가 5바이트보다 작으면 4바이트 (int)로 변환 한 답음 연산을 수행한다.
			 
				1. 사칙연산자 (+ - * /)
					-int (4바이트)보다 크기가 작은 자료형은 int형으로 변환 후 연산을 한다.
					-두개의 피연산자중 자료형의 표현범위가 큰 쪽에 맞춰서 형변환 후 연산을 수행한다.
					-정수형간의 나눗셈에서는 0으로 나누는 것이 금지되어있다.
			 
			 	 */
			
				 byte a2 = 10;
				 byte b2 = 20;
				 int c2  = (byte)(a2 + b2);
				 
				 byte c3 = (byte)(a2*b2);
				 
				 System.out.println(c3);
			
			
			
			
			/* 
			 	2. 나머지연산자 (%)
			 		-왼쪽의 피연산자를 오른쪽의 피연산자로 나누고 난 나머지값을 돌려주는 연산이다.
			 		-불형을 제외하고 모든 기본형에 사용 가능하다.			 
			 
			 */
				 Scanner scanner = new Scanner(System.in);
				 
			
				 
				
				 
				 //10을 8로 나는 몫은 1이고 나머지는 2이다.
//				 System.out.println("몇을 몇으로 나눕니까?");
//				 int a4 = scanner.nextInt();
//				 System.out.println("을");
//				 int b4 = scanner.nextInt();
//				 System.out.println("으로");
//				 System.out.println("결과 : "+a4+"을/를 "+b4+"로 나눈 몫은 "+ a4/b4 +"이고 나머지는 " + a4%b4 +"이다.");
			
			
			/*
			 	 3.비트시프트 연산자 (<< >> >>>)
			 		-정수형 변수에만 사용 가능하다.
			 		-피연산자의 각자리(2진수)를 오른쪽 또느ㅜㄴ 왼쪽으로 이동한다.
			 		-곱셈과 나눗셈을 할 때 연산속도가 매우 빠르다.
			 		-https://msdn.microsoft.com/ko-kr/library/f96c63ed.aspx
			 		-엠에스디엔이나 읽어라 ㅅㅂ
			 		
			 		- << : x<<n -> x*2^n
			 		- >> : x>>n -> x/2^n
			 		
		 		4. 비교연산자
		 			-두개의 변수 또는 리터럴을 비교하는데 사용되는 연산자이다.
		 			-주로 조건문과 반복문에 사용되면 연산결과는 true, false
		 			-이항연산자이다
		 				:이항연산자는 자료형이 서로 다를 때 범위가 큰 쪽으로 형변환하여 타임을 일치시킨 후 비교한다.
		 				
		 				
				5. 대소비교연산자 (< > <= >=)
					-boolean형을 제외한 나머지 기본형에 사용할 수 있다.
					
				6. 등가비교연산자 ( == !=)
				
					-모든 자료형에 사용이 가능함.
					-기본형의 경우 변수에 저장된 값을 비교한다
					 참조형의 경우 변수에 저장된 주소를 비교한다.
					 
					  수식  | 연산결과
					  x > y   | x가 y보다 클때 1, 그외 0
					  x < y   | x가 y보다 클때 1, 그외 0
					 x >= y   | x가 y보다 크거나 같을 때  1, 그외 0
					 x <= y   | x가 y보다 작거나 같을 때 1, 그외 0
					 x == y   | x가 y보다 같을때 1, 그외 0
					 x != y   | x가 y보다 다를때 1, 그외 0
					 
					 
			 */
				 
				 	System.out.println(5 < 10);
				 	
				 	System.out.println(0.1 == 0.1f);
				 
				 
			/*
			7. 논리연산자 ( && ||)
				-피 연산자로 불형 또는 불형값을 결과로 하는 조건식을 허용한다.
				-조건문과 반복문의 결합에 사용한다. 
				-&&이 ||보다 우선순위가 높다
				 || : 피연산자의 어느 한쪽만 true면 true의 결과값을 가진다.
				 && : 피연산자중 양쪽 모두 true면 true의 결과값을 가진다.
			*/
				 	
				 	System.out.println(5<15 || 7>11);
			
			//변수하나에 저장된 값이 대문자인지 판단하는 연산자
				 	
				 	char c7 = '^';
				 	
				 	System.out.println("대문자입니까? : ");
				 	System.out.println('A' <= c7 && 'Z' >= c7);
				 	System.out.println("소문자입니까? : ");
				 	System.out.println('a'<= c7 && 'z' >= c7);
				 	System.out.println("숫자입니까? : ");
				 	System.out.println('0'<= c7 && '9' >= c7);
				 	System.out.println("영문자입니까? : ");
				 	System.out.println(('A'<= c7 && 'Z' >= c7)||('a'<= c7 && 'z' >= c7));
		
			
			/*
			8. 비트연산자 (& | ^)
				-이진 비트를 수향한다.
				-실수형을 제외한 모든 기본형에 사용 할 수 있다.
				| (OR연산자)  : 피연산자중 한 쪽의 값이 1이면 1이다.
				& (AND연산자) : 피연산자 양 쪽의 값이 1이면 1이다.
				^ (XOR연산자) : 피연산자의 값이 서로 다르면 1이다.			
			 
			 9. 삼항연산자
			 	-세개의 피연산자를 필요로 하기 때문에 삼항연산자로 이름지어졌다.
			 	-삼항연산자의 조건식에는 연산결과가 true또는 false인 식이 사용되어야 한다.
			 	
			 	(조건식) ? 참 : 거짓
			
			 10. 대입연산자 (=, op=)
			 	-변수에 값 또는 수식의 연산결과를 저장하는데 사용한다.
			 	-연산자중 가장 낮은 연산순위를 가진다.

			 */
			
			char cc8 = 'a';
			cc8 += 3;
			System.out.println(cc8);	
			
			
			/*
			 11. 반올림
			 	
			 */
			double r = 3.141592;
			System.out.println((int)(r*1000 + 0.5)/1000f);
			
			float temp = 58.58422f;
			System.out.println((int)(temp*100 + 0.5)/100f);
			
			//12. Math.random();
			int[] rotto = new int[6]; 
			int ii = 0;
			
			while(rotto[5]!=0)
			{
				int rt_tmp = (int)(Math.random()*45+1);
				//임시로 만든 값이 기존에 있는 배열에 있으면 입력하지 않고 i도 늘리지 않음
				//기존에 있는 배열에 없으면 입력하고 i도 늘림
				for(int tmp = ii ; tmp>=0 ; ii --){
					if(rotto[tmp]==rt_tmp)
					{
						
					}
				}
				
				ii++;
			}
			
			
			
			
			for(int jj = 0  ; jj < 6 ; jj ++)
			{

				System.out.println(rotto[ii]);
			}//for
			
			
			
	}
}




































