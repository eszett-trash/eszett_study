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
			iv.setImage(new Image(getClass().getResourceAsStream("../images/Home.jpg")));
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
