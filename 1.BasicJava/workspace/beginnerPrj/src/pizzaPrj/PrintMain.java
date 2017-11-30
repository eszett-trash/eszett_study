package pizzaPrj;

import java.util.Scanner;

public class PrintMain {
	public static void main(String[] args) {
		Print print = new Print();
		print.main();
	}
}

class Print {

	Scanner s = new Scanner(System.in);
	PizzaDB pd = PizzaDB.getInstance();
	String button;
	String mailInput;

	boolean main() {
		System.out.println("메인메뉴");
		System.out.println();
		System.out.println("모든 메뉴에서 999는 종료입니다.");
		System.out.println("모든 메뉴에서 M은 메인으로 돌아갑니다. (자동 로그아웃)");
		System.out.println("1. 회원가입 2.로그인");
		while (true) {
			switch (s.next()) {
			case "1":
				join(false);
				break;
			case "2":
				login();
				break;
			case "999":
				s.close();
				return false;
			case "M":
				main();
				break;
			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	public int intErrchk() {
		int temp;
		try {
			temp = s.nextInt();
		} catch (Exception e) {
			temp = 0;
		}
		return temp;
	}

	boolean join(boolean isAdmin) {

		while (true) {
			System.out.println("회원가입");
			System.out.println();
			System.out.println("닉네임 입력");
			String nickname = s.next();
			s.nextLine();
			System.out.println("이메일 입력");
			String email = s.next();
			s.nextLine();
			System.out.println("비밀번호 입력");
			String password = s.next();
			s.nextLine();
			System.out.println("주소 입력");
			String address = s.next();
			s.nextLine();
			System.out.println("핸드폰 번호 입력");
			String hp = s.next();
			s.nextLine();

			System.out.println("가입 하시겠습니까?");
			System.out.println("1. Y 2.N");

			switch (s.next()) {
			case "1":
				if (pd.join(nickname, email, password, address, hp, isAdmin)) {
					System.out.println("가입 성공!");
					main();
					break;
				} else {
					join(false);
					break;
				}
			case "2":
				main();
				break;
			case "999":
				s.close();
				return false;
			case "M":
				main();
				break;
			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	void login() {
		while (true) {
			System.out.println("이메일");
			String mailinput = s.next();
			s.nextLine();
			System.out.println("비밀번호");
			String pwInput = s.next();
			s.nextLine();
			this.mailInput = mailinput;
			switch (pd.login(mailinput, pwInput)) {
			case 0:
				// show_event();
				show_menu();
				break;
			case 1:
				admin_menu();
				break;
			default:
				System.out.println("다시 입력 해 주세요");
				break;
			}
		}
	}

	// 관리자단
	boolean admin_menu() {
		while (true) {
			System.out.println("관리자 메뉴");
			System.out.println("");
			System.out.println("1. 관리자 관리");
			System.out.println("2. 재고 관리");
			System.out.println("3. 메뉴관리");
			// System.out.println("4. 이벤트 관리");
			System.out.println("5. 매출 조회");
			System.out.println();
			System.out.println("6. 소비자 화면으로");
			button = s.next();
			s.nextLine();
			switch (button) {
			case "1":
				admin_management();
				break;
			case "2":
				inventory_management();
				break;
			case "3":
				menu_management();
				break;
			// case "4":
			// event_management();
			// break;
			case "5":
				view_sales();
				break;
			case "6":
				// show_event();
				show_menu();
			case "999":
				s.close();
				return false;
			case "M":
				main();
				break;
			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	boolean admin_management() {
		while (true) {
			System.out.println("관리자 관리");
			System.out.println();
			System.out.println("1. 관리자 리스트 보기");
			System.out.println("2. 관리자 추가");
			button = s.next();
			s.nextLine();
			switch (button) {
			case "1":
				pd.show_admin();
				break;
			case "2":
				join(true);
				break;
			case "999":
				s.close();
				return false;
			case "M":
				main();
				break;
			default:
				break;
			}
		}
	}

	boolean inventory_management() {
		System.out.println("재고 관리");
		if (!pd.show_inven()) {
			System.out.println("등록 된 재료가 없습니다.");
		}
		while (true) {
			System.out.println("재고를 변경하시겠습니까?");
			if (pd.show_inven()) {
				System.out.println("1.재고 변경");
			}
			System.out.println("2. 품목 추가");
			System.out.println("3. 품목 삭제");
			button = s.next();
			s.nextLine();
			switch (button) {
			case "1":
				if (pd.show_inven()) {
					System.out.println("추가 할 재고의 아이디와 수량을 입력 해 주세요.");
					System.out.println("무엇을?");
					int id = intErrchk();
					System.out.println("몇 개 or (토핑/음료)몇 그람?");
					int remine = intErrchk();
					pd.update_inven(id, remine);
				} else {
					System.out.println("없는 메뉴입니다.");
				}
				break;
			case "2":
				System.out.println("추가 할 재고의 종류와 수량을 입력 해 주세요.");
				System.out.println("무엇을? : 1. 사이드 2.토핑 3.도우 4. 음료");
				int kind = intErrchk();
				System.out.println("이름?");
				String name = s.next();
				s.nextLine();
				System.out.println("사용량?");
				int use = intErrchk();
				int price;
				if (kind == 2) {
					System.out.println("가격을 입력 해 주세요");
					price = intErrchk();
				} else {
					price = 0;
				}
				pd.update_inven(name, kind, use, price);
				break;
			case "3":
				System.out.println("지울 품목의 아이디를 알려주세요.");
				int id = intErrchk();
				if (!pd.delete_inven(id)) {
					System.out.println("존재하지 않거나 수량이 0이 아닌아이템입니다.");
				}
				break;
			case "999":
				s.close();
				return false;
			case "M":
				main();
				break;
			default:
				break;
			}
		}
	}

	boolean menu_management() {
		while (true) {
			pd.show_menu(true);
			System.out.println("1. 메뉴 추가");
			System.out.println("2. 메뉴 삭제");
			button = s.next();
			s.nextLine();
			switch (button) {
			case "1":
				System.out.println("추가 할 피자 이름을 입력 해 주세요");
				String name = s.next();
				s.nextLine();
				System.out.println("추가 할 피자의 가격을 입력 해 주세요");
				int price = intErrchk();
				pd.add_menu(name, price);
				pd.show_toppingmenu();
				System.out.println("추가 할 토핑을 입력 해 주세요.(컴마로 구분)");
				String id = s.next();
				s.nextLine();
				pd.add_topping(id);
				// // TODO 구현해라 비트마스킹 써서 넣으면 temp ^=( 1 << index );
				// // TODO http://studymake.blogspot.kr/2015/05/cc_14.html
				break;
			case "2":
				System.out.println("삭제 할 품목의 아이디를 입력 해 주세요");
				pd.delete_pizza(intErrchk());
				break;
			case "M":
				main();
				break;
			default:
				break;
			}
		}
	}

	// boolean event_management() {
	// System.out.println("이벤트 관리");
	// System.out.println("1. 이벤트 추가");
	// System.out.println("2. 이벤트 조회");
	// return false;
	// }

	void view_sales() {
		System.out.println("매출 조회");
		/* 매출 전부 출력 */
	}

	// // 유저단
	// boolean show_event() {
	// /* 이벤트 내용 */
	// System.out.println("1.참가 2.닫기");
	// while (true) {
	// button = s.next(); s.nextLine();
	//
	// switch (button) {
	// case "1":
	//
	// break;
	// case "2":
	// show_menu();
	// break;
	//
	// case "999":
	// s.close();
	// return false;
	// case "M":
	// main();
	// break;
	//
	// default:
	// System.out.println("다시 입력 해 주세요");
	// }
	// }
	// }

	boolean show_cart() {
		pd.show_cart();
		System.out.println("1. 결제");
		System.out.println("2. 장바구니에서 삭제");
		while (true) {
			button = s.next();
			s.nextLine();
			switch (button) {
			case "1":
				show_recipt();
				break;
			case "2":
				System.out.println("삭제 할 품목의 아이디를 입력 해 주세요");
				int id = intErrchk();
				pd.delete_cart(id);
				break;
			case "999":
				s.close();
				return false;
			case "M":
				main();
				break;
			default:
				System.out.println("다시 입력 해 주세요");
			}
		}
	}

	boolean show_menu() {
		while (true) {
			System.out.println("메뉴를 골라주세요");
			System.out.println("1. 피자메뉴");
			System.out.println("2. 사이드메뉴");
			// System.out.println("3. 이벤트메뉴");
			System.out.println("4. 카트보기");

			switch (s.next()) {
			case "1":
				pd.show_pizzamenu();
				System.out.println("구매 할 메뉴의 아이디를 입력 해 주세요");
				int id = intErrchk();
				pd.buy_pizza(id);
				break;
			case "2":
				pd.show_sidemenu();
				break;
			case "3":
				pd.show_eventmenu();
				break;
			case "4":
				show_cart();
				break;
			case "999":
				s.close();
				return false;
			case "M":
				main();
				break;

			default:
				System.out.println("다시 입력 해 주세요");
				break;
			}
		}
	}

	boolean show_recipt() {
		System.out.println("===================배송 확인====================");
		pd.show_privateinfomation(mailInput);
		System.out.println("결제하시겠습니까?");
		System.out.println("1. 예 2.아니오 3.정보 수정");
		while (true) {
			button = s.next();
			s.nextLine();
			switch (button) {
			case "1":
				show_payment();
				break;
			case "2":
				show_cart();
				break;
			case "3":
				System.out.println("주소 재 입력");
				String address = s.next();
				s.nextLine();
				System.out.println("전화번호 재 입력");
				String ph = s.next();
				s.nextLine();
				pd.modify_privateInfomation(mailInput, address, ph);
				show_recipt();
				break;
			case "999":
				s.close();
				return false;
			case "M":
				main();
				break;
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