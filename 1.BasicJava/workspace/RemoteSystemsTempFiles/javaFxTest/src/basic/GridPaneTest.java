package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setPrefSize(300, 200);
		grid.setPadding(new Insets(10));
		grid.setHgap(10); // 수평방향의 셀사이 간격
		grid.setVgap(20); // 수직방향의 셀사이 간격
		
		Label lblId = new Label("아 이 디 : ");
		Label lblPass = new Label("패스워드 : ");
		
		TextField txtId = new TextField();
		txtId.setStyle("-fx-background-color:green; -fx-text-fill:red; ");
		
		PasswordField txtPass = new PasswordField();
		
		Button btnLogin = new Button("로그인");
		Button btnCancel = new Button("취 소");
		
		// GridPane에 컨트롤 추가하는 방법
		// 형식) grid.add(추가할컨트롤객체, 칸번호, 행번호, colspan, rowspan)
		grid.add(lblId, 1, 1, 2, 1);
		grid.add(lblPass, 1, 2, 2, 1);
		grid.add(txtId, 3, 1, 3, 1);
		grid.add(txtPass, 3, 2, 3, 1);
		
		grid.add(btnLogin, 3, 4);
		grid.add(btnCancel, 5, 4);
		grid.setStyle("-fx-background-color:yellow;");
		
		Scene scene = new Scene(grid);
		primaryStage.setTitle("GridPane 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}






