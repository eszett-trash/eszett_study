package mvcTest.board;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class View_mvc {
	Dao_mvc dam = Dao_mvc.getInstance();
	public View_mvc() {
	}
	
	private int intErrchk() { //입력단 에러체크 메서드 (view 클래스 전체에서 사용)
		Scanner ss = new Scanner(System.in);
		int temp;
		try {
			temp = ss.nextInt();
		} catch (Exception e) {
			temp = -1; //입력 오류시 -1을 리턴
		}
		return temp;
	}	
	private String strErrchk(){
		Scanner sc = new Scanner(System.in);
		String temp;
		try {
			temp=sc.nextLine();
			temp = temp.trim();
		} catch (Exception e) {
			temp = "\0";
		}
		return temp;
	}
	private String strErrChk_next(){
		Scanner sc = new Scanner(System.in);
		String temp;
		try {
			temp=sc.next();
		} catch (Exception e) {
			temp = "\0";
		}
		return temp;
	}

	public void start(){
		while (true) {
			System.out.println("==================================="
					+ "============================");
			System.out.println("\t번호\t\t\t\t제목\t\t\t\t\t작성자\t\t\t날짜");
			System.out.println("==================================="
					+ "============================");
			
			System.out.println("==================================="
					+ "============================");
			System.out.println("==================================="
					+ "============================");
			System.out.println("1. 상세보기\t\t2. 새글쓰기\t\t 3. 게시글 수정\t"
					+ "\t 4. 게시글 삭제");
			System.out.print("작업 선택 >> ");
			switch (intErrchk()) {
			case 1:
				vw();
				break;
			case 2:
				n_Write();
				break;
			case 3:
				modi_Write();
				break;
			case 4:
				delete();
				break;

			default:
				System.out.println("입력에러.");
				break;
			}
		}
		
	}
	private void vw() {
		System.out.print("상세 보기 할 게시글 번호 입력 >> ");
	}
	private void n_Write() {
		while (true) {
			String sql = "insert into jdbc_board (board_no, board_title, board_writer, board_date, board_content)"
					+ " values (?,?,?,sysdate,?)";
			
			dam.insertCon(sql);
		}		
		
	}
	private void modi_Write() {
		// TODO Auto-generated method stub
		
	}
	private void delete() {
		
		
	}
	
}
