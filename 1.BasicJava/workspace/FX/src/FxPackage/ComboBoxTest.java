package FxPackage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane rt = new BorderPane();
		HBox hb = new HBox();
		TextArea ta = new TextArea();

		// 콤보박스 만드는 방법 1
		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("한강", "영산강", "금강", "낙동강");
		combo.setValue("한강");

		// 콤보박스 만드는 방법 2
		ObservableList<String> dataList = FXCollections.observableArrayList(
				"사과", "딸기", "배", "복숭아", "포도");
		ComboBox<String> combo2 = new ComboBox<String>(dataList);
		combo2.setValue("사과");
		// 데이터 추가하기
		combo2.getItems().addAll("대추", "귤");

		// 콤보박스에서 값이 변경될 때의 처리, 즉 change이벤트 처리
		combo.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				ta.appendText(newValue+" ");
			}
		});

		Button btn = new Button("확인");

		btn.setOnAction(event->{
			if (combo2.getValue()!=null) {
					ta.appendText(combo2.getValue()+" ");
			}
		});
		
		
		hb.setSpacing(10);
		hb.getChildren().addAll(combo, combo2, btn);

		rt.setTop(hb);
		rt.setCenter(ta);

		primaryStage.setTitle("콤보박스 테스트");
		primaryStage.setScene(new Scene(rt, 500, 400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
