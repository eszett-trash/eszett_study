package FxPackage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListViewTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox vb = new VBox(10);

		ListView<String> list = new ListView<String>();

		// 리스트뷰에 나타날 데이터
		ObservableList<String> data = FXCollections.observableArrayList(
				"green", "blue", "black", "brown", "blueviolet", "pink",
				"chocolate");
		list.setItems(data);
		
		Label lb = new Label();
		lb.setFont(new Font(20));

		//리스트뷰에서 값이 선택되었을 때 처리하는 방법
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
					lb.setText(newValue);
					lb.setTextFill(Color.web(newValue));
			}
		});
		
		//리스트뷰의 원래 데이터는 그대로 유지하면서
		//화면에 보이는 내용을 변경하는 방법
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new ListCell<String>(){
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						Rectangle rec = new Rectangle(100, 20);
						//item -> 리스트뷰에 설정된 원래 데이터
						if (item!=null) {
							rec.setFill(Color.web(item));
							setGraphic(rec); //변경되는 값이 문자열이 아닐경우의 값변경
							//setText(value); //이건 문자열일경우
						}
					}
				};
			}
		});
		
		vb.getChildren().addAll(list,lb);
		
		primaryStage.setTitle("리스트 뷰");
		primaryStage.setScene(new Scene(vb));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
