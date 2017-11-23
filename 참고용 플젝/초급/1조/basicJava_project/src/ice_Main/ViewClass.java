package ice_Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ice_VO.MemberVO;
import ice_VO.IceCreamVO;
import ice_VO.RecordVO;
import ice_VO.SizeVO;
import ice_Main.ServiceImpl;
import ice_Main.ServiceInter;

/**
 * 프로그램 실행 시 화면에 입출력해주는 클래스
 * 
 * @author 원용선, 김명찬, 허준호
 *
 */
public class ViewClass {
	MemberVO member = new MemberVO();// 로그인한 회원의 객체를 저장
	ServiceInter service = new ServiceImpl();// Interface를 Implement한 메서드들을 사용.
	Scanner sc = new Scanner(System.in);// 입력
	RegClass rec = new RegClass();

	/**
	 * 첫 실행화면
	 */
	void mainMenu() {
		cs();
		while (true) {
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          아슈원해            │");
			System.out.println("└──────────────────────────┘");
			System.out.println("  1. 손님이세요?");
			System.out.println("  2. 관리자니?");
			System.out.println("  b. 가신다고요?안녕히가세요ㅎ\n");
			System.out.print("  입력 ▶  ");
			String choice = sc.next();
			cs();
			switch (choice) {
			case "1":
				membercheck();
				cs();
				break;

			case "2":
				masterlogin();
				cs();
				break;

			case "b":
				return;

			default:
				System.out.println("잘못입력..");
				continue;
			}
		}
	}

	/**
	 * 뒤로가기(입력받는 값이 없을 시)
	 * 
	 * @return
	 */
	private boolean exitMenu() {
		System.out.println("  ◈ 나가시려면 b나 B를 입력해주세요.◈ ");
		String answer = sc.next();
		if (answer.equals("b") || answer.equals("B")) {
			return true;
		}
		return false;
	}

	/**
	 * 뒤로가기(입력받는 값이 있을 때)
	 * 
	 * @param answer
	 * @return
	 */
	private boolean exitMenu(String answer) {
		if (answer.equals("b") || answer.equals("B")) {
			return true;
		}
		return false;
	}

	/**
	 * 화면 정리용
	 */
	public static void cs() {
		for (int i = 0; i < 5; i++)
			System.out.println("");
	}

	/**
	 * mainMenu() = 1. 손님이세요? 회원메뉴
	 */
	private void membercheck() {
		while (true) {
			System.out.println("┌───────────────────────┐");
			System.out.println("│	회원 페이지	│");
			System.out.println("└───────────────────────┘");
			System.out.println("  Y|y. 로그인");
			System.out.println("  N|n. 회원가입");
			System.out.println("  ◈  나가시려면 b나 B를 입력해주세요.◈ \n");
			System.out.print("  입력 ▶  ");
			String choice = sc.next();
			cs();
			switch (choice) {
			case "Y":
			case "y":
				memberlogin();
				cs();
				break;

			case "N":
			case "n":
				signUp();
				cs();
				break;
			case "B":
			case "b":
				if (exitMenu(choice)) {
					return;
				}
				cs();
				break;
			default:
				System.out.println("  ※  잘못입력.. ※");
				break;
			}
			break;
		}
	}

	/**
	 * 회원가입 화면
	 */
	private void signUp() {
		System.out.println("┌──────────────────────────┐");
		System.out.println("│          회원가입            │");
		System.out.println("└──────────────────────────┘");
		MemberVO mv = new MemberVO();
		String memberCheckId = memberCheckId();
		while (true) {
			System.out.print("  비밀번호를 입력해주세요 ▶  ");
			String memberPassword = sc.next();

			boolean idRegEx1 = rec.idRegEx1(memberPassword);

			if (!idRegEx1) {
				System.out.println("  ※   비밀번호는 영어와 숫자와 특수문자를 이용하여 8~20자리까지만 입력가능! ※");
				continue; // 다시 입력
			} else {
				mv.setMemberPassword(memberPassword);
				break; // 다음으로 넘어감
			}
		}
		mv.setMemberId(memberCheckId);

		boolean result = service.memberCreate(mv);

		if (result) {
			System.out.println("   ※   정상적으로 등록되었습니다. ※");
		} else {
			System.out.println("   ※   저장 중 오류가 발생하셨습니다. ※");
		}

	}

