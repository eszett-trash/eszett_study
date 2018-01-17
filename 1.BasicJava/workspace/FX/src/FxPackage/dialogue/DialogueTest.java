package FxPackage.dialogue;

import java.io.File;





import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class DialogueTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox rt = new HBox(10);
		rt.setPadding(new Insets(10));
		
		Button btnFO = new Button("OPEN FileChooser 실행");
		Button btnFS = new Button("SAVE FileChooser 실행");
		Button btnDIR = new Button("Driectory FileChooser 실행");
		Button btnPop = new Button("Popup 실행");
		
		Button btnCus1 = new Button("사용자 정의 다이얼로그 실행1");
		Button btnCus2 = new Button("사용자 정의 다이얼로그 실행2");
		
		//파일 오픈
		btnFO.setOnAction(e->{
			FileChooser fc = new FileChooser();
			//선택할 파일의 확장자 그룹 설정
			fc.getExtensionFilters().addAll(
					new ExtensionFilter("TextFile","*.txt"),
					new ExtensionFilter("ImageFile","*.png","*.jpg","*.gif"),
					new ExtensionFilter("AudioFile","*.wav","*.mp3"),
					new ExtensionFilter("AllFile","*.*")
			);
			File selectedFile = fc.showOpenDialog(primaryStage);
			if (selectedFile!=null) {
				System.out.println(selectedFile.getPath());
			}
		});
		//파일 세이브
		btnFS.setOnAction(e->{
			FileChooser fc = new FileChooser();
			
			fc.getExtensionFilters().add(new ExtensionFilter("AllFile", "*.*"));
			
			File f = fc.showSaveDialog(primaryStage);
			if (f!=null) {
				System.out.println(f.getPath());
			}
		});
		//디렉토리 선택
		btnDIR.setOnAction(e->{
			DirectoryChooser dc = new DirectoryChooser();
			
			File dir = dc.showDialog(primaryStage);
			if (dir!=null) {
				System.out.println(dir.getPath());
			}
		});
		
		//팝업
		btnPop.setOnAction(e->{
			HBox hb = new HBox(5);
			hb.setAlignment(Pos.CENTER_LEFT);
			hb.setStyle("-fx-background-color: black; -fx-background-radius:20;"); 
			
			ImageView iv = new ImageView();
<<<<<<< HEAD
			iv.setImage(new Image(getClass().getResourceAsStream(
					"../images/Home.jpg")));
			iv.setFitWidth(30);
			iv.setFitHeight(30);
			iv.setOnMouseClicked(ev -> {
				pu.hide();
			});
			Label lb = new Label("메세지 출력출력출력");
			lb.setStyle("-fx-text-fill:white");
			HBox.setMargin(lb, new Insets(0, 5, 0, 5));
			hb.getChildren().addAll(iv, lb);
			pu.getContent().add(hb);
			pu.setAutoHide(true);
			pu.show(primaryStage);

		});

		Button btnCus1 = new Button("사용자 정의 다이얼로그 실행1");
		Button btnCus2 = new Button("사용자 정의 다이얼로그 실행2");

		// 자식창을 자바코드로 직접 작성하는 방법
		btnCus1.setOnAction(e -> {
			Stage secondaryStage = new Stage(StageStyle.UTILITY/* 기본 창 */);

			secondaryStage.initModality(Modality.WINDOW_MODAL); // 모달 창 여부를 설정하기
			secondaryStage.initOwner(primaryStage);// 부모창 설정
			secondaryStage.setTitle("자식창");

			AnchorPane childrt = new AnchorPane();
			ImageView childiv = new ImageView();
			childiv.setImage(new Image(getClass().getResourceAsStream(
					"../images/Calendar.jpg")));
			childiv.setFitWidth(50);
			childiv.setFitHeight(50);
			childiv.setLayoutX(15);
			childiv.setLayoutY(15);

			Button btnOk = new Button("확인");
			btnOk.setLayoutX(336);
			btnOk.setLayoutY(104);
			btnOk.setOnAction(ee -> {
				secondaryStage.close();
			});

			Label childLb = new Label();
			childLb.setText("확인 하셨습니까?");
			childLb.setLayoutX(87);
			childLb.setLayoutY(33);

			childrt.getChildren().addAll(childiv, btnOk, childLb);

			secondaryStage.setTitle("모달창");
			secondaryStage.setScene(new Scene(childrt, 400, 150));
			secondaryStage.resizableProperty().set(false); // 창크기 설정 불가
			secondaryStage.show();
=======
			iv.setImage(new Image(getClass().getResourceAsStream("../images/Home.jpg")));
>>>>>>> parent of 0a40e10... s
		});
		
		rt.getChildren().addAll(btnFO,btnFS,btnDIR,btnPop,btnCus1,btnCus2);
		
		primaryStage.setScene(new Scene(rt));
		primaryStage.setHeight(150);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
