package FxPackage.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		PieChart pc = new PieChart();
		
		//차트에서 사용할 데이터 구성
		ObservableList<PieChart.Data> pcd = FXCollections.observableArrayList(
			new PieChart.Data("포도",13),	
			new PieChart.Data("딸기",23),	
			new PieChart.Data("오렌지",1113),	
			new PieChart.Data("수빅",1233),	
			new PieChart.Data("사과",143)
			);
		
		pc.setData(pcd);
		pc.setLabelLineLength(10);
		pc.setLegendSide(Side.LEFT);
		
		primaryStage.setTitle("파이차트");
		primaryStage.setScene(new Scene(pc));
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
