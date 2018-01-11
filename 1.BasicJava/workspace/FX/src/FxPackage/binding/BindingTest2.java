package FxPackage.binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BindingTest2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane p = new Pane();
		
		Circle c1 = new Circle(50, 50, 50);
		Circle c2 = new Circle(300, 300, 100);
		
		c1.setFill(Color.ROYALBLUE);
		c2.setFill(Color.ROSYBROWN);
		p.getChildren().addAll(c1,c2);
		
		//bind메서드에서 계산에 사용되는 메서드는
		//Bindings객체의 정적 메서드로 지원한다.
		Scene s = new Scene(p);
		primaryStage.setTitle("타이틀");
		primaryStage.setWidth(600);
		primaryStage.setHeight(600);		
		primaryStage.setScene(s);
		
		c2.centerXProperty().bind(Bindings.divide(s.widthProperty(), 2));
		c2.centerYProperty().bind(Bindings.divide(s.heightProperty(), 2));
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
