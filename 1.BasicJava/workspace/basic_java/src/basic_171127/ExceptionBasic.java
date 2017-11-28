package basic_171127;

public class ExceptionBasic {
public static void main(String[] args) {
	/*
	 1.프로그램 오류
	  -프로그램이 실행 중 어떤 원인에 의해서 오작동을 하거나
	   비정상적으로 종료되는 경우
	   	-컴파일 에러 : 컴파일시에 발생하는 에러
	   	-런타임 에러 : 실행시에 발생하는 에러
	   	-프로그램 코드에 의해서 수습할 수 없는 것 : 오류
	   	 프로그램 코드에 의해서 수습할 수 있는 것 : 예외
	   	 
   	 2.RuntimeException클래스와 그 외 클래스
   	 	-모든 예외의 최고 조상은 Exception이다.
   	 	-RuntimeException클래스들은 주로 프로그래머의 실수에 의해 발생하는 예외
   	 		ex) indexOutBoundsException, NullPiontException
 		- Exception클래스들은 주로 외부의 영향으로 발생 할 수 있는 것들
 			ex) FilleNotFoundException, ClassNotFoundException
 			
	3. 예외처리 (try - catch)
		-프로그램 실행 시 발생할 수 있는 예외에 대비한 코드를 작성하는 것
		
		try{
			예외가 발생 할 수 있는 문장
		}catch(Exception e)
		{
			Exception발생시 처리할 문장 
		}
		
		- 발생한 예외의 종류와 일치하는 단 한개의 catch블럭만을 수행한다.
		
		
	4. 예외 발생시키기
		-연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만들면 된다
			Exception e = new Exception();
		-키워드 throw를 이용해서 예외를 발생시키면 된다.
			throw e;
			
			throw new Exception();
	
	5. throws Exception
		-메서드 예외 선언하기
			:메서드의 선언부에 키워드 throws를 사용해 메서드내에서 발생 할 수 있는 예외를 적어주기만 하면 된다.
	
	6. finally
		-try-catch블럭의 예외발생에 상관 없이 실행되어야 할 코드를 포함한다.
		try{
			예외가 발생 할 수 있는 문장들
		}catch(Exception e){
			예외처리를 위한 문장
		}finally{
			무조건 마지막에 수행
		}
		순서
			-try ->catch ->finally
			-try ->finally
		
	 */
}
}