	/**
	 * 회원가입 시 아이디 중복체크
	 * 
	 * @return 없을 시 아이디 리턴
	 */
	private String memberCheckId() {
		while (true) {
			System.out.print("  아이디를 입력해주세요 ▶  ");
			String memberId = sc.next();
			boolean idRegEx = rec.idRegEx(memberId);
			boolean idCheck = memberCheckId(memberId);

			if (idCheck) {
				System.out.println("  ※    해당 아이디가 존재합니다. ※");
				continue;
			}

			if (!idRegEx) {
				System.out.println("  ※   아이디는 영어와 숫자를 섞어서 6~10자리 입력해주세요! ※");
			} else {
				return memberId;
			}
		}
	}

	/**
	 * db에 해당아이디가 저장되어 있는지 확인
	 * 
	 * @param memberId
	 * @return
	 */
	private boolean memberCheckId(String memberId) {
		boolean result = service.memberCheckId(memberId);
		return result;
	}

	/**
	 * 회원 로그인 화면
	 */
	private void memberlogin() {
		while (true) {
			HashMap<String, String> loginInfo = new HashMap<String, String>();
			System.out.println("┌───────────────────────┐");
			System.out.println("│	로그인 화면	│");
			System.out.println("└───────────────────────┘");
			System.out.print("  아이디 ▶   ");
			String loginId = sc.next();
			
			System.out.print("  비밀번호 ▶   ");
			String loginPw = sc.next();
			
			loginInfo.put("id", loginId);
			loginInfo.put("pw", loginPw);
			
			MemberVO mv = service.loginCheck(loginInfo);
			if (mv == null) {
				System.out.println("  ※     불일치  ※");
				if (exitMenu()) {
					return;
				}
				return;
			} else {
				member = mv;
				SizeVO sv = new SizeVO();
				Map<String, SizeVO> map = new HashMap<String, SizeVO>();
				map.put(loginId, sv);

				service.memberSummaryVO(map);
				System.out.println("  ♥  "+member.getMemberId() + "님 어서오세요!  ♥");
				break;
			}
		}
		cs();
		memberMenu();
	}

	/**
	 * 회원로그인 성공 시 화면
	 */
	private void memberMenu() {
		while (true) {
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          회원메뉴            │");
			System.out.println("└──────────────────────────┘");
			System.out.println("  1. 주문하기!");
			System.out.println("  2. 정보조회!");
			System.out.println("  3. 로그아웃!");
			System.out.println("  ◈  나가시려면 b나 B를 입력해주세요.◈ \n");
			System.out.print("  입력 ▶ ");
			String choice = sc.next();
			cs();
			switch (choice) {
			case "1":
				orderSize();
				cs();
				break;
			case "2":
				showMyInfo();
				if (member == null) {
					return;
				}
				cs();
				break;
			case "3":
				System.out.println("┌──────────────────────────┐");
				System.out.println("│          로그아웃            │");
				System.out.println("└──────────────────────────┘");
				member = null;
				cs();
				return;
			case "b":
			case "B":
				cs();
				return;
			default:
				System.out.println("  ※  잘못입력.. ※");
				break;

			}
		}
	}

	/**
	 * memberMenu() = 1. 내 정보 조회 내 정보 조회 화면
	 */
	private void showMyInfo() {
		while (true) {
			// 정보보여줌
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          정보조회            │");
			System.out.println("└──────────────────────────┘");
			System.out.println("  1. 비밀번호 변경!");
			System.out.println("  2. 현금충전!");
			System.out.println("  3. 회원탈퇴!");
			System.out.println("  ◈  나가시려면 b나 B를 입력해주세요.◈ \n");
			System.out.print("  입력 ▶ ");
			String choice = sc.next();
			cs();
			switch (choice) {
			case "1":
				changeMyInfo();
				cs();
				break;
			case "2":
				inputMoney();
				cs();
				break;
			case "3":
				if (removeMember()) {
					member = null;
					return;
				}
				cs();
				continue;
			case "b":
			case "B":
				cs();
				return;
			default:
				System.out.println("  ※  잘못입력.. ※");
				break;
			}
		}
	}

