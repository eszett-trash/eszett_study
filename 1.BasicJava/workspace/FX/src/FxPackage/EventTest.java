package FxPackage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventTest extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10));

		HBox hbox = new HBox(15);
		hbox.setPadding(new Insets(10));

		Button btn1 = new Button("1");
		Button btn2 = new Button("2");
		Button btn3 = new Button("3");
		Button btn4 = new Button("4");

		TextArea ta = new TextArea();
		// -------------------------------------------------------
		// Event 설정하기

		// 이벤트 처리방법 1
		// 형식 ) 객체변수.setOn이벤트명() 메서드에 EventHandler 인터페이스를 익명함수형식으로 구현한다.
		// 이 인터페이스에는 handle()메서드가 이쓴데 이 메서드에 처리할 내용을 기술한다.

		// btn1.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent event) {
		// //ta.setText("구웨에에에에에에엑");
		// ta.appendText("첫번째 버튼입니다 \n");
		// }
		// });

		btn1.setOnAction(event -> {
			ta.appendText("람다식을 사용한 첫번째 버튼입니다.\n");
		});

		// 이벤트 처리방법 2
		// 객체변수.addEventHandler()메서드 이용하기
		// 이 메서드의 첫번째매개변수로 '이벤트 종류'를 지정하고
		// 두번째 매개변수에는 Event Handler 인터페이스를 궇ㄴ한 객체를 지정한다.

		// btn2.addEventHandler(ActionEvent.ACTION, new
		// EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent event) {
		// ta.appendText("두번째 버튼의 이벤트입니다.");
		// }
		// });

		btn2.addEventHandler(ActionEvent.ACTION, event -> {
			ta.appendText("람다식을 사용한 두번째 버튼입니다\n");
		});

		// 이벤트 처리바업 3-1
		// inner 클래스로 EventHandler를 구현한 클래스를 작성한다.

		class InnerEventHandler implements EventHandler<ActionEvent> {

			@Override
			public void handle(ActionEvent event) {
				ta.appendText("이너클래스를 사용한 세번째 버튼입니다.\n");
			}
		}

		// 이베트 처리방법 3-2

		// setOn이벤트명()메서드나 addevenHandler()메서드의 매개변수로 EventHandler이터페이스를 구현한 객체의
		// 인스턴스를 지정한다,
		// 1번 :
		// btn3.setOnAction(new InnerEventHandler());
		// 2번:
		btn3.addEventHandler(ActionEvent.ACTION, new InnerEventHandler());

		
		btn4.addEventHandler(ActionEvent.ACTION, new OuterEventHandler(ta));
		// ------------------------------------------------------------//

		hbox.getChildren().addAll(btn1, btn2, btn3, btn4);
		root.getChildren().addAll(hbox, ta);

		Scene scene = new Scene(root, 500, 400);
		primaryStage.setTitle("연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

//이벤트 처리방법 4-1 외부클래스

class OuterEventHandler implements EventHandler<Event>{
	TextArea ta;
	public OuterEventHandler(TextArea txt) {
		ta = txt;
	}
	@Override
	public void handle(Event event) {
		ta.appendText("외부 클래슬를 사용한 네번째 버튼입니다\n");
	}
}