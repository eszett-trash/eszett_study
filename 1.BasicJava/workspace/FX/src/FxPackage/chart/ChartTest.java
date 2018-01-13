package FxPackage.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		
		BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		bc.setTitle("나라별 생산량");
		xAxis.setLabel("나라명");
		yAxis.setLabel("생산량");
		
		//바차트에 데이터 셋팅하기
		//Series객체를 이용하여 데이터를 세ㅐㅅ팅한다.
		//Serise객체 하나가 막대 바 하나가 된다.
		
		XYChart.Series<String, Number> s1 = new XYChart.Series<String, Number>();
		s1.setName("2015년");
		s1.getData().add(new XYChart.Data<String, Number>("호주",2500));
		s1.getData().add(new XYChart.Data<String, Number>("영국",25700));
		s1.getData().add(new XYChart.Data<String, Number>("프랑스",56700));
		s1.getData().add(new XYChart.Data<String, Number>("이태리",25700));
		s1.getData().add(new XYChart.Data<String, Number>("미국",25600));
		
		XYChart.Series<String, Number> s2 = new XYChart.Series<String, Number>();
		s2.setName("2016년");
		s2.getData().add(new XYChart.Data<String, Number>("호주",200));
		s2.getData().add(new XYChart.Data<String, Number>("영국",2700));
		s2.getData().add(new XYChart.Data<String, Number>("프랑스",5600));
		s2.getData().add(new XYChart.Data<String, Number>("이태리",2500));
		s2.getData().add(new XYChart.Data<String, Number>("미국",2500));
		
		System.out.println(bc.getData().addAll(s1,s2));
		
		
		primaryStage.setTitle("거시기");
		primaryStage.setScene(new Scene(bc,800,600));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