	/**
	 * showMyInfo() = 3. 회원탈퇴 회원탈퇴/삭제 화면
	 * 
	 * @return
	 */
	private boolean removeMember() {
		System.out.println("┌──────────────────────────┐");
		System.out.println("│          회원삭제            │");
		System.out.println("└──────────────────────────┘");
		System.out.print("  탈퇴할 회원의 아이디 입력 ▶ ");
		String memberId = sc.next();
		if (service.deleteMember(memberId)) {
			System.out.println("  ◈   삭제성공! ◈");
			return true;
		} else {
			System.out.println("  ◈   삭제실패! ◈");
			return false;
		}
	}

	/**
	 * showMyInfo() = 2. 포인트 충전 현금충전 화면
	 */
	private void inputMoney() {
		System.out.println("┌──────────────────────────┐");
		System.out.println("│          현금충전            │");
		System.out.println("└──────────────────────────┘");
		String inputMoney = "0";
		int currentMoney = service.chargeMoney(member.getMemberId(),
				Integer.parseInt(inputMoney));
		System.out.println("  현재 보유금액 " + currentMoney + "원\n");
		System.out.print("  충전할 금액 입력 ▶ ");
		try {
			while (Integer.parseInt(inputMoney) <= 0) {// 양수만 입력 가능
				inputMoney = sc.next();
				Matcher m = Pattern.compile("^[0-9]+$").matcher(inputMoney);
				if (!m.find()) {
					System.out.println("  ※  입력값이 올바르지 않습니다. ※");
					return;
				}
			}
			currentMoney = service.chargeMoney(member.getMemberId(),
					Integer.parseInt(inputMoney));
		} catch (Exception e) {
			System.out.println("  ※   충전가능한범위를 넘었습니다. ※");
		}
		System.out.println("  현재 보유금액 " + currentMoney + "원\n");
		cs();
	}

