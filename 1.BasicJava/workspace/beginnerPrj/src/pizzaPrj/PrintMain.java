package pizzaPrj;

import java.util.Scanner;

public class PrintMain {
	public static void main(String[] args) {
		Print print = new Print();

	}
}

class Print implements IObserver{


	Scanner s = new Scanner(System.in);
	int button;

//	boolean temp() {
//		int cart = 0;
//
//		return false;
//	}
	
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	boolean main() {
		System.out.println("메인메뉴");
		System.out.println();
		System.out.println("1. 회원가입 2.로그인");

		while (true) {
			button = s.nextInt();

			switch (button) {
			case 1:
				join();
				break;
			case 2:
				login();
				break;

			case 999:
				return false;

			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	boolean join() {
		System.out.println("회원가입");
		System.out.println();
		System.out.println("닉네임 입력");
		System.out.println("이메일 입력");
		System.out.println("비밀번호 입력");
		System.out.println("주소 입력");
		System.out.println("핸드폰 번호 입력");

		/* 전부 출력 */

		System.out.println("가입 하시겠습니까?");
		System.out.println("1. Y 2.N");
		while (true) {
			button = s.nextInt();

			switch (button) {
			case 1:
				/* (디비등록과정잇음) */

			case 2:
				login();
				break;

			case 999:
				return false;

			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	boolean login() {
		System.out.println("아이디");
		String idinput = s.next();
		System.out.println("비밀번호");
		String pwInput = s.next();
		/* 입력된 값과 비교해서 맞으면 들어가기 아님 나가기 */
		/* 관리자단에 등록 된 아이디면 관리자메뉴 출력 */
		System.out.println("임시 : 관리자 1/ 유저 2");
		while (true) {
			button = s.nextInt();

			switch (button) {
			case 1:
				admin_menu();
				break;
			case 2:
				show_event();
				break;

			case 999:
				return false;

			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	// 관리자단
	boolean admin_menu() {
		System.out.println("관리자 메뉴");
		System.out.println("");
		System.out.println("1. 관리자 관리");
		System.out.println("2. 재고 관리");
		System.out.println("3. 메뉴관리");
		System.out.println("4. 이벤트 관리");
		System.out.println("5. 매출 관리");
		System.out.println();
		System.out.println("6. 소비자 화면으로");
		while (true) {
			button = s.nextInt();

			switch (button) {
			case 1:
				admin_management();
				break;
			case 2:
				inventory_management();
				break;
			case 3:
				menu_management();
				break;
			case 4:
				event_management();
				break;
			case 5:
				view_sales();
				break;
			case 6:
				show_event();
			case 999:
				return false;
			default:
				System.out.println("다시 입력 해 주세요");
			}
		}

	}

	boolean admin_management() {
		System.out.println("1. 관리자 리스트 보기");
		System.out.println("2. 관리자 추가");
		return false;
	}

	boolean inventory_management() {
		System.out.println("재고 관리");
		System.out.println("1. 재료 재고 보기");
		System.out.println("2. 사이드메뉴 재고 보기");
		return false;
	}

	boolean menu_management() {
		System.out.println("메뉴관리");
		System.out.println("1. 메뉴 추가");
		System.out.println("2. 메뉴 조회");
		return false;
	}

	boolean event_management() {
		System.out.println("이벤트 관리");
		System.out.println("1. 이벤트 추가");
		System.out.println("2. 이벤트 조회");
		return false;
	}

	boolean view_sales() {
		System.out.println("매출 관리");
		/* 매출 전부 출력 */
		return false;
	}

	// 유저단
	boolean show_event() {
		/* 이벤트 내용 */
		System.out.println("1.참가 2.닫기");
		while (true) {
			button = s.nextInt();

			switch (button) {
			case 1:

				break;
			case 2:
				show_menu();
				break;

			case 999:
				return false;

			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	boolean show_cart() {
		/* 장바구니 출력 */
		System.out.println("1. 결제");
		System.out.println("2. 장바구니에서 삭제");
		while (true) {
			button = s.nextInt();

			switch (button) {
			case 1:
				show_recipt();
				break;
			case 2:
				/* 장바구니 삭제메뉴 */
				break;

			case 999:
				return false;

			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	boolean show_menu() {
		System.out.println("메뉴를 골라주세요");
		System.out.println("1. 피자메뉴");
		System.out.println("2. 사이드메뉴");
		System.out.println("3. 이벤트메뉴");
		/* 장바구니 안에 선택한것이 있으면 장바구니 확인 출력 */
		return false;
	}

	boolean show_recipt() {
		/* 가격과 품목 주소 전화번호확인 */
		System.out.println("결제하시겠습니까?");
		System.out.println("1. 예 2.아니오");
		/* 개인정보 수정메뉴 여유있으면 */
		while (true) {
			button = s.nextInt();

			switch (button) {
			case 1:
				show_payment();
				break;
			case 2:
				show_cart();
				break;

			case 999:
				return false;

			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	boolean show_payment() {
		/* 결제 항목 선택 */
		/* 쿠폰 리스트 보여주기 */
		/* 쿠폰 적용가 */
		return false;
	}
}