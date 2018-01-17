package FxPackage.mvc.member;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberMVCMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
//		Parent root = FXMLLoader.load(
//			getClass().getResource("MemberMVCMain.fxml")
//		); 
		
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("MemberMVCMain.fxml"));
		Parent root = loader.load();
		
		// FXML에 설정된 컨트롤러 객체 구하기
		MemberMVCController controller = loader.getController();
		
		// 컨트롤러에 부모창객체(primaryStage객체)를 셋팅한다.
		controller.setPrimaryStage(primaryStage);
		
	
		Scene scene = new Scene(root);
		primaryStage.setTitle("회원관리");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
