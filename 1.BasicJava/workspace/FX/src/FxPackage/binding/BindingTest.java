package FxPackage.binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindingTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		/*
		 * 바인딩 : 한쪽의 내용이 변경되면 이와 연결된 다른쪽의 내용도 함께 변경되는 것 바인딩 처리를 하는 명령 :
		 * bindingBidirectional() / bind()
		 * 
		 * bindingBidirectional() : 양방향 bind() : 단방향
		 * 
		 * 명령 처리는 값이 변할 때 영향을 받는 쪽에서 명령을 처리한다.
		 */
		TextArea ta1 = new TextArea();
		TextArea ta2 = new TextArea();

		VBox rt = new VBox(10);
		rt.setPadding(new Insets(10));

		Label lb1 = new Label("첫번째");
		Label lb2 = new Label("두번째");

		// 단방향 처리
		// ta2.textProperty().bind(ta1.textProperty());
		
		//양방향처리1
		//ta2.textProperty().bindBidirectional(ta1.textProperty());
		//양방향처리2
		Bindings.bindBidirectional(ta1.textProperty(), ta2.textProperty());
		
		rt.getChildren().addAll(lb1, ta1, lb2, ta2);

		primaryStage.setTitle("바인틷 테스트");
		primaryStage.setScene(new Scene(rt, 300, 200));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
