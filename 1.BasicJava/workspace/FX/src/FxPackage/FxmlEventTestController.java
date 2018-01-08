package FxPackage;

import java.net.URL;
import java.util.ResourceBundle;

import util.NumRegEx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FxmlEventTestController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtField;

	@FXML
	private Button btn;

	@FXML
	private TextArea txtArea;

	@FXML
	void btnClick(ActionEvent event) {
		// String str = txtField.getText();
		// if (!str.isEmpty()) {
		// txtArea.appendText(str+"\n");
		// txtField.clear(); //필드 비우기
		// txtField.requestFocus();//포커스 주기
		// }

		// text필드에 출력할 단을 입력 했을 때 구구단을출력하시오

		int temp = 0;
		try {
			temp = new Integer(txtField.getText());
			txtArea.clear();
			for (int i = 1; i <= 9; i++) {
				txtArea.appendText(temp + "*" + i + "=" + temp * i + "\n");
			}
		} catch (Exception e) {
			txtArea.clear();
			txtArea.setText("숫자만 입력 해 주세요");
		}
	}

	@FXML
	void initialize() {
		assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'FxmlEventTest.fxml'.";
		assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'FxmlEventTest.fxml'.";
		assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'FxmlEventTest.fxml'.";

	}
}
