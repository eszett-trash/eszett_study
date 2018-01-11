package FxPackage.binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BindingTest3 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Button btn1 = new Button();
		Button btn2 = new Button();
		
		Rectangle rt1 = new Rectangle(0,5,200,15);
		Rectangle rt2 = new Rectangle(0,5,20,15);
		rt1.setFill(null);
		rt1.setStroke(Color.RED);
		rt2.setFill(Color.RED);
		
		btn1.setOnAction(event->{
			if (rt2.getWidth()>1) {
				rt2.setWidth(rt2.getWidth()-5);
			}
			else{
				rt2.setWidth(1);
			}
		});
		btn2.setOnAction(e->{
			rt2.setWidth(rt2.getWidth()+5);
		});
		
		//rt2의 width값 이상이면 증가버튼을 비활성화시킨다.
		btn2.disableProperty().bind(
				Bindings.greaterThanOrEqual(rt2.widthProperty(), rt1.getWidth())
				);
		
		
		Pane p = new Pane();
		p.getChildren().addAll(rt1,rt2);
		
		HBox hb = new HBox(20);
		hb.getChildren().addAll(btn1,p,btn2);
		
		primaryStage.setScene(new Scene(hb));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
