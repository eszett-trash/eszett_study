package basic_171128;

public class JavaLangBasic {
	String a;
/*
  		1.java.lang패키지
  			-java.lang패키지는 자바프로그래밍에서 기본이 되는 클래스들을 포함하고 있다.
  				ex)String System...
  				
		2.Object class
			-멤버변수 없이 11개의 메서드로 되어있다.
			-equals(Object obj)
				:매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려준다.
				:참조변수에 저장된 주소값이 같은지를 판단 할 수 밖에 없다.
				:주소값이 아닌 멤버변수의 값을 비교하기 위해서는 equals메서드를 오버라이드 하면 된다
					equals메서드가 오버라이드 되어있는 클래스들
						ex)String, Date,File, wrapper클래스
  			-hashcode() - 10진수로 구성되어있다.
  				-객체의 주소값을 이용해서 해시코드를 만들어 반환한다.
  					:String클래스는 문자열의 내용이 같으면 동일한 해시코드를 반환한다.
  					 hashCode()가 오버라이드 되어있다.
			-toString()
				:인스턴스에 대한 정보를 문자열로 제공할 목적으로 작성
				:기본 toStrign()
					return getClass().getName()+"@"+Integer.toHexString(hashCode());
			-clone()
				:얕은 복사
				:자신을 복제하여 새로운 인스턴스를 생성한다.
				 단순히 인스턴스의 값만을 복사한다.
				 객체가 참조하고 있는 객체까지는 복사하지 않는다
				 clone()를 이용한복사는 같은 객체를 공유하므로 완전한 복제라고 보기 힘들다.
		 
	 		-getClass()
	 			:자신이 속한 클래스의 Class객체를 반환하는 메서드
	 			:class에서 객체를 얻는 방법
	 			 클래스 내의 정보가 필요할 때 먼저 class객체에 대한 정보를 얻어와야 한다
	 			 	1) Class obj = new Card().getClass() : 생성된 객체로부터 얻는 방법
	 			 	2) Class obj = Card.class; 			 : 클래스의 리터럴로부터 얻는 방법
	 			 	3) Class obj = Class.forName("Card");: 클래스중에 매개변수의 이름으로부터 얻는 방법
	 			 	
	 	3. String class
	 		-다른 언어에서는 문자열을 char형 배열로 다루었으나 자바에서는 문자열을 위한 클래스가 존재한다.
	 		 :문자열을 합치게 될 때 새로운 문자열을 가진 String 인스턴스가 생성된다.
	 		 
	 		 :문자열의 결합에서는 String을 사용하지 않고 StringBuffer(동기화 ㅇㅋ)또는 StringBuilder(동기화 ㄴ) 사용
	 		 
 		    -문자열의 비교
	 			 	-String 클래스의 경우에는 equals를 조금 특이하게 쓴다.
			 		 	- equals : 값의 비교를 하게 됨
			 		 	- == : 주소의 비교를 하게 된다
			 		-문자열 리터럴을 지정하는 방법과 String클래스의 생성자를 사용해서 만드는 방법이 있다.
			 		-문자열 리터럴은 클래스가 메모리에 로드될 때 자동적으로 미리 생성된다.
			 		
	 		-클래스의 생성자와 메서드
	 			//oracle에서도 사용하는 것들
	 			 1. String concat(String str); : 문자열을 뒤에 덧붙인다.
	 			 2. boolean contains() : 지정된 문자열을 포함하고 있는지 확인한다.
	 			 
	 			 //확장자 처리에 유용한것.
	 			 1. boolean endsWith() : 지정된 문자열로 끝나는지 검사
	 			 
	 			 //그 외
	 			 1. int lastIndexOf()  : 오른쪽 끝에서부터 문자 코드 또는 문자열을 찾아서 해당 위치를 반환
	 			 						 못찾으면 -1을 리턴
 */
}
