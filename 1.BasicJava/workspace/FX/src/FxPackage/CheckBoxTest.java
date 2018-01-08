package FxPackage;

import javafx.application.Application;
import javafx.geometry.Insets;
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
		String[] names= new String[] {"Security", "Project","Chart"};
		Image[] image = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];
		CheckBox[] chkbx = new CheckBox[names.length];
		
		Rectangle rect = new Rectangle(90,30);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		rect.setFill(Color.BLUE);
		
		for (int i = 0; i < names.length; i++) {
			image[i] = new Image(getClass().getResourceAsStream("images/"+names[i]+".png"));
			icons[i] = new ImageView();
			chkbx[i] = new CheckBox(names[i]);
		}
		Button btn = new Button("확인");
		
		VBox bx = new VBox();
		bx.getChildren().addAll(chkbx);
		bx.getChildren().add(btn);
		bx.setSpacing(5);
		
		HBox bx2 = new HBox();
		bx2.getChildren().addAll(icons);
		bx2.setPadding(new Insets(0, 0, 0, 5));
		
		StackPane st = new StackPane();
		st.getChildren().addAll(rect,bx2);
		
		HBox rt = new HBox();
		rt.getChildren().addAll(bx,st);
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
