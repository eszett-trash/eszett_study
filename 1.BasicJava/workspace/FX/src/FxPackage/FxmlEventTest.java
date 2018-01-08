package FxPackage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlEventTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		//FXML문서를 가져와 화면에 뿌려주는 역할
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../FxmlEventTest.fxml"));
			primaryStage.setTitle("FXML을 이용한 이벤트 처리");
			primaryStage.setScene(new Scene(root, 300,200));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
