package FxPackage.mvc.member;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberMVCMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent rt = FXMLLoader.load(getClass().getResource("D:\\eszett_study\\1.BasicJava\\workspace\\FX\\src\\FxPackage\\mvc\\member\\MemberMVCMain.fxml"));
			primaryStage.setScene(new Scene(rt));
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
