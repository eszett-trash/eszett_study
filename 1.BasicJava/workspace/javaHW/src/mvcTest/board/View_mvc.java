package mvcTest.board;

import java.util.Scanner;

public class View_mvc {
	Searvice_mvc sm = null;
	public View_mvc() {
		sm = Searvice_mvc.getInstance();
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
		while (true) {
			System.out.print("상세 보기 할 게시글 번호 입력 >> ");
		}		
	}
	private void n_Write() {
		// TODO Auto-generated method stub
		
	}
	private void modi_Write() {
		// TODO Auto-generated method stub
		
	}
	private void delete() {
		
		
	}
	
}
