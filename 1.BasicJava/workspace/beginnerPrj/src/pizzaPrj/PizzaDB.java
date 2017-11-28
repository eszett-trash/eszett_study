package pizzaPrj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PizzaDB {
	// 유저
	private List<UserVO> userVo = new ArrayList<UserVO>();
	// 메뉴
	private List<MenuVO> menuVo = new ArrayList<MenuVO>();
	// 추가/사이즈등등등
	private List<AdditionalVO> additionalVo = new ArrayList<AdditionalVO>();
	// 장바구니 (유저에 종속되어야 함)
	private List<CartVO> cartVo = new LinkedList<CartVO>();

	PizzaDB() {
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
			System.out.println("입력란을 전부 채워주세요");
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

	public void show_admin() {
		for (int i = 0; i < userVo.size(); i++) {
			if (userVo.get(i).isAdmin()) {
				System.out.println("닉네임 : " + userVo.get(i).getNickname());
				System.out.println("이메일 : " + userVo.get(i).getEmail());
			}
		}
	}

}
