package FxPackage.binding;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane rt = new BorderPane();
		
		MenuBar mb = new MenuBar();
		mb.prefWidthProperty().bind(primaryStage.widthProperty());
		rt.setTop(mb);
		
		//File menu = new, save, exit
		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		MenuItem newMenuItm = new MenuItem("new");
		
		//이미지 생성
		ImageView sIV = new ImageView();
		Image img = new Image(getClass().getResourceAsStream("../images/Security.png"));
		sIV.setImage(img);
		newMenuItm.setGraphic(sIV);
		
		MenuItem saveMenuItem = new MenuItem("save");
		MenuItem exitMenuItem = new MenuItem("exit");
		exitMenuItem.setOnAction(e->{
			Platform.exit();
		});
		//메뉴객체에 메뉴아이템 객체를 추가한다.
		fileMenu.getItems().addAll(newMenuItm, saveMenuItem, exitMenuItem);
		//-------------------------------------------
		//체크박스같은 메뉴
		//------------------------------------------
		Menu webMenu = new Menu("Web");
		CheckMenuItem htmlMI = new CheckMenuItem("HTML");
		CheckMenuItem cssMI	= new CheckMenuItem("CSS");
		cssMI.setSelected(true);
		CheckMenuItem jsMI = new CheckMenuItem("javaScript");
		webMenu.getItems().addAll(htmlMI,cssMI,jsMI);
		//------------------------------------------
		//라디오버튼같은 메뉴
		//------------------------------------------
		Menu sqlM = new Menu("SQL");
		ToggleGroup tg = new ToggleGroup();
		
		RadioMenuItem mysqlI = new RadioMenuItem("My-SQL");
		RadioMenuItem orasqlI = new RadioMenuItem("Oracle");
		RadioMenuItem mssqlI = new RadioMenuItem("MS-SQL");
		
		mysqlI.setToggleGroup(tg);
		orasqlI.setToggleGroup(tg);
		mssqlI.setToggleGroup(tg);
		
		sqlM.getItems().addAll(mysqlI,orasqlI,mssqlI,new SeparatorMenuItem()/*메뉴에 선긋기*/);
		//------------------------------------------
		//메뉴 안에 메뉴 추가
		//------------------------------------------
		Menu tutoMenu = new Menu("Tutorial");
		tutoMenu.getItems().addAll(
				new CheckMenuItem("자바 초급"),
				new CheckMenuItem("자바 고급"),
				new CheckMenuItem("데이터베이스")
				);
		
		sqlM.getItems().add(tutoMenu);
		
		//------------------------------------------
		//메뉴바에 객체 추가
		mb.getMenus().addAll(fileMenu,editMenu,webMenu,sqlM);
		
		primaryStage.setScene(new Scene(rt,300,200));
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
