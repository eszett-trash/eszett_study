package FxPackage;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class AlertTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 종류 : error infomation warning none CONFIRMATION
		//==============================================
		// alert info창 띄우기
		//==============================================
		// Alert alertInfo = new Alert(AlertType.INFORMATION);
		//
		// alertInfo.setTitle("INFO");
		// alertInfo.setHeaderText("Header Text");
		// alertInfo.setContentText("ALERT INFO창입니다");
		//
		// alertInfo.showAndWait();
		//==============================================
		// alert CONFIRMATION 창 띄우기
		//==============================================
		// Alert err = new Alert(AlertType.CONFIRMATION);
		//
		// err.setTitle("Err!");
		// err.setHeaderText("ERR!! HEAD");
		// err.setContentText("에러에러띠롤띠롤");
		//
		// ButtonType btn = err.showAndWait().get();
		//
		// if (btn == ButtonType.OK) {
		// System.out.println("OK");
		// } else if (btn == ButtonType.CANCEL) {
		// System.out.println("CANCLE");
		// } else {
		// System.out.println(".,./");
		// }
		//==============================================
		// 자바스크립트의 prompt창과 같은 기능
		//==============================================
		TextInputDialog pmpt = new TextInputDialog("기본값");
		pmpt.setTitle("Pmpt창");
		pmpt.setHeaderText("헤더");
		Optional<String> result = pmpt.showAndWait();
		String myresult = "";
		if (result.isPresent()) { // 값이 있으면
			myresult = result.get();
		}
		System.out.println(myresult);
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
