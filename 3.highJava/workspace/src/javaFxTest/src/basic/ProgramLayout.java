package javaFxTest.src.basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// 자바코드를 이용한 화면 구성 예제

public class ProgramLayout extends Application {

	@Override
	public void start(Stage primaryStage) {
		// VBox ==> 컨트롤들을 세로로 나란히 배치하는 컨테이너(레이아웃객체)
		VBox root = new VBox();   
		root.setPrefWidth(650);  // VBox의 너비
		root.setPrefHeight(150); // VBox의 높이
		//root.setPrefSize(650, 150);  // VBox의 너비, 높이 동시 지정
		
		root.setAlignment(Pos.CENTER);  // 컨트롤들을 가운데 정렬
		root.setSpacing(20);  // 컨트롤들의 수직 간격
		root.setPadding(new Insets(10)); // 안쪽여백 (4군데 모두 같은 크기로 지정)
		//root.setPadding(new Insets(10, 10, 10, 10)); // 위,오른쪽,아래,왼쪽 순으로 지정
		
		Label label = new Label(); // Label객체 생성
		label.setText("안녕하세요. JavaFX입니다.");
		label.setFont(new Font(50)); // Font객체를 이용하여 글자 크기 설정
		
		Button button = new Button();  // 버튼 객체 생성
		button.setText("확인");
		
		// 버튼을 클릭했을 때 이벤트 처리
		button.setOnAction( new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// 클릭 이벤트가 발생했을 때 처리할 내용을 기술하는 영역
					//System.exit(0);
					Platform.exit();
				}
			}
		);
		
		
		
		// VBox에 컨트롤들을 추가한다.
		root.getChildren().add(label);  // 1개씩 추가
		root.getChildren().add(button);
		
		//root.getChildren().addAll(label,button); // 한꺼번에 여러개 추가하기
		
		// VBox를 루트컨테이너로 갖는 Scene객체 생성
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Program Layout 연습");  // 창 제목
		primaryStage.setScene(scene); // Stage에 Scene 추가하기
		primaryStage.show();  // 윈도우(Stage) 보이기
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}