	/**
	 * showMyInfo() = 1. 비밀번호 변경 비밀번호 변경 화면
	 */
	private void changeMyInfo() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│          비밀번호 변경            │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("  아이디 : " + member.getMemberId() + "   비밀번호 : "
				+ member.getMemberPassword());
		System.out.print("  변경할 비밀번호를 입력해 주세요 ▶ ");
		String pass = sc.next();
		Map<String, String> changePw = new HashMap<String, String>();
		changePw.put("id", member.getMemberId());
		changePw.put("pw", pass);
		service.updateMemberInfo(changePw);
		cs();
		System.out.println("  ◈   변경되었습니다. ◈");
		this.member = service.loginCheck(changePw);
		System.out.println("  아이디 : " + member.getMemberId() + "   비밀번호 : "
				+ member.getMemberPassword());
	}

	/**
	 * 아이스크림 주문 화면 memberMenu() = 1. 주문하기!
	 */
	private void orderSize() {
		while (true) {
			RecordVO record = new RecordVO();
			SizeVO summaryset = new SizeVO();
			int sizeIndex = 0;
			Map<String, SizeVO> summarySave = new HashMap<String, SizeVO>();
			summarySave.put(member.getMemberId(), summaryset);
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          주문하기            │");
			System.out.println("└──────────────────────────┘");
			while (true) {
				orderSizeList(service.getSize());
				System.out.print("  원하시는 사이즈를 정해주세요 ▶ ");

				try {
					sizeIndex = Integer.parseInt(sc.next());
				} catch (NumberFormatException e) {
					System.out.println("  ◈   잘못된 입력입니다. ◈");
					continue;
				}

				if (sizeIndex >= 0
						&& (sizeIndex - 1) < service.getSize().size()) {
					if (member.getMbUserMoney() <= 0
							|| member.getMbUserMoney() < service.getSize()
									.get(sizeIndex - 1).getSizePrice()) {
						System.out.println("  ◈   현금이 부족합니다. ◈");
						return;
					} else {
						break;
					}
				} else {
					System.out.println("  ◈   잘못된 입력입니다. ◈");
					if (exitMenu()) {
						return;
					}
				}
			}
			cs();
			// 입력한 숫자-1의 인덱스에 해당하는 횟수만큼 반복
			SizeVO sizevo = service.getSize().get(sizeIndex - 1);
			for (int i = 0; i < sizevo.getSizeNum(); i++) {
				// 아이스크림 고르기
				int iceIndex = 0;
				int iceAmount = 0;
				while (true) {
					orderIceCreamList(service.memberGetIcecream());
					System.out.print("  "+(i + 1) + "번째 아이스크림을 정해주세요 ▶ ");
					try {
						iceIndex = Integer.parseInt(sc.next());
					} catch (NumberFormatException e) {
						System.out.println("  ◈   잘못된 입력입니다. ◈");
						continue;
					}
					if (iceIndex >= 0 && (iceIndex - 1) < service.memberGetIcecream().size()) {
						if (service.memberGetIcecream().get(iceIndex-1).getIcecreamNum()<=0) {
							System.out.println("재고가 부족합니다.");
						}else{
							System.out.println("  ◈   입력되었습니다. ◈");
							service.Order(iceIndex - 1);
							break;
						}
					} else {
						System.out.println("  ◈   잘못된 입력입니다. ◈");
						if (exitMenu()) {
							return;
						}
					}
				}
			}
			cs();
			// 구매내역에 추가해준다.
			record.setGoods(sizevo.getSizeName());
			record.setCount(1);
			record.setPrice(sizevo.getSizePrice());
			record.setTotalincome(sizevo.getSizePrice());
			service.recordAdd(record);

			// 해당회원의 영수증용 구매내역 추가
			summaryset.setSizeName(sizevo.getSizeName());
			summaryset.setSizePrice(sizevo.getSizePrice());
			summaryset.setSizeNum(1);
			summarySave.put(member.getMemberId(), summaryset);
			
			//가지고 있던 돈에서 금액뺴줌
			member.setMbUserMoney(member.getMbUserMoney()-sizevo.getSizePrice());

			service.memberSummaryVO(summarySave);
			showSummary(member);

			break;
		}
	}

	/**
	 * 해당회원의 영수증 화면출력용
	 * 
	 * @param member
	 */
	private void showSummary(MemberVO member) {
		System.out.println("─────────────────────────────────────────");
		System.out.println("    \t"+ member.getMemberId()+"님의 영수증    ");
		System.out.println("─────────────────────────────────────────");
		List<SizeVO> summary = service.memberGetSummary(member.getMemberId());
		System.out.println("  상품명\t\t구매수량\t금액");
		for (int i = 0; i < summary.size(); i++) {
			System.out.println(summary.get(i).getSizeName() + "\t\t"
					+ summary.get(i).getSizeNum() + "\t"
					+ summary.get(i).getSizePrice());
		}
		System.out.println();
		System.out.println("  ◈   총 구매 금액 " + service.allSum(member.getMemberId())
				+ "입니다. ◈");
		System.out.println("  ◈   현재 보유하고 있는 현금 : "+member.getMbUserMoney()+" ◈");
	}

	/**
	 * 컵 사이즈 메뉴 화면출력용
	 * 
	 * @param size
	 */
	private void orderSizeList(List<SizeVO> size) {
		System.out.println("─────────────────── 사이즈 종류 ────────────────────");
		System.out.println("상품번호\t상품명\t\t가짓수\t\t상품가격");
		for (int i = 0; i < size.size(); i++) {
			System.out.println(i + 1 + "." + "\t" + size.get(i).getSizeName()
					+ "\t\t" + size.get(i).getSizeNum() + "\t\t"
					+ size.get(i).getSizePrice());
		}
		System.out.println("──────────────────────────────────────────────────");
	}

	/**
	 * 아이스크림 메뉴 화면출력용
	 * 
	 * @param ice
	 */
	private void orderIceCreamList(List<IceCreamVO> ice) {
		System.out.println("──────────── 아이스크림 종류 ────────────");
		System.out.println("상품번호\t상품명\t\t수량");
		for (int i = 0; i < ice.size(); i++) {
			System.out.println(i + 1 + "." + "\t"
					+ ice.get(i).getIcecreamName() + "\t\t"
					+ ice.get(i).getIcecreamNum() + "\t\t");
		}
		System.out.println("─────────────────────────────────────");
	}

	/**
	 * mainMenu() = 2. 관리자니? 관리자 메뉴
	 */
	private void masterlogin() {
		String masterId;
		String masterPw;
		String back = "";
		while (true) {
			System.out.println("┌───────────────────────────────┐");
			System.out.println("│           관리자 페이지            │");
			System.out.println("└───────────────────────────────┘");
			System.out.print("  관리자 아이디 입력 ▶ ");
			masterId = sc.next();

			System.out.print("  관리자 패스워드 입력 ▶ ");
			masterPw = sc.next();
			Map<String, String> adminLogin = new HashMap<String, String>();
			adminLogin.put("masterId", masterId);
			adminLogin.put("masterPw", masterPw);
			if (service.adminLoginCheck(adminLogin)) {
				System.out.println("  ◈   로그인 성공 ◈");
				cs();
				masterMenu();
				return;
			} else {
				System.out.println("  ◈   로그인 실패 ◈");
				System.out.println("  ◈  나가시려면 b나 B를 입력해주세요.◈ \n");
				System.out.print("  다시입력 ▶ ");
				back = sc.next();
				if (back.equals("B") || back.equals("b")) {
					return;
				} else {
					continue;
				}
			}
		}
	}

	/**
	 * 관리자 로그인 성공 시 화면
	 */
	private void masterMenu() {
		while (true) {
			System.out.println("┌───────────────────────┐");
			System.out.println("│	관리자 메뉴	│");
			System.out.println("└───────────────────────┘");
			System.out.println("  1. 재고관리");
			System.out.println("  2. 회원관리");
			System.out.println("  3. 상품관리");
			System.out.println("  4. 매출관리");
			System.out.println("  ◈  나가시려면 b나 B를 입력해주세요.◈ \n");
			System.out.print("  입력 ▶ ");
			String choice = sc.next();
			cs();
			switch (choice) {
			case "1":
				storeMan();
				cs();
				break;
			case "2":
				memberMan();
				cs();
				break;
			case "3":
				productMan();
				cs();
				break;
			case "4":
				saleMan();
				cs();
				break;
			case "b":
			case "B":
				if (exitMenu(choice)) {
					return;
				}
			default:
				System.out.println("  ※  잘못입력.. ※");
				break;
			}

		}
	}

	/**
	 * masterMenu() = 4. 매출관리 매출관리 화면
	 */
	private void saleMan() {
		while (true) {
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          매출관리            │");
			System.out.println("└──────────────────────────┘");
			System.out.println("매출 조회");
			recordList(service.recordSale());
			cs();
			break;
		}
	}

	/**
	 * 관리자의 총 매출 화면출력용
	 * 
	 * @param record
	 */
	private void recordList(List<RecordVO> record) {
		int totalSum = 0;
		System.out.println("──────────── 총 매출 ────────────");
		System.out.println("번호\t상품명\t\t갯수\t\t상품가격\t\t총 합");
		for (int i = 0; i < record.size(); i++) {
			System.out.println(i + 1 + "." + "\t" + record.get(i).getGoods()
					+ "\t\t" + record.get(i).getCount() + "\t\t"
					+ record.get(i).getPrice() + "\t\t"
					+ record.get(i).getTotalincome());
			totalSum += record.get(i).getTotalincome();
		}
		System.out.println("총 매출 합 : " + totalSum);
		System.out.println("───────────────────────────────");
	}

	/**
	 * masterMenu() = 1. 재고관리 아이스크림 제고관리 화면
	 */
	private void storeMan() {
		while (true) {
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          재고관리            │");
			System.out.println("└──────────────────────────┘");
			orderIceCreamList(service.memberGetIcecream());
			System.out.println("재고주문을 하시겠습니까?");
			System.out.println("  Y|y. 재고주문");
			System.out.println("  N|n. 뒤로가기");
			System.out.print("  입력 ▶  ");
			String choice = sc.next();
			cs();
			switch (choice) {
			case "y":
			case "Y":
				addProduct();
				cs();
				break;
			case "n":
			case "N":
				break;
			default:
				System.out.println("  ※  잘못입력.. ※");
				break;
			}
			break;
		}
	}

	/**
	 * 아이스크림의 재고관리, 수량추가를 위한 메서드
	 */
	private void addProduct() {
		while (true) {
			int iceIndex = 0;
			int icenum = 0;
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          재고주문            │");
			System.out.println("└──────────────────────────┘");
			orderIceCreamList(service.memberGetIcecream());
			System.out.print("종류 선택 ▶ ");
			String choice = sc.next();

			System.out.print("수량 선택 ▶ ");
			String num = sc.next();

			try {
				iceIndex = Integer.parseInt(choice);
				icenum = Integer.parseInt(num);
				System.out.println("  ◈   정상 저장 ◈");
			} catch (NumberFormatException e) {
				System.out.println("  ◈   잘못된 입력입니다. ◈");
				continue;
			}
			if (iceIndex >= 0
					&& (iceIndex - 1) < service.memberGetIcecream().size()) {
				Map<String, Integer> productAdd = new HashMap<String, Integer>();
				productAdd.put("iceIndex", iceIndex - 1);
				productAdd.put("icenum", icenum);
				service.productAdd(productAdd);
				cs();
				orderIceCreamList(service.memberGetIcecream());
				System.out.println("  추가 주문을 하시겠습니까?");
				System.out.println("  Y|y. 추가주문");
				System.out.println("  N|n. 뒤로가기");
				System.out.print("  입력 ▶  ");
				String choice2 = sc.next();
				cs();
				if (choice2.equals("y") || choice2.equals("Y")) {
					continue;
				} else {
					return;
				}
			} else {
				System.out.println("  ◈   잘못된 입력입니다. ◈");
				if (exitMenu()) {
					return;
				}
			}
		}
	}

	/**
	 * masterMenu() = 2. 회원관리 관리자의 회원관리 화면
	 */
	private void memberMan() {
		while (true) {
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          회원관리            │");
			System.out.println("└──────────────────────────┘");
			List<MemberVO> mlist = service.memberAll();
			System.out.println("───────── 회원리스트 ─────────");
			for (int i = 0; i < mlist.size(); i++) {
				System.out.println(mlist.get(i).getMemberId() + "\t\t"
						+ mlist.get(i).getMbUserMoney());
			}
			System.out.println("─────────────────────────────");
			System.out.println("  회원을 삭제하시겠습니까?(y/n)");
			System.out.println("  Y|y. 회원삭제");
			System.out.println("  N|n. 뒤로가기");
			System.out.print("  입력 ▶  ");
			String choice = sc.next();
			cs();
			switch (choice) {
			case "y":
			case "Y":
				removeMember();
				cs();
				break;
			case "n":
			case "N":
				return;
			default:
				System.out.println("잘못입력..");
				break;
			}
		}

	}

	/**
	 * masterMenu() = 3. 상품관리 상품관리 화면
	 */
	private void productMan() {
		orderSizeList(service.getSize());
		while (true) {
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          상품관리            │");
			System.out.println("└──────────────────────────┘");
			System.out.println("  상품가격을 변동 하시겠습니까?");
			System.out.println("  Y|y. 가격수정");
			System.out.println("  N|n. 뒤로가기");
			System.out.print("  입력 ▶  ");
			String choice = sc.next();
			cs();
			switch (choice) {
			case "y":
			case "Y":
				changeCash();
				cs();
				break;
			case "n":
			case "N":
				return;
			default:
				System.out.println("잘못입력..");
				break;
			}
		}
	}

	/**
	 * 컵의 판매금액을 변경하는 화면출력
	 */
	private void changeCash() {
		while (true) {
			int sizeIndex = 0;
			int sizenum = 0;
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          가격수정            │");
			System.out.println("└──────────────────────────┘");
			System.out.print("  변경할 컵의 번호를 입력해주세요 ▶ ");
			String choice = sc.next();
			System.out.print("  변경할 컵의 금액을 입력해주세요 ▶ ");
			String num = sc.next();

			try {
				sizeIndex = Integer.parseInt(choice);
				sizenum = Integer.parseInt(num);
			} catch (NumberFormatException e) {
				System.out.println("  ◈   잘못된 입력입니다. ◈");
				continue;
			}
			
			if (sizenum<=0) {
				System.out.println("  ◈   잘못된 입력입니다. (양수만 가능) ◈");
			}else{
				if (sizeIndex >= 0
						&& (sizeIndex - 1) < service.memberGetIcecream().size()) {
					Map<String, Integer> tmp = new HashMap<String, Integer>();
					tmp.put("Size", sizeIndex - 1);
					tmp.put("Price", sizenum);
					service.productChg(tmp);
					if (service.productChg(tmp)) {
						orderSizeList(service.getSize());
						cs();
						return;
					} else {
						continue;
					}
				} else {
					System.out.println("  ◈   잘못된 입력입니다. ◈");
					if (exitMenu()) {
						return;
					}
				}
			}
			break;
		}

	}
}
