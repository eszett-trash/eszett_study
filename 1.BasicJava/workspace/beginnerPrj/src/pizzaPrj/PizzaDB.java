package pizzaPrj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PizzaDB {

	private static PizzaDB Instance = new PizzaDB();

	public static PizzaDB getInstance() {
		return Instance;
	}

	// 유저
	private List<UserVO> userVo = new ArrayList<UserVO>();
	// 메뉴
	private List<MenuVO> menuVo = new ArrayList<MenuVO>();
	// 추가/사이즈등등등
	private List<AdditionalVO> additionalVo = new ArrayList<AdditionalVO>();
	// 장바구니 (유저에 종속되어야 함)
	private List<CartVO> cartVo = new LinkedList<CartVO>();

	private List<InventoryVo> inventoryVo = new ArrayList<InventoryVo>();

	private PizzaDB() {
		// 최고관리자 생성
		UserVO uv = new UserVO();
		uv.setEmail("admin");
		uv.setPwd("q1234q");
		uv.setAdmin(true);
		userVo.add(uv);

		UserVO uv2 = new UserVO();
		uv2.setEmail("qwer");
		uv2.setPwd("q1234q");
		userVo.add(uv2);

	}

	// 로그인
	public int login(String email, String pwd) {
		for (int i = 0; i < userVo.size(); i++) {
			if (userVo.get(i).getEmail().equals(email)) {
				if (userVo.get(i).getPwd().equals(pwd)) {
					if (userVo.get(i).isAdmin()) {
						System.out.println("관리자입니다");
						return 1;
					} else {
						System.out.println("일반 유저입니다.");
						return 0;
					}
				} else {
					System.out.println("비밀번호 입력 오류");
					return -1;
				}
			}
		}
		return -1;
	}

	// 회원가입
	public boolean join(String nickname, String email, String password,
			String address, int hp, boolean isAdmin) {
		if (nickname == null || email == null || password == null
				|| address == null || hp == 0) {
			System.out.println("잘못 입력하셨습니다.");
			return false;
		} else {
			for (int i = 0; i < userVo.size(); i++) {
				if (userVo.get(i).getEmail().equals(email)) {// 아이디가 같으면
					System.out.println("이미 존재하는 이메일입니다.");
					return false;
				}
			}
			UserVO uv = new UserVO();
			uv.setNickname(nickname);
			uv.setEmail(email);
			uv.setPwd(password);
			uv.setAddress(address);
			uv.setPhone(hp);
			if (!uv.isAdmin()) {
				uv.setAdmin(true);
			}
			userVo.add(uv);
			return true;
		}
	}

	// 관리자 리스트
	public void show_admin() {
		for (int i = 0; i < userVo.size(); i++) {
			if (userVo.get(i).isAdmin()) {
				System.out.println("닉네임 : " + userVo.get(i).getNickname());
				System.out.println("이메일 : " + userVo.get(i).getEmail());
			}
		}
	}

	// 재료 재고 출력
	public boolean show_inven() {
		if (inventoryVo.size() == 0) {
			return false;
		} else {
			for (int i = 0; i < inventoryVo.size(); i++) {
				System.out.print(inventoryVo.get(i).getId() + " | "
						+ inventoryVo.get(i).getName() + " | "
						+ inventoryVo.get(i).getRemine());
				switch (inventoryVo.get(i).getKind()) {
				case 1:
					System.out.println(" | 사이드메뉴");
					break;
				case 2:
					System.out.println(" | 토핑");
					break;
				case 3:
					System.out.println(" | 도우");
					break;
				case 4:
					System.out.println(" | 음료");
					break;
				default:
					System.out.println(" | 기타");
					break;
				}
			}
			return true;
		}
	}

	// 재료 갯수 추가/삭제
	public void update_inven(int id, int remine) {
		int setRemine = 0;
		for (int i = 0; i < inventoryVo.size(); i++) {
			if (inventoryVo.get(i).getId() == id) {
				setRemine = inventoryVo.get(i).getRemine() + remine;
				inventoryVo.get(i).setRemine(setRemine);
			}
		}
	}

	// 재료 품목 추가
	public boolean update_inven(String name, int kind, int use) {
		int addTail = inventoryVo.size();
		InventoryVo iv = new InventoryVo();
		iv.setId(setinvenId(kind));
		iv.setKind(kind);
		iv.setName(name);
		iv.setUse(use);
		inventoryVo.add(addTail, iv);
		return false;
	}

	private int setinvenId(int kind) {
		int temp = 1;
		for (int i = 0; i < inventoryVo.size(); i++) {
			if (inventoryVo.get(i).getKind() == kind) {
				temp++;
			}
		}
		return temp + kind * 10000;
	}

	// 재료 품목 삭제
	public boolean delete_inven(int id) {
		for (int i = 0; i < inventoryVo.size(); i++) {
			if (inventoryVo.get(i).getId() == id) {
				if (inventoryVo.get(i).getRemine() == 0) {
					inventoryVo.remove(i);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	// 메뉴 출력
	public void show_menu(boolean total) {
		for (int i = 0; i < menuVo.size(); i++) {
			if (menuVo.get(i).getId() / 1000 == 0 || total) {
				System.out.print("ID : " + menuVo.get(i).getId() + " | ");
				System.out.print("이름 : " + menuVo.get(i).getName() + " | ");
				System.out.println("가격 : " + menuVo.get(i).getPrice());
			} else if (menuVo.get(i).getId() / 100000 > 0 || total) {
				System.out.print("ID : " + menuVo.get(i).getId() + " | ");
				System.out.print("이름 : " + menuVo.get(i).getName() + " | ");
				System.out.println("가격 : " + menuVo.get(i).getPrice());
			}
		}
		if (total) {
			show_sidemenu();
		}
	}

	// 메뉴추가
	public void add_menu(String name, int price) {
		MenuVO mv = new MenuVO();
		int temp = 0;
		for (int i = 0; i < inventoryVo.size(); i++) {
			if (inventoryVo.get(i).getKind() == 2) {
				System.out.println(++temp+ " | "
						+ inventoryVo.get(i).getName());
			}
		}
		mv.setId(setmenuId());
		mv.setName(name);
		mv.setPrice(price);
		menuVo.add(mv);
	}
		private int setmenuId(){
			//TODO 아이디셋팅
			return 0;
		}

		
	//피자보기
	public void show_pizzamenu()
	{
		for (int i = 0; i < menuVo.size(); i++) {
			if (menuVo.get(i).getId() / 1000 == 0) {
				System.out.print("ID : " + menuVo.get(i).getId() + " | ");
				System.out.print("이름 : " + menuVo.get(i).getName() + " | ");
				System.out.println("가격 : " + menuVo.get(i).getPrice());
			}
		}
	}
	//사이드 보기
	public void show_sidemenu()
	{
		for (int i = 0; i < inventoryVo.size(); i++) {
			if (inventoryVo.get(i).getKind() == 1) {
				System.out.print("ID : " + inventoryVo.get(i).getId()
						+ " | ");
				System.out.print("이름 : " + inventoryVo.get(i).getName()
						+ " | ");
				System.out.println("가격 : " + inventoryVo.get(i).getPrice());
			}
		}
	}
	//이벤트 보기
	public void show_eventmenu()
	{
		for (int i = 0; i < menuVo.size(); i++) {
			if (menuVo.get(i).getId() / 100000 > 0) {
				System.out.print("ID : " + menuVo.get(i).getId() + " | ");
				System.out.print("이름 : " + menuVo.get(i).getName() + " | ");
				System.out.println("가격 : " + menuVo.get(i).getPrice());
			}
		}
	}








}
