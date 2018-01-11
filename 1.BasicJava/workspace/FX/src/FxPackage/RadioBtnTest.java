package FxPackage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioBtnTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		// 라디오버튼의 경우에는 묶음으로 처리되는 것이 중요하다.
		ToggleGroup grp = new ToggleGroup();

		ImageView icon = new ImageView();

		// 같은 그룹으로 처리 할 라디오버튼들은 같은 그룹으로 묶어준다.
		RadioButton rb1 = new RadioButton("Home");
		rb1.setToggleGroup(grp); // 그룹으로 묶기
		rb1.setUserData("Home"); // 선택했을 때의 값을 나타내기 위한 데이터 설정

		RadioButton rb2 = new RadioButton("Calendar");
		rb2.setToggleGroup(grp);
		rb2.setUserData("Calendar");

		RadioButton rb3 = new RadioButton("Contacts");
		rb3.setToggleGroup(grp);
		rb3.setUserData("Contacts");

		RadioButton rb4 = new RadioButton("temp");
		rb4.setToggleGroup(grp);
		rb4.setUserData("temp");
		
		//그룹 내에서 라디오버튼중 하나가 선택되었을 때 처리하기
		grp.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable,
					Toggle oldValue, Toggle newValue) {
				if (grp.getSelectedToggle().getUserData() != null) {
					String url = grp.getSelectedToggle().getUserData()
							.toString();
					Image img = null;
					if (!url.equals("temp")) {
						img = new Image(getClass().getResource(
								"images/" + url + ".jpg").toString());
					} else {
						img = new Image(getClass().getResourceAsStream(
								"images/" + url + ".gif"));
					}
					icon.setImage(img);
				}
			}
		});

		HBox hb = new HBox();
		VBox vb = new VBox();

		vb.getChildren().addAll(rb1, rb2, rb3,rb4);
		vb.setSpacing(10);
		hb.getChildren().addAll(vb, icon);
		hb.setSpacing(50);
		hb.setPadding(new Insets(10));

		primaryStage.setTitle("라디오 버튼 연습");
		primaryStage.setScene(new Scene(hb, 250, 150));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
