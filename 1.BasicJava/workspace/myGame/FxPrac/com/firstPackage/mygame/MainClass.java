package com.firstPackage.mygame;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainClass extends Application {


	public static void main(String[] args) {
		System.out.println("start");
		launch(args);
		System.out.println("quit");
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FX 첫 프로젝트");
		
		Button btn = new Button();
		btn.setText("누르시오");
		System.out.println("create btn");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("알림");
				a.setContentText("알림에 대한 텍스트");
				a.setHeaderText(null);
				a.show();
				System.out.println("alert Window");
			}
		});
		System.out.println("create widow");
		StackPane sp = new StackPane();
		sp.getChildren().addAll(btn);
		System.out.println("show window");
		primaryStage.setScene(new Scene(sp, 500, 400));
		primaryStage.show();		
		
	}

}
