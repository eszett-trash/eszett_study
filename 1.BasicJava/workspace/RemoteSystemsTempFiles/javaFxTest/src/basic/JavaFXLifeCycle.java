package basic;

import javafx.application.Application;
import javafx.stage.Stage;

/*
	JavaFX에서 사용되는 용어
- Stage(무대) ==> window창을 나타내는 객체
- Scene(장면) ==> 무대에는 하나의 장면이 배치된다.
 				  (컨테이너를 포함하고, Stage에 배치되는 객체)
 				  
- FX에서 사용되는 메서드들과 처리 순서
  main() => 생성자 => init() => start() => 프로그램사용 => 종료 => stop()
  
  (생성자, init(), stop()은 생략가능)

- 프로그램이 종료되는 경우
  1. 마지막 Stage가 close될 때
  2. Platform.exit()메서드를 호출했을 때
  3. System.exit(0)메서드를 호출했을 때 ==> 이 때는 stop()메서드를 호출하지 않는다.
  

*/
public class JavaFXLifeCycle extends Application {

	public JavaFXLifeCycle() {
		// 2
		System.out.println(Thread.currentThread().getName() + "=> 생성자 메서드 호출");
	}
	
	@Override
	public void init() throws Exception {
		// 3
		System.out.println(Thread.currentThread().getName() + "=> init()메서드 호출");
	}
	
	@Override
	public void start(Stage primaryStage) {
		// 4
		System.out.println(Thread.currentThread().getName() + "=> start()메서드 호출");
		primaryStage.show();  // 윈도우창 보이기
	}

	@Override
	public void stop() throws Exception {
		// 5
		System.out.println(Thread.currentThread().getName() + "=> stop()메서드 호출");
	}
	
	public static void main(String[] args) {
		// 1
		System.out.println(Thread.currentThread().getName() + "=> main()메서드 시작");
		launch(args);
	}
}




