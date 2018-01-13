package FxPackage.mvc.member;

/**
 * Sample Skeleton for 'MemberMVCMain.fxml' Controller Class
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import sun.print.resources.serviceui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MemberMVCController {
	
	private ObservableList<MemberVO> data;
	private MemberServiceImpl service;
	private String strWork="";

	@FXML
	// ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML
	// URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML
	// fx:id="txtId"
	private TextField txtId; // Value injected by FXMLLoader

	@FXML
	// fx:id="txtName"
	private TextField txtName; // Value injected by FXMLLoader

	@FXML
	// fx:id="txtTel"
	private TextField txtTel; // Value injected by FXMLLoader

	@FXML
	// fx:id="txtAddr"
	private TextField txtAddr; // Value injected by FXMLLoader

	@FXML
	// fx:id="btnAdd"
	private Button btnAdd; // Value injected by FXMLLoader

	@FXML
	// fx:id="btnEdit"
	private Button btnEdit; // Value injected by FXMLLoader

	@FXML
	// fx:id="btnDel"
	private Button btnDel; // Value injected by FXMLLoader

	@FXML
	// fx:id="btnOk"
	private Button btnOk; // Value injected by FXMLLoader

	@FXML
	// fx:id="btnCancel"
	private Button btnCancel; // Value injected by FXMLLoader

	@FXML
	// fx:id="table"
	private TableView<MemberVO> table; // Value injected by FXMLLoader

	@FXML
	// fx:id="idCol"
	private TableColumn<?, ?> idCol; // Value injected by FXMLLoader

	@FXML
	// fx:id="nameCol"
	private TableColumn<?, ?> nameCol; // Value injected by FXMLLoader

	@FXML
	// fx:id="telCol"
	private TableColumn<?, ?> telCol; // Value injected by FXMLLoader

	@FXML
	// fx:id="addrCol"
	private TableColumn<?, ?> addrCol; // Value injected by FXMLLoader

	//추가버튼 클릭 이벤트 처리
	@FXML
	void dataAdd(ActionEvent event) {
		txtId.setEditable(true);
		txtName.setEditable(true);
		txtTel.setEditable(true);
		txtAddr.setEditable(true);
		
		//활성화
		btnOk.setDisable(false);
		btnCancel.setDisable(false);

		//비활성화
		btnCancel.setDisable(true);
		btnCancel.setDisable(true);
		btnCancel.setDisable(true);
		
		//TableView도 비활성화 시켜서 클릭이벤트가 작동하지 않도록 한다
		table.setDisable(true);
		
		txtId.clear();
		txtName.clear();
		txtTel.clear();
		txtAddr.clear();
		
		strWork = "insert";
		
		txtId.requestFocus(); // ID 입력필드에 포커스를 준다.
	}

	@FXML
	void dataCancel(ActionEvent event) {
		txtId.setEditable(false);
		txtName.setEditable(false);
		txtTel.setEditable(false);
		txtAddr.setEditable(false);
		
		//활성화
		btnOk.setDisable(true);
		btnCancel.setDisable(true);

		//비활성화
		btnCancel.setDisable(false);
		btnCancel.setDisable(false);
		btnCancel.setDisable(false);
		
		//TableView도 비활성화 시켜서 클릭이벤트가 작동하지 않도록 한다
		table.setDisable(false);
		
		strWork="";
	}

	@FXML
	void dataDel(ActionEvent event) {
		int index;
		if ((index =table.getSelectionModel().getSelectedIndex())== -1) {
			alert("삭제할항목을 선택 한 후 사용하세요");
			return;
		}
		ButtonType btnt = confirm("정말로 삭제하시겠습니까?");
		
		if (btnt==ButtonType.OK) {
			//선택한 줄에서 mem_id값 가져오기
			//String memOd = table.getSelectionModel().getSelectedItem().getMem_id();
			//TextField에서mem_id값 가져오기
			
			String memId = txtId.getText();
			
			if(service.deleteMember(memId)>0){
				data.remove(index);
				alert(memId + "회원정보를 삭제했습니다.");
				txtId.clear();
				txtName.clear();
				txtTel.clear();
				txtAddr.clear();
			}
		}
	}

	@FXML
	void dataEdit(ActionEvent event) {
		if (table.getSelectionModel().getSelectedIndex()==-1) {
			alert("수정 할 데이터를 선택해서 사용 하세요");
		}
		txtId.setEditable(true);
		txtName.setEditable(true);
		txtTel.setEditable(true);
		txtAddr.setEditable(true);
		
		//활성화
		btnOk.setDisable(false);
		btnCancel.setDisable(false);

		//비활성화
		btnCancel.setDisable(true);
		btnCancel.setDisable(true);
		btnCancel.setDisable(true);
		
		//TableView도 비활성화 시켜서 클릭이벤트가 작동하지 않도록 한다
		table.setDisable(true);
		
		strWork = "update";
		
		txtId.requestFocus(); // ID 입력필드에 포커스를 준다.
	}

	@FXML
	void dataRun(ActionEvent event) {
			if (strWork.equals("insert")) {
				if (txtId.getText().isEmpty() ||txtName.getText().isEmpty() ||txtTel.getText().isEmpty() ||txtAddr.getText().isEmpty() ) {
					alert("빈 항목이 있습니다.");
					return;
				}
				MemberVO mv = new MemberVO();
				mv.setMem_id(txtId.getText());
				mv.setMem_name(txtName.getText());
				mv.setMem_tel(txtTel.getText());
				mv.setMem_addr(txtAddr.getText());
				
				if (service.insertMember(mv)>0) {
					data.add(mv);
					alert("추가작업 성공");
					txtId.clear();
					txtName.clear();
					txtTel.clear();
					txtAddr.clear();
				}else{
					alert("추가작업 실패");
				}
			}else if(strWork.equals("update")){
				if (txtId.getText().isEmpty() ||txtName.getText().isEmpty() ||txtTel.getText().isEmpty() ||txtAddr.getText().isEmpty() ) {
					alert("빈 항목이 있습니다.");
					return;
				}
				MemberVO mv = new MemberVO();
				mv.setMem_id(txtId.getText());
				mv.setMem_name(txtName.getText());
				mv.setMem_tel(txtTel.getText());
				mv.setMem_addr(txtAddr.getText());
				
				if (service.updateMember(mv)>0) {
					data.set(table.getSelectionModel().getSelectedIndex(),mv);
					alert("수정 ㅇㅋ");
				}else{
					alert("수정 ㄴㄴ");
				}
			}
	}

	@FXML
	void tableClick(MouseEvent event) {
		MemberVO mvo = table.getSelectionModel().getSelectedItem();
		if (mvo!=null) {
			txtId.setText(mvo.getMem_id());
			txtName.setText(mvo.getMem_name());
			txtTel.setText(mvo.getMem_tel());
			txtAddr.setText(mvo.getMem_addr());
		}

	}

	@FXML
	// This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		//초기화 부분으로 이곳에는 이벤트 설정이나 초기화 작업 내용을 기술한다.
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
		
		//테이블뷰에 회원정보 출력하기
		service = MemberServiceImpl.getInstance();
		
		idCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
		telCol.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
		addrCol.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
		
		ArrayList<MemberVO> memList =(ArrayList<MemberVO> ) service.getAllMember();
		data = FXCollections.observableArrayList(memList);
		
		table.setItems(data);
		
	}
	
	private void alert(String msg) {
		// TODO Auto-generated method stub
		Alert aw = new Alert(AlertType.WARNING);
		aw.setTitle("");
		aw.setHeaderText("");
		aw.setContentText(msg);
		aw.showAndWait();
	}
	private ButtonType confirm(String msg) {
		// TODO Auto-generated method stub
		Alert aw = new Alert(AlertType.CONFIRMATION);
		aw.setTitle("");
		aw.setHeaderText("");
		aw.setContentText(msg);
		aw.showAndWait();
		return ButtonType.OK;
	}
}
