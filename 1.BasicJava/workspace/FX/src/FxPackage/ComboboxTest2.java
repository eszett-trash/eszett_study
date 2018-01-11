package FxPackage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComboboxTest2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox vb = new VBox(10);

		ComboBox<Friend> combo = new ComboBox<Friend>();
		TextArea ta = new TextArea();
		Button btn = new Button("확인");

		ObservableList<Friend> list = FXCollections.observableArrayList(
				new Friend("aaa", "문재인", 60, "010-9477-4777", "대전시 동구"),
				new Friend("bbb", "이명박", 70, "010-9477-4777", "서울시 동구"),
				new Friend("ccc", "박근혜", 80, "010-9477-4777", "감빵 동구"),
				new Friend("ddd", "안철수", 30, "010-9477-4777", "대전시 동구"),
				new Friend("eee", "박범계", 50, "010-9477-4777", "거시기"),
				new Friend("fff", "노회찬", 90, "010-9477-4777", "대전시 동구"));
		combo.setItems(list);
		combo.setValue(list.get(0));

		// 콤보박스에서 데이터의 목록이 보여지는 부분의 내용을 변경한다
		// 즉 화면에 나타나는 셀의 내용을 변경하는 부분.
		combo.setCellFactory(new Callback<ListView<Friend>, ListCell<Friend>>() {

			@Override
			public ListCell<Friend> call(ListView<Friend> param) {
				// TODO Auto-generated method stub.
				return new ListCell<Friend>() {
					@Override
					protected void updateItem(Friend item, boolean empty) {
						super.updateItem(item, empty);
						setText(item==null?null:item.getName());
					}
				};
			}
		});
		
		//콤보박스에서 항목을 선택하면 선택된 애용이 나타나는 부분을
		//콤보박스의 버튼영역이라고 하는데 이부분의 내용도 변경 해 주어야 한다.
		
		combo.setButtonCell(new ListCell<Friend>(){
			@Override
			protected void updateItem(Friend item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty?null:item.getName());
			}
		});
		
		//----------------------------------------------------------------------------
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//콤보박스에서 선택된 값을 처리하는 방법1.
				//Friend fr= combo.getValue();
				//방법 2
				Friend fr = combo.getSelectionModel().getSelectedItem();
				if (fr!=null) {
					ta.setText(fr.getId() + "\n");
					ta.appendText(fr.getName() + "\n");
					ta.appendText(fr.getAge() + "\n");
					ta.appendText(fr.getTel() + "\n");
					ta.appendText(fr.getAddr() + "\n");
				}
			}
		});

		vb.getChildren().addAll(combo, btn, ta);

		primaryStage.setTitle("거시기");
		primaryStage.setScene(new Scene(vb));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

