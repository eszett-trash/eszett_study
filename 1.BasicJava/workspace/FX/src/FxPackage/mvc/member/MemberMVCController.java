package FxPackage.mvc.member;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MemberMVCController {
	private Stage primaryStage;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtAddr;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private TableView<MemberVO> table;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> telCol;

    @FXML
    private TableColumn<?, ?> addrCol;

    // 추가버튼 클릭 이벤트 처리
    @FXML
    void dataAdd(ActionEvent event) throws IOException {
    	Stage newSg = new Stage(StageStyle.DECORATED);
    	newSg.initModality(Modality.WINDOW_MODAL);
    	newSg.initOwner(primaryStage);
    	
    	Parent sub = FXMLLoader.load(getClass().getResource("ChildWindow.fxml"));
    	
    	Scene scene = new Scene(sub);
    	newSg.setScene(scene);
    	newSg.setTitle("자식창");
    	newSg.show();
    	
    	
    	txtId.setEditable(true);  // 편집이 가능한 상태로 변경
    	txtName.setEditable(true);
    	txtTel.setEditable(true);
    	txtAddr.setEditable(true);
    	
    	btnOk.setDisable(false);  // 활성화
    	btnCancel.setDisable(false);
    	
    	btnAdd.setDisable(true);  // 비활성화
    	btnEdit.setDisable(true);
    	btnDel.setDisable(true);
    	
    	// TableView도 비활성화 시켜서 클릭 이벤트가 작동하지 않도록 한다.
    	table.setDisable(true);
    	
    	txtId.clear();  // TextField의 내용 삭제
    	txtName.clear();
    	txtTel.clear();
    	txtAddr.clear();
    	
    	strWork = "insert";
    	
    	txtId.requestFocus();  // ID입력필드에 포커스를 준다.
    }

    // 취소버튼 클릭 이벤트 처리
    @FXML
    void dataCancel(ActionEvent event) {
    	txtId.setEditable(false);  // 편집이 불가능한 상태로 변경
    	txtName.setEditable(false);
    	txtTel.setEditable(false);
    	txtAddr.setEditable(false);
    	
    	btnOk.setDisable(true);  // 비활성화
    	btnCancel.setDisable(true);
    	
    	btnAdd.setDisable(false);  // 활성화
    	btnEdit.setDisable(false);
    	btnDel.setDisable(false);
    	
    	// TableView도 다시 활성화 시킨다.
    	table.setDisable(false);
    	
    	strWork = "";
    }

    // 삭제버튼 클릭 이벤트 처리
    @FXML
    void dataDel(ActionEvent event) {
    	int index = table.getSelectionModel().getSelectedIndex();
    	if(index==-1) {
    		alert("삭제할 항목을 선택한 후 사용하세요");
    		return;
    	}
    	
    	ButtonType btnType = confirm("정말로 삭제하시겠습니까?");
    	if(btnType == ButtonType.OK) {
    		// 선택한 줄에서 Mem_id값 가져오기 (방법1)
    		//String memId = table.getSelectionModel().getSelectedItem().getMem_id();
    		
    		// TextField에서 mem_id값 가져오기 (방법2)
    		String memId = txtId.getText();
    		
    		int cnt = service.deleteMember(memId);
    		if(cnt>0) {
    			// DB작업 후 TableView에서 자료 삭제
    			data.remove(index);
    			alert(memId + "회원 정보를 삭제했습니다.");
    			
    			txtId.clear();
    			txtName.clear();
    			txtTel.clear();
    			txtAddr.clear();
    			
    		}else {
    			alert("삭제 실패!!");
    		}
    		
    		
    	}
    }

    // 수정버튼 클릭 이벤트 처리
    @FXML
    void dataEdit(ActionEvent event) {
    	if(table.getSelectionModel().getSelectedIndex()==-1) {
    		alert("수정할 데이터를 선택한 후 사용하세요.");
    		return;
    	}
    	
    	//txtId.setEditable(true);  // 편집이 가능한 상태로 변경
    	txtName.setEditable(true);
    	txtTel.setEditable(true);
    	txtAddr.setEditable(true);
    	
    	btnOk.setDisable(false);  // 활성화
    	btnCancel.setDisable(false);
    	
    	btnAdd.setDisable(true);  // 비활성화
    	btnEdit.setDisable(true);
    	btnDel.setDisable(true);
    	
    	// TableView도 비활성화 시켜서 클릭 이벤트가 작동하지 않도록 한다.
    	table.setDisable(true);
    	
    	strWork = "update";
    	
    	txtName.requestFocus();  // Name입력필드에 포커스를 준다.
    }

    // 확인버튼 클릭 이벤트 처리
    @FXML
    void dataRun(ActionEvent event) {
    	 
    	if("insert".equals(strWork)) {
    		// 데이터 추가 작업
    		if(txtId.getText().isEmpty() || txtName.getText().isEmpty() ||
    			txtTel.getText().isEmpty() || txtAddr.getText().isEmpty() ) {
    			alert("빈 항목이 있습니다.");
    			return;
    		}
    		
    		MemberVO mvo = new MemberVO();
    		mvo.setMem_id(txtId.getText());
    		mvo.setMem_name(txtName.getText());
    		mvo.setMem_tel(txtTel.getText());
    		mvo.setMem_addr(txtAddr.getText());
    		
    		int cnt = service.insertMember(mvo);
    		
    		if(cnt>0) {
    			data.add(mvo);  // DB에 Insert된 후 TableView에도 데이터 추가
    			alert("추가 작업 성공");
    			txtId.clear();
    			txtName.clear();
    			txtTel.clear();
    			txtAddr.clear();
    		}else {
    			alert("추가 작업 실패");
    		}
    		
    		
    	}else if("update".equals(strWork)){
			// 수정작업 처리
    		if(txtId.getText().isEmpty() || txtName.getText().isEmpty() ||
    			txtTel.getText().isEmpty() || txtAddr.getText().isEmpty() ) {
    			alert("빈 항목이 있습니다.");
    			return;
    		}
    		
    		MemberVO mvo = new MemberVO();
    		mvo.setMem_id(txtId.getText());
    		mvo.setMem_name(txtName.getText());
    		mvo.setMem_tel(txtTel.getText());
    		mvo.setMem_addr(txtAddr.getText());
    		
    		int cnt = service.updateMember(mvo);
    		
    		if(cnt>0) {
    			// DB의 Update작업 완료 후 TableView의 데이터도 수정해 준다.
    			int index = table.getSelectionModel().getSelectedIndex();
    			data.set(index, mvo);
    			
    			alert("수정 작업 완료");
    		}else {
    			alert("수정 작업 실패");
    		}
		}
    	
    	// 작업 완료 후 원래 상태로 만들어 준다.
    	txtId.setEditable(false);  // 편집이 불가능한 상태로 변경
    	txtName.setEditable(false);
    	txtTel.setEditable(false);
    	txtAddr.setEditable(false);
    	
    	btnOk.setDisable(true);  // 비활성화
    	btnCancel.setDisable(true);
    	
    	btnAdd.setDisable(false);  // 활성화
    	btnEdit.setDisable(false);
    	btnDel.setDisable(false);
    	
    	// TableView도 다시 활성화 시킨다.
    	table.setDisable(false);
    	
    	strWork = "";
    	
    	
    }

    // TableView를 클릭했을 때 이벤트 처리
    @FXML
    void tableClick(MouseEvent event) {
    	MemberVO mvo = table.getSelectionModel().getSelectedItem();
    	if(mvo!=null) {
    		txtId.setText(mvo.getMem_id());
    		txtName.setText(mvo.getMem_name());
    		txtTel.setText(mvo.getMem_tel());
    		txtAddr.setText(mvo.getMem_addr());
    	}
    }

    private ObservableList<MemberVO> data;
    private MemberServiceImpl service;
    private String strWork = "";
    
    @FXML
    void initialize() {
    	// 초기화 부분으로 이곳에는 이벤트 설정이나
    	// 초기화 작업 내용을 기술한다.
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert txtTel != null : "fx:id=\"txtTel\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert txtAddr != null : "fx:id=\"txtAddr\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert telCol != null : "fx:id=\"telCol\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";
        assert addrCol != null : "fx:id=\"addrCol\" was not injected: check your FXML file 'MemberMVCMain.fxml'.";

        // TableView에 회원 정보 출력하기
        service = MemberServiceImpl.getInstance();
        
        // TableColumn 셋팅하기
        idCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
        addrCol.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
        
        // DB에서 자료 가져오기
        ArrayList<MemberVO> memList =
        		(ArrayList<MemberVO>) service.getAllMember();
        // 가져온 데이터를 ObservableList에 담는다.
        data = FXCollections.observableArrayList(memList);
        
        // TableView에 데이터 셋팅한다.
        table.setItems(data);

    }
    
    // alert창
    public void alert(String msg) {
    	Alert alertWarning = new Alert(AlertType.WARNING);
    	alertWarning.setTitle("경고");
    	alertWarning.setHeaderText("경고 메시지");
    	alertWarning.setContentText(msg);
    	alertWarning.showAndWait();
    }
    
    // confirm창
    public ButtonType confirm(String msg) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	confirm.setTitle("선택");
    	confirm.setHeaderText("선택 메시지");
    	confirm.setContentText(msg);
    	return confirm.showAndWait().get();
    }
    
}















