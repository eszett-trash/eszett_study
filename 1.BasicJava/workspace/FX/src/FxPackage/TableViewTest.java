package FxPackage;

import util.NumRegEx;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableViewTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		ObservableList<Friend> data = FXCollections.observableArrayList(
				new Friend("aaa", "문재인", 60, "010-9477-4777", "대전시 동구"),
				new Friend("bbb", "이명박", 70, "010-9477-4777", "서울시 동구"),
				new Friend("ccc", "박근혜", 80, "010-9477-4777", "감빵 동구"),
				new Friend("ddd", "안철수", 30, "010-9477-4777", "대전시 동구"),
				new Friend("eee", "박범계", 50, "010-9477-4777", "거시기"),
				new Friend("fff", "노회찬", 90, "010-9477-4777", "대전시 동구"));
		BorderPane rt = new BorderPane();
		TableView<Friend> table = new TableView<Friend>(data);
		// 또다른 데이터 입력방법
		// table.setItems(data);

		// 테이블 컬럼 객체를 생성하고 컬럼의 제목을 지정한다.
		TableColumn<Friend, String> idCol = new TableColumn<Friend, String>(
				"ID");

		// 해당 테이블컬럼자리에 출력될 데이터의 변수명을 지정한다
		idCol.setCellValueFactory(new PropertyValueFactory<Friend, String>("id"));

		TableColumn<Friend, String> nameCol = new TableColumn<Friend, String>(
				"이름");
		nameCol.setCellValueFactory(new PropertyValueFactory<Friend, String>(
				"name"));
		TableColumn<Friend, Integer> ageCol = new TableColumn<Friend, Integer>(
				"나이");
		ageCol.setCellValueFactory(new PropertyValueFactory<Friend, Integer>(
				"age"));
		TableColumn<Friend, String> telCol = new TableColumn<Friend, String>(
				"전화번호");
		telCol.setCellValueFactory(new PropertyValueFactory<Friend, String>(
				"tel"));
		TableColumn<Friend, String> addrCol = new TableColumn<Friend, String>(
				"주소");
		addrCol.setCellValueFactory(new PropertyValueFactory<Friend, String>(
				"addr"));

		// 생성된 테이블컬럼들을 테이블에 추가한다.
		table.getColumns().addAll(idCol, nameCol, ageCol, telCol, addrCol);

		GridPane grid = new GridPane();
		Text t_id = new Text("id");
		Text t_name = new Text("이름");
		Text t_age = new Text("나이");
		Text t_tel = new Text("전번");
		Text t_addr = new Text("주소");

		TextField tf_id = new TextField();
		TextField tf_name = new TextField();
		TextField tf_age = new TextField();
		TextField tf_tel = new TextField();
		TextField tf_addr = new TextField();

		grid.add(t_id, 1, 1);
		grid.add(t_name, 2, 1);
		grid.add(t_age, 3, 1);
		grid.add(t_tel, 4, 1);
		grid.add(t_addr, 5, 1);

		grid.add(tf_id, 1, 2);
		grid.add(tf_name, 2, 2);
		grid.add(tf_age, 3, 2);
		grid.add(tf_tel, 4, 2);
		grid.add(tf_addr, 5, 2);

		grid.setVgap(10);
		grid.setHgap(5);

		VBox vb = new VBox(5);
		Button btnAdd = new Button("추가");
		btnAdd.setOnAction(event -> {
			if (tf_id.getText().isEmpty()) {
				alert("입력오류", "아이디를 입력하세요");
			}
			if (tf_name.getText().isEmpty()) {
				alert("입력오류", "이름을 입력하세요");
			}
			if (!(tf_age.getText().isEmpty() || NumRegEx.isInteger(tf_age
					.getText()))) {
				alert("입력오류", "나이를 입력하세요");
			}
			if (tf_tel.getText().isEmpty()) {
				alert("입력오류", "전화번호 입력하세요");
			}
			if (tf_addr.getText().isEmpty()) {
				alert("입력오류", "주소를 입력하세요");
			}

			// 입력작업이 완료되었을 경우
			data.add(new Friend(tf_id.getText(), tf_name.getText(), Integer
					.valueOf(tf_age.getText()), tf_tel.getText(), tf_addr
					.getText()));
			info("추가성공", tf_id.getText() + "씨의 정보가 추가되었습니다.");
		});

		Button btnMod = new Button("수정");
		btnMod.setOnAction(event -> {
			if (table.getSelectionModel().isEmpty()) {
				alert("수정오류", "구웨에에엑");
			}
			data.set(
					table.getSelectionModel().getSelectedIndex(),
					new Friend(tf_id.getText(), tf_name.getText(), Integer
							.valueOf(tf_age.getText()), tf_tel.getText(),
							tf_addr.getText()));
		});
		Button btnDel = new Button("삭제");
		btnDel.setOnAction(event -> {
			if (table.getSelectionModel().isEmpty()) {
				alert("삭제오류", "삭제할 데이터를 선택한 후 사용하세요");
				return;
			}
			data.remove(table.getSelectionModel().getSelectedIndex());
			info("삭제완료", table.getSelectionModel().getSelectedItem().getName()
					+ "씨의 정보가 삭제되었습니다.");
		});
		Button btnOk = new Button("확인");
		Button btnCn = new Button("취소");

		table.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				Friend fr = table.getSelectionModel().getSelectedItem();
				if (fr != null) {
					tf_id.setText(fr.getId());
					tf_name.setText(fr.getName());
					tf_age.setText(String.valueOf(fr.getAge()));
					tf_tel.setText(fr.getTel());
					tf_addr.setText(fr.getAddr());
				}
			}
		});

		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(btnAdd, btnMod, btnDel, btnOk, btnCn);

		rt.setMaxSize(600, 400);
		rt.setCenter(table);
		rt.setBottom(grid);
		rt.setRight(vb);

		primaryStage.setTitle(" ");
		primaryStage.setScene(new Scene(rt));
		primaryStage.show();

	}

	private void alert(String hTx, String msg) {
		Alert err = new Alert(AlertType.ERROR);
		err.setTitle("오류셈");
		err.setHeaderText(hTx);
		err.setContentText(msg);
		err.showAndWait();
	}

	private void info(String hTx, String msg) {
		Alert err = new Alert(AlertType.INFORMATION);
		err.setTitle("설명이셈");
		err.setHeaderText(hTx);
		err.setContentText(msg);
		err.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
