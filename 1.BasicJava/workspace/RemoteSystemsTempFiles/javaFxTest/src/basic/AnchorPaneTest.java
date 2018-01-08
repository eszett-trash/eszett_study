package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		AnchorPane root = new AnchorPane();
		root.setPadding(new Insets(10));
		
		Label lblId = new Label("아 이 디 : ");
		lblId.setLayoutX(62);  // X좌표
		lblId.setLayoutY(22);  // Y좌표
		
		Label lblPass = new Label("패스워드 : ");
		lblPass.setLayoutX(62);
		lblPass.setLayoutY(68);
		
		TextField txtId = new TextField();
		txtId.setLayoutX(132);
		txtId.setLayoutY(18);
		
		PasswordField txtPass = new PasswordField();
		txtPass.setLayoutX(132);
		txtPass.setLayoutY(64);
		
		Button btnLogin = new Button("로그인");
		btnLogin.setLayoutX(86);
		btnLogin.setLayoutY(106);
		
		Button btnCancel = new Button("취 소");
		btnCancel.setLayoutX(210);
		btnCancel.setLayoutY(106);
		
		root.getChildren().addAll(lblId, lblPass, 
				txtId, txtPass, btnLogin, btnCancel);
		
		Scene scene = new Scene(root, 400, 150);
		
		primaryStage.setTitle("AnchorPane 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}






