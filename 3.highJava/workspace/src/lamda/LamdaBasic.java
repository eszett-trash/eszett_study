package lamda;

public class LamdaBasic {
	/*
	 lambda : 익명함수
			>> 매개변수를 가진 코드블럭
			>> 이 코드블럭은 런타임시 익명구현객체로 생성된다
			>> 인터페이스명 변수명 = 람다식;
			
			ㄹ람다식을 사용할 수 있는 조건
				람다식으로 ㅕㄴ환할 수 잇는 인터페이스를 함수적이터페이스라고 한다.,
				함수적 인터페이스ㅡㄴ 추상메서드가 하나인 인터페이스를 ㅁㄹ핟나
				(@FunctionalInterface)
			
			
			(int a)->{syso(a);}
			1. 자료형 이름을 생략 할 수 있다,
			(a) ->{syso(a);}
			2.매개변수가 한개면 괄호생략()이 가능
			a->{syso(a);}
			3.처리할문장이 1개면 {}를 생략 할 수 있다.
			a->syso(a);
			4.매개변수가 하나도 없거나 2개 이상이면 괄호생략이 불가
			()->{} / (a,b)->{}
			5. 반환값은return 사용
			a->{return a;
			a->retrun a}
			실행무에 return문만 잇는경우 return과 {}를 생략 할 수 있다.
	 */
	
	public static void main(String[] args) {
		int a = 5;
		int b = 10;

		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("람다 ㄴ");
			}
		});

		Thread th2 = new Thread(() -> {
			System.out.println("람다");
		});
		th1.start();
		th2.start();
	}
}
