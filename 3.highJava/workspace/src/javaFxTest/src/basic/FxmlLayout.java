package javaFxTest.src.basic;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FxmlLayout extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// Fxml파일을 읽어와 현재 Stage에 적용하기
		
			// 방법1  ==> FXMLLoader의 전역 메서드 load()이용하기
			//Parent root = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml"));
			
			// 방법2  ==> FXMLLoader객체를 생성한 후 인스턴스 메서드 load()이용하기
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlLayout.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Fxml문서를 이용한 레이아웃");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
