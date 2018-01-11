package FxPackage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[] names = new String[] { "Security", "Project", "Chart" };
		Image[] image = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];
		CheckBox[] chkbx = new CheckBox[names.length];

		Rectangle rect = new Rectangle(90, 30);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		rect.setFill(Color.BLUE);

		// 이미지의 정보만 가져오는 객체
		for (int i = 0; i < names.length; i++) {
			
			final Image img = image[i] = new Image(getClass().getResourceAsStream(
					"images/" + names[i] + ".png"));
			final ImageView icon =  icons[i] = new ImageView();// 화면에 실제로 뿌리는 객체
			chkbx[i] = new CheckBox(names[i]);

			// 체크박스를 클릭해서 값이 변경되면 처리하기

			chkbx[i].selectedProperty().addListener(
					new ChangeListener<Boolean/* 체크박스의 경우 체크 되었냐 아니냐이기때문 */>() {

						@Override
						public void changed(
								ObservableValue<? extends Boolean> observable,
								Boolean oldValue/* 변경되기 전의 값 */,
								Boolean newValue/* 변경 후의 값 */) {
								
								//icons[i].setImage(image[i]); ->사용 할 수 없다.i가 상수가 아니기 때문.
								icon.setImage(newValue?img:null); // -> 그래서 이렇게 상수로 바꿔줌
																				// -> newValue의 상태로 img혹은  null을 넣어줌4
								
						}
					});
		}
		Button btn = new Button("확인");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//====================================================
//				//체크박스의 체크여부를 확인하는 메서드 : isselected()
//				//->체크상태 : true , 미 체크상태 : false
//				
//				for (CheckBox checkBox : chkbx) {
//					if (checkBox.isSelected()) {
//						System.out.println(checkBox.getText() + " selected");
//					}else{
//						System.out.println(checkBox.getText() + " disselected");
//					}
//				}
				//====================================================
				//체크여부를 설정하는 메서드 : setSelected(논리값)
				//논리값이 true면 체크, 아니면 해체
				chkbx[0].setSelected(true);
				chkbx[1].setSelected(false);
			}
		});

		VBox bx = new VBox();
		bx.getChildren().addAll(chkbx);
		bx.getChildren().add(btn);
		bx.setSpacing(5);

		HBox bx2 = new HBox();
		bx2.getChildren().addAll(icons);
		bx2.setPadding(new Insets(0, 0, 0, 5));

		StackPane st = new StackPane();
		st.getChildren().addAll(rect, bx2);
		StackPane.setAlignment(rect, Pos.TOP_CENTER); //위치를 맞춰준다

		HBox rt = new HBox();
		rt.getChildren().addAll(bx, st);
		rt.setSpacing(40);
		rt.setPadding(new Insets(20, 10, 10, 20));

		primaryStage.setTitle("쨘");
		primaryStage.setScene(new Scene(rt));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
